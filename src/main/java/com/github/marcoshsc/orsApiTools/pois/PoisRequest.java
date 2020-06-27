package com.github.marcoshsc.orsApiTools.pois;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.interfaces.Request;
import com.github.marcoshsc.orsApiTools.pois.enums.PoisRequestEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.SortByEnum;
import com.github.marcoshsc.orsApiTools.urlUtils.UrlBuilder;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import lombok.Getter;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Implements a request to the pois endpoint in the ORS API. Docs in https://openrouteservice.org/dev/#/api-docs/pois/post.
 *
 * @author Marcos Henrique
 */
@Getter
public class PoisRequest implements Request<PoisResponse> {

    private final PoisParameters parameters = new PoisParameters();
    private final Map<String, String> headers = new HashMap<>();

    /**
     *
     * @param apiKey the api key to be used
     */
    public PoisRequest(String apiKey) {
        configureDefaultHeaders(apiKey);
    }

    /**
     * Make the request and return a response as Java object.
     * @return a java object representing the response fields.
     * @throws RequestException if something goes wrong with the response.
     * @throws InvalidParameters if the parameters are incorrect.
     */
    @Override
    public PoisResponse makeRequest() throws RequestException, InvalidParameters {
        try {
            ObjectMapper mapper = new ObjectMapper();
            verifyErrors();
            String URL = buildURL();
            String json = mapper.writeValueAsString(parameters);
            System.out.println(json);
            HttpResponse response = UtilityFunctions.postHttpRequest(URL, json, headers);
            UtilityFunctions.handleOSMStatusCode(response);
            return mapper.readValue(EntityUtils.toString(response.getEntity()), PoisResponse.class);
        } catch (IOException | JSONException e) {
            throw new RequestException(e.getMessage());
        }
    }

    /**
     *
     * @return the URL of the request
     * @throws UnsupportedEncodingException if some encoding error has happened.
     */
    private String buildURL() throws UnsupportedEncodingException {
        UrlBuilder builder = new UrlBuilder();
        builder.addBaseUrl(ORSEnum.BASE_URL);
        builder.addPathParam(ORSEnum.POIS_PATH);
        return builder.build();
    }

    /**
     * A POIS request can't have the following:
     * Request and/or geometry parameters missing
     * Request parameter different of "pois" (others still not supported)
     * Sort by parameter different of "distance" (not working at this time)
     * Limit and/or Buffer parameters set out of [1, 2000] interval.
     * Geometry type different of "Point" (others still not supported)
     * @throws InvalidParameters if some of the above were encountered.
     */
    private void verifyErrors() throws InvalidParameters {
        boolean notDefinedFields = parameters.getGeometry() == null || parameters.getRequest() == null;
        if(notDefinedFields)
            throw new InvalidParameters("Request and geometry parameters must be defined.");
        boolean badRequest = parameters.getRequest() != null &&
                parameters.getRequest().getValue() != PoisRequestEnum.POIS;
        boolean badSortBy = parameters.getSortBy() != null &&
                parameters.getSortBy().getValue() != SortByEnum.DISTANCE;
        boolean badLimit = parameters.getLimit() != null &&
                UtilityFunctions.isOutInterval(parameters.getLimit().getValue(), 1, 2000);
        boolean badBuffer = parameters.getGeometry() != null &&
                UtilityFunctions.isOutInterval(parameters.getGeometry().getBuffer(), 1, 2000);
        if(badRequest)
            throw new InvalidParameters("The only supported value for request parameter is pois.");
        if(badSortBy)
            throw new InvalidParameters("In the time this class was written, sortby.category was not working, so it" +
                    " is not allowed.");
        if(badLimit)
            throw new InvalidParameters("Limit value must be between 1 and 2000.");
        if(badBuffer)
            throw new InvalidParameters("Buffer value must be between 1 and 2000.");
    }

    /**
     * Set the default headers needed to make the request.
     * @param apiKey the api key to be used.
     */
    private void configureDefaultHeaders(String apiKey) {
        headers.put("Authorization", apiKey);
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("Accept", "application/json; charset=utf-8");
    }

}
