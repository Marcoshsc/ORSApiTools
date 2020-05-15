package com.github.marcoshsc.orsApiTools.geocode;

import com.github.marcoshsc.orsApiTools.general.ORSJSONProcessor;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.interfaces.Request;
import com.github.marcoshsc.orsApiTools.general.parameters.ApiKey;
import com.github.marcoshsc.orsApiTools.general.superclasses.JSONProcessingContext;
import com.github.marcoshsc.orsApiTools.urlUtils.UrlBuilder;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Geocode/search endpoint request implementation.
 *
 * REQUEST RULES:
 * - boundary.circle.* parameters must either not be used, or used all together.
 * - boundary.rect.* parameters must either not be used, or used all together.
 * - focus.point.* parameters must either not be used, or used all together.
 *
 * @author Marcos Henrique in 28-04-2020
 */
public class GeocodeSearchRequest implements Request<GeocodeSearchResponse> {

    private GeocodeSearchParameters parameters = new GeocodeSearchParameters();
    private Map<String, String> headers = new HashMap<>();

    /**
     *
     * @param key the API key.
     */
    public GeocodeSearchRequest(String key) {
        parameters.setApiKey(new ApiKey(key));
        configureDefaultHeaders();
    }

    /**
     *
     * @return GeocodeSearchResponse for representing the data gathered
     * @throws RequestException if something goes wrong in the request
     * @throws InvalidParameters if some invalid parameter is detected
     *
     * Created By Marcos Henrique in 28-04-2020
     */
    @Override
    public GeocodeSearchResponse makeRequest() throws RequestException, InvalidParameters {
        try {
            validateRequest();
            String URL = buildURL();
            JSONObject responseJSON = UtilityFunctions.makeHTTPRequest(URL, headers, null);
            JSONProcessingContext<GeocodeSearchResponse> context = new ORSJSONProcessor<>(new GeocodeSearchProcessingStrategy());
            return context.processJSON(responseJSON);
        } catch(JSONException | UnsupportedEncodingException exc) {
            throw new RequestException(exc.getMessage());
        }
    }

    private void validateRequest() throws InvalidParameters {
        if(parameters.getApiKey() == null)
            throw new InvalidParameters("No API key parameter passed.");
        if(parameters.getText() == null)
            throw new InvalidParameters("No text parameter in the request.");
        boolean boundaryCircleOK =
                (parameters.getBoundaryCircleLatitude() != null && parameters.getBoundaryCircleLongitude() != null) ||
                (parameters.getBoundaryCircleLongitude() == null && parameters.getBoundaryCircleLatitude() == null &&
                        parameters.getBoundaryCircleRadius() == null);
        boolean boundaryRectangleOK = (
                    parameters.getBoundaryRectMaximumLatitude() != null &&
                    parameters.getBoundaryRectMinimumLatitude() != null &&
                    parameters.getBoundaryRectMaximumLongitude() != null &&
                    parameters.getBoundaryRectMinimumLongitude() != null
                ) ||
                (
                    parameters.getBoundaryRectMaximumLatitude() == null &&
                    parameters.getBoundaryRectMinimumLatitude() == null &&
                    parameters.getBoundaryRectMaximumLongitude() == null &&
                    parameters.getBoundaryRectMinimumLongitude() == null
                );
        boolean focusPointOK =
                (parameters.getFocusPointLatitude() != null && parameters.getFocusPointLongitude() != null) ||
                (parameters.getFocusPointLatitude() == null && parameters.getFocusPointLongitude() == null);
        if(!boundaryCircleOK)
            throw new InvalidParameters("Boundary circle parameters used incorrectly.");
        if(!boundaryRectangleOK)
            throw new InvalidParameters("Boundary Rectangle parameters used incorrectly.");
        if(!focusPointOK)
            throw new InvalidParameters("Focus Point parameters used incorrectly.");
    }

    private String buildURL() throws UnsupportedEncodingException {
        UrlBuilder builder = new UrlBuilder();
        builder.addBaseUrl(ORSEnum.BASE_URL);
        builder.addPathParam(ORSEnum.GEOCODE_PATH);
        builder.addPathParam(ORSEnum.GEOCODE_SEARCH_PATH);
        builder.addQueryParam(parameters);
        return builder.build();
    }

    private void configureDefaultHeaders() {
        headers.put("Accept", "application/json; charset=utf-8");
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public GeocodeSearchParameters getParameters() {
        return parameters;
    }

}
