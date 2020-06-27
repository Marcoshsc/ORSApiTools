package com.github.marcoshsc.orsApiTools.matrix.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.marcoshsc.orsApiTools.directions.enums.EnumMetrics;
import com.github.marcoshsc.orsApiTools.directions.enums.UnitsEnum;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.interfaces.Request;
import com.github.marcoshsc.orsApiTools.general.parameters.ApiKey;
import com.github.marcoshsc.orsApiTools.matrix.general.helperclasses.Location;
import com.github.marcoshsc.orsApiTools.matrix.general.helperclasses.MatrixRequestOptions;
import com.github.marcoshsc.orsApiTools.matrix.general.utils.MatrixUtilityMethods;
import com.github.marcoshsc.orsApiTools.matrix.v1.errorhandlers.MatrixStatusCodeHandler;
import com.github.marcoshsc.orsApiTools.matrix.v1.parameters.Destinations;
import com.github.marcoshsc.orsApiTools.matrix.v1.parameters.Locations;
import com.github.marcoshsc.orsApiTools.matrix.v1.parameters.Sources;
import com.github.marcoshsc.orsApiTools.urlUtils.UrlBuilder;
import com.github.marcoshsc.orsApiTools.utils.ConcreteStatusCodeHandler;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import com.github.marcoshsc.orsApiTools.utils.superclasses.StatusCodeHandlerContext;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Make requests to the /matrix endpoint of the ORS API. There is support for any coordinate size, not like the ORS API
 * itself that can't return a matrix with more than 3500 positions. User must set their parameters, headers and send the
 * call makeRequest to get a response. A call to this method can last for several minutes depending on the locations size.
 * https://openrouteservice.org/dev/#/api-docs/matrix/get for more information.
 *
 * @author Marcos Henrique
 */
public class ORSMatrixRequest implements Request<MatrixResponse> {
    private final MatrixParameters parameters = new MatrixParameters();
    private final Map<String, String> headers = new HashMap<>();

    /**
     * Just a API key is needed to construct the class
     *
     * @param apiKey the api key to be used
     */
    public ORSMatrixRequest(String apiKey) {
        parameters.setApiKey(new ApiKey(apiKey));
        configureDefaultHeaders();
    }


    /**
     * Make the request with parameters and headers set.
     * @return final response
     * @throws RequestException if something goes wrong with the response.
     * @throws InvalidParameters if something goes wrong with the parameters. See verifyErrors method.
     */
    @Override
    public MatrixResponse makeRequest() throws RequestException, InvalidParameters {
        try {
            return getConfiguratedResponse();
        } catch (UnsupportedEncodingException | JSONException | JsonProcessingException exc) {
            throw new RequestException(exc.getMessage());
        }
    }

    /**
     * Puts location, sources and destinations at the response options, to further query.
     * @return a response with all fields possible.
     * @throws RequestException if something goes wrong with the response.
     * @throws InvalidParameters if something goes wrong with the parameters. See verifyErrors method.
     * @throws JSONException if some JSON parsing error was encountered.
     * @throws UnsupportedEncodingException if some character in the URL built could not be encoded.
     */
    private MatrixResponse getConfiguratedResponse() throws RequestException, InvalidParameters, JSONException, UnsupportedEncodingException, JsonProcessingException {
        List<Coordinate> locations = new ArrayList<>(parameters.getLocations().getTypedValue());
        List<Integer> sources = parameters.getSources() != null ? new ArrayList<>(parameters.getSources().getTypedValue()) :
                UtilityFunctions.getIntegerList(0, locations.size());
        List<Integer> destinations = parameters.getDestinations() != null ? new ArrayList<>(parameters.getDestinations().getTypedValue())
                : UtilityFunctions.getIntegerList(0, locations.size());
        MatrixResponse res = handleMultipleCoordinates();
        boolean hasDistances = parameters.getMetrics().getTypedValue().contains(EnumMetrics.DISTANCE),
                hasDurations = parameters.getMetrics().getTypedValue().contains(EnumMetrics.DURATION);
        if(hasDistances)
            MatrixUtilityMethods.verifyMatrix(res.getDistances(), sources, destinations);
        if(hasDurations)
            MatrixUtilityMethods.verifyMatrix(res.getDurations(), sources, destinations);
        MatrixRequestOptions options = new MatrixRequestOptions(parameters.getProfile().getTypedValue(),
                parameters.getUnits() == null ? UnitsEnum.METERS : parameters.getUnits().getTypedValue());
        options.setLocations(locations);
        options.setSources(sources);
        options.setDestinations(destinations);
        res.setOptions(options);
        return res;
    }

    /**
     * Makes possible to handle more than 3500 positions in the final matrix. It looks at the location coordinates, if
     * its size is lower than 60, make a single request and return the response. Otherwise, it will call a separated
     * method, which will split the coordinates into smaller groups, make separated request, and group them all together
     * at the end, returning a equivalent final response.
     * @return final response referent to the parameters received.
     * @throws RequestException if something goes wrong with the request.
     * @throws InvalidParameters if something goes wrong with the parameters. See verifyErrors method.
     * @throws JSONException if some JSON parsing error was encountered.
     * @throws UnsupportedEncodingException if some character in the URL built could not be encoded.
     */
    private MatrixResponse handleMultipleCoordinates() throws RequestException, InvalidParameters, JSONException,
            UnsupportedEncodingException, JsonProcessingException {
        if(isHandledBySingleRequest())
            return makeSimpleRequest();
        return handleWithSourceAndDestination();
    }

    /**
     * Return true if the request has enough size to be handled by one single request.
     * @return condition evaluation.
     */
    private boolean isHandledBySingleRequest() {
        Locations locations = parameters.getLocations();
        Sources sources = parameters.getSources();
        Destinations destinations = parameters.getDestinations();
        if(sources != null && destinations != null)
            return sources.getTypedValue().size() * destinations.getTypedValue().size() < 3500;
        if(sources != null)
            return sources.getTypedValue().size() * locations.getTypedValue().size() < 3500;
        if(destinations != null)
            return destinations.getTypedValue().size() * locations.getTypedValue().size() < 3500;
        return locations.getTypedValue().size() * locations.getTypedValue().size() < 3500;
    }

    /**
     * Split the list of coordinates, makes the requests, concatenate them together and return the final response.
     * @return the final matrix response
     * @throws RequestException if something goes wrong with the request.
     * @throws InvalidParameters if something goes wrong with the parameters. See verifyErrors method.
     * @throws JSONException if some JSON parsing error was encountered.
     * @throws UnsupportedEncodingException if some character in the URL built could not be encoded.
     */
    private MatrixResponse handleWithSourceAndDestination() throws RequestException, InvalidParameters, JSONException,
            UnsupportedEncodingException, JsonProcessingException {
        Locations locations = parameters.getLocations();
        List<Integer> sourceIndexes = parameters.getSources() != null ? parameters.getSources().getTypedValue() :
                UtilityFunctions.getIntegerList(0, locations.getTypedValue().size());
        List<Integer> destinationIndexes = parameters.getDestinations() != null ? parameters.getDestinations().getTypedValue()
                : UtilityFunctions.getIntegerList(0, locations.getTypedValue().size());
        List<Coordinate> sources = new ArrayList<>();
        List<Coordinate> destinations = new ArrayList<>();
        for (Integer sourceIndex : sourceIndexes) {
            sources.add(locations.getTypedValue().get(sourceIndex));
        }
        for (Integer destinationIndex : destinationIndexes) {
            destinations.add(locations.getTypedValue().get(destinationIndex));
        }
        return sources.size() <= destinations.size() ?
                getResponse(sources, destinations) :
                transposeResponse(getResponse(destinations, sources));
    }

    /**
     *
     * @param destinations list of destinations
     * @param finalResponse the matrix response to be returned at the end.
     * @param outerList list of source coordinates.
     * @return final response.
     * @throws JSONException if some JSON parsing error was encountered.
     * @throws InvalidParameters if something goes wrong with the parameters. See verifyErrors method.
     * @throws UnsupportedEncodingException if some character in the URL built could not be encoded.
     * @throws RequestException if something goes wrong with the request.
     */
    private MatrixResponse getResponseFromLoop(List<Coordinate> destinations, MatrixResponse finalResponse,
                                               List<Coordinate> outerList)
            throws JSONException, InvalidParameters, UnsupportedEncodingException, RequestException, JsonProcessingException {
        int outerListSize = outerList.size(), destinationsSize = destinations.size();
        int currentIndex = 0;
        while(currentIndex < destinationsSize) {
            int currentDestinationsSize = 3500 / outerListSize;
            int currentListSize = currentIndex + currentDestinationsSize;
            List<Coordinate> currentDestinationList = currentListSize > destinationsSize ?
                    destinations.subList(currentIndex, destinationsSize) :
                    destinations.subList(currentIndex, currentListSize);
            System.out.println(String.format("making request from %d to %d destination coord.", currentIndex,
                    currentListSize > destinationsSize ? destinationsSize - 1 : currentListSize - 1));
            configureParameters(outerList, currentDestinationList);
            if(finalResponse == null)
                finalResponse = makeSimpleRequest();
            else {
                if (currentIndex == 0)
                    finalResponse.concatNewLine(makeSimpleRequest());
                else
                    finalResponse.concatNewColumns(makeSimpleRequest());
                finalResponse.incrementCounter();
            }
            currentIndex = currentListSize;
        }
        return finalResponse;
    }

    private MatrixResponse transposeResponse(MatrixResponse response) {
        List<List<Double>> newDurations = MatrixUtilityMethods.getNewDurations(response);
        List<List<Double>> newDistances = MatrixUtilityMethods.getNewDistances(response);
        List<Location> newSources = response.getDestinations();
        List<Location> newDestinations = response.getSources();
        return new MatrixResponse(newDurations, newDistances, newSources, newDestinations);
    }

    private MatrixResponse getResponse(List<Coordinate> sources, List<Coordinate> destinations)
            throws RequestException, UnsupportedEncodingException, InvalidParameters, JsonProcessingException {
        MatrixResponse finalResponse = null;
        int sourceFinalLength = sources.size() % 59;
        for (int i = 0; i < sources.size() - sourceFinalLength; i += 59) {
            List<Coordinate> outerList = sources.subList(i, i + 59);
            finalResponse = getResponseFromLoop(destinations, finalResponse, outerList);
        }
        if(sourceFinalLength != 0) {
            List<Coordinate> outerList = sources.subList(sources.size() - sourceFinalLength, sources.size());
            finalResponse = getResponseFromLoop(destinations, finalResponse, outerList);
        }
        return finalResponse;
    }

    private void configureParameters(List<Coordinate> outerList, List<Coordinate> innerList) {
        List<Coordinate> concatenatedList = MatrixUtilityMethods.concatLists(outerList, innerList);
        List<Integer> sourceIndexes = UtilityFunctions.getIntegerList(0, outerList.size());
        List<Integer> destinationIndexes = UtilityFunctions.getIntegerList(outerList.size(), innerList.size() + outerList.size());
        parameters.setLocations(new Locations(concatenatedList));
        parameters.setSources(new Sources(sourceIndexes));
        parameters.setDestinations(new Destinations(destinationIndexes));
    }

    /**
     * Make a simple request to the API, parses and return the result.
     * @return response from the API parsed into java object.
     * @throws JSONException if some JSON parsing error was encountered.
     * @throws InvalidParameters if something goes wrong with the parameters. See verifyErrors method.
     * @throws UnsupportedEncodingException if some character in the URL built could not be encoded.
     * @throws RequestException if something goes wrong with the request.
     */
    private MatrixResponse makeSimpleRequest() throws InvalidParameters,
            UnsupportedEncodingException, RequestException, JsonProcessingException {
        verifyErrors();
        String URL = buildURL();
        StatusCodeHandlerContext statusCodeContext = new ConcreteStatusCodeHandler(new MatrixStatusCodeHandler());
        JSONObject responseJSON = UtilityFunctions.makeHTTPRequest(URL, headers, statusCodeContext);
        return new ObjectMapper().readValue(responseJSON.toString(), MatrixResponse.class);
    }

    /**
     * A request can not proceed if: api key, profile or locations parameters are missing
     * @throws InvalidParameters if some of the listed errors above happened.
     */
    private void verifyErrors() throws InvalidParameters {
        boolean error = parameters.getApiKey() == null ||
                parameters.getProfile() == null ||
                parameters.getLocations() == null;
        if(error)
            throw new InvalidParameters("Api key, profile and locations must be specified.");
    }

    private String buildURL() throws UnsupportedEncodingException {
        UrlBuilder builder = new UrlBuilder();
        builder.addBaseUrl(ORSEnum.BASE_URL);
        builder.addPathParam(ORSEnum.MATRIX_PATH);
        builder.addQueryParam(parameters);
        return builder.build();
    }

    private void configureDefaultHeaders() {
        headers.put("Accept", "application/json; charset=utf-8");
    }

    public MatrixParameters getParameters() {
        return parameters;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

}
