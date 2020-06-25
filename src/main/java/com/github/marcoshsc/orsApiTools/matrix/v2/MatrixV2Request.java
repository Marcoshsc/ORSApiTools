package com.github.marcoshsc.orsApiTools.matrix.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.marcoshsc.orsApiTools.directions.enums.EnumMetrics;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.interfaces.Request;
import com.github.marcoshsc.orsApiTools.matrix.MatrixUtilityMethods;
import com.github.marcoshsc.orsApiTools.matrix.helperclasses.MatrixRequestOptions;
import com.github.marcoshsc.orsApiTools.matrix.v2.helperclasses.Location;
import com.github.marcoshsc.orsApiTools.matrix.v2.parameters.Destinations;
import com.github.marcoshsc.orsApiTools.matrix.v2.parameters.Locations;
import com.github.marcoshsc.orsApiTools.matrix.v2.parameters.Profile;
import com.github.marcoshsc.orsApiTools.matrix.v2.parameters.Sources;
import com.github.marcoshsc.orsApiTools.urlUtils.UrlBuilder;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import lombok.Getter;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.locationtech.jts.geom.Coordinate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class MatrixV2Request implements Request<MatrixV2Response> {

    private final MatrixV2Parameters parameters = new MatrixV2Parameters();
    private final Map<String, String> headers = new HashMap<>();

    public MatrixV2Request(String apiKey) {
        headers.put("Authorization", apiKey);
    }

    /**
     * Make the request with parameters and headers set.
     * @return final response
     * @throws RequestException if something goes wrong with the response.
     * @throws InvalidParameters if something goes wrong with the parameters. See verifyErrors method.
     */
    @Override
    public MatrixV2Response makeRequest() throws RequestException, InvalidParameters {
        try {
            return getConfiguratedResponse();
        } catch (UnsupportedEncodingException | JSONException exc) {
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
    private MatrixV2Response getConfiguratedResponse() throws RequestException, InvalidParameters, JSONException, UnsupportedEncodingException {
        Profile profile = parameters.getProfile();
        if(profile == null) throw new InvalidParameters("No profile was provided.");
        List<Coordinate> locations = new ArrayList<>(parameters.getLocations().getLocations());
        List<Integer> sources = parameters.getSources() != null ?
                new ArrayList<>(parameters.getSources().getSources()) :
                UtilityFunctions.getIntegerList(0, locations.size());
        List<Integer> destinations = parameters.getDestinations() != null ?
                new ArrayList<>(parameters.getDestinations().getDestinations()) :
                UtilityFunctions.getIntegerList(0, locations.size());
        MatrixV2Response res = handleMultipleCoordinates();
        boolean hasDistances = parameters.getMetrics().getMetrics().contains(EnumMetrics.DISTANCE),
                hasDurations = parameters.getMetrics().getMetrics().contains(EnumMetrics.DURATION);
        if(hasDistances)
            MatrixUtilityMethods.verifyMatrix(res.getDistances(), sources, destinations);
        if(hasDurations)
            MatrixUtilityMethods.verifyMatrix(res.getDurations(), sources, destinations);
        MatrixRequestOptions options = new MatrixRequestOptions();
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
    private MatrixV2Response handleMultipleCoordinates() throws RequestException, JSONException{
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
            return sources.getSources().size() * destinations.getDestinations().size() < 3500;
        if(sources != null)
            return sources.getSources().size() * locations.getLocations().size() < 3500;
        if(destinations != null)
            return destinations.getDestinations().size() * locations.getLocations().size() < 3500;
        return locations.getLocations().size() * locations.getLocations().size() < 3500;
    }

    /**
     * Split the list of coordinates, makes the requests, concatenate them together and return the final response.
     * @return the final matrix response
     * @throws RequestException if something goes wrong with the request.
     * @throws JSONException if some JSON parsing error was encountered.
     */
    private MatrixV2Response handleWithSourceAndDestination() throws RequestException, JSONException {
        Locations locations = parameters.getLocations();
        List<Integer> sourceIndexes = parameters.getSources() != null ? parameters.getSources().getSources() :
                UtilityFunctions.getIntegerList(0, locations.getLocations().size());
        List<Integer> destinationIndexes = parameters.getDestinations() != null ? parameters.getDestinations().getDestinations()
                : UtilityFunctions.getIntegerList(0, locations.getLocations().size());
        List<Coordinate> sources = new ArrayList<>();
        List<Coordinate> destinations = new ArrayList<>();
        for (Integer sourceIndex : sourceIndexes) {
            sources.add(locations.getLocations().get(sourceIndex));
        }
        for (Integer destinationIndex : destinationIndexes) {
            destinations.add(locations.getLocations().get(destinationIndex));
        }
//        MatrixV2Response finalResponse = null;
//        int sourceFinalLength = sources.size() % 59;
//        int destinationFinalLength = destinations.size() % 59;
        return sources.size() <= destinations.size() ?
                getResponse(sources, destinations) : 
                transposeResponse(getResponse(destinations, sources));
    }

    private MatrixV2Response getResponse(List<Coordinate> sources, List<Coordinate> destinations)
            throws RequestException {
        MatrixV2Response finalResponse = null;
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

    private MatrixV2Response transposeResponse(MatrixV2Response response) {
        List<List<Double>> newDurations = getNewDurations(response);
        List<List<Double>> newDistances = getNewDistances(response);
        List<Location> newSources = response.getDestinations();
        List<Location> newDestinations = response.getSources();
        return new MatrixV2Response(newDurations, newDistances, newSources, newDestinations);
    }

    private List<List<Double>> getNewDurations(MatrixV2Response response) {
        if(response.getDurations() == null) return null;
        List<List<Double>> durations = response.getDurations();
        return transposeMatrix(response, durations);
    }

    private List<List<Double>> getNewDistances(MatrixV2Response response) {
        if(response.getDistances() == null) return null;
        List<List<Double>> distances = response.getDistances();
        return transposeMatrix(response, distances);
    }

    private List<List<Double>> transposeMatrix(MatrixV2Response response, List<List<Double>> durations) {
        List<List<Double>> newDurations = new ArrayList<>();
        for (int i = 0; i < response.getDestinations().size(); i++) {
            newDurations.add(new ArrayList<>());
        }
        for (List<Double> row : durations) {
            for (int j = 0; j < row.size(); j++)
                newDurations.get(j).add(row.get(j));
        }
        return newDurations;
    }

    /**
     *
     * @param destinations list of destinations
     * @param finalResponse the matrix response to be returned at the end.
     * @param outerList list of source coordinates.
     * @return final response.
     * @throws JSONException if some JSON parsing error was encountered.
     * @throws RequestException if something goes wrong with the request.
     */
    private MatrixV2Response getResponseFromLoop(List<Coordinate> destinations, MatrixV2Response finalResponse,
                                                 List<Coordinate> outerList)
            throws JSONException, RequestException {
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
                    MatrixV2Response.concatNewLine(finalResponse, makeSimpleRequest());
                else
                    MatrixV2Response.concatNewColumns(finalResponse, makeSimpleRequest());
            }
            currentIndex = currentListSize;
        }
        return finalResponse;
//        if(destinationFinalLength == destinations.size()) {
//            configureParameters(outerList, destinations);
//            if(finalResponse == null) return makeSimpleRequest();
//            MatrixV2Response.concatNewLine(finalResponse, makeSimpleRequest());
//            return finalResponse;
//        }
//        for (int j = 0; j < destinations.size() - destinationFinalLength; j += 59) {
//            List<Coordinate> innerList = destinations.subList(j, j + 59);
//            configureParameters(outerList, innerList);
//            if(finalResponse == null)
//                finalResponse = makeSimpleRequest();
//            else {
//                if(j == 0)
//                    MatrixV2Response.concatNewLine(finalResponse, makeSimpleRequest());
//                else
//                    MatrixV2Response.concatNewColumns(finalResponse, makeSimpleRequest());
//            }
//        }
//        if(destinationFinalLength != 0) {
//            List<Coordinate> innerList = destinations.subList(destinations.size() - destinationFinalLength, destinations.size());
//            configureParameters(outerList, innerList);
//            MatrixV2Response.concatNewColumns(finalResponse, makeSimpleRequest());
//        }
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
     * @throws RequestException if something goes wrong with the request.
     */
    private MatrixV2Response makeSimpleRequest() throws RequestException {
        try {
            HttpResponse response = makeHttpRequest();
            UtilityFunctions.handleOSMStatusCode(response);
            String json = EntityUtils.toString(response.getEntity());
            System.out.println(json);
            return new ObjectMapper().readValue(json, MatrixV2Response.class);
        } catch (IOException exc) {
            throw new RequestException("Error with the request. Log: " + exc.getMessage());
        }
    }

    private HttpResponse makeHttpRequest() throws IOException {
        Profile profile = parameters.getProfile();
        if(profile == null) throw new IllegalArgumentException("No profile defined.");
        UrlBuilder builder = new UrlBuilder();
        builder.addBaseUrl("https://api.openrouteservice.org/v2/matrix");
        builder.addPathParam(profile.getProfile());
        String json = new ObjectMapper().writeValueAsString(parameters);
        System.out.println(json);
        return UtilityFunctions.postHttpRequest(builder.build(), json, headers);
    }

}
