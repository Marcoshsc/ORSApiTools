package com.github.marcoshsc.orsApiTools.directions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.marcoshsc.orsApiTools.directions.enums.EnumDirectionsGeomType;
import com.github.marcoshsc.orsApiTools.directions.enums.FormatEnum;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.interfaces.Request;
import com.github.marcoshsc.orsApiTools.general.parameters.ApiKey;
import com.github.marcoshsc.orsApiTools.json.deserializers.DirectionsResponseDeserializer;
import com.github.marcoshsc.orsApiTools.urlUtils.UrlBuilder;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import lombok.Getter;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * A request for the Directions route, from ORS API. Parameters and headers are full customizable, and the user must call
 * makeRequest for executing the request and getting the response.
 *
 * @author Marcos Henrique
 */
@Getter
public class ORSDirectionsRequest implements Request<DirectionsResponse> {

    private final DirectionsParameters parameters = new DirectionsParameters();
    private final Map<String, String> headers = new HashMap<>();

    public ORSDirectionsRequest(String apiKey) {
        parameters.setApiKey(new ApiKey(apiKey));
        configureDefaultHeaders();
    }

    /**
     * Sets the default headers in order to make the request be successful.
     */
    private void configureDefaultHeaders() {
        headers.put("Accept", "application/json; charset=utf-8");
    }

    /**
     *
     * @return a java object referent to the parameters and headers.
     * @throws RequestException if some error happened during the request.
     * @throws InvalidParameters if any of the parameters are invalid or incorrect.
     */
    @Override
    public DirectionsResponse makeRequest() throws RequestException, InvalidParameters {
        try {
            verifyErrors();
            String URL = buildURL();
            JSONObject responseJSON = UtilityFunctions.makeHTTPRequest(URL, headers, null);
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(DirectionsResponse.class, new DirectionsResponseDeserializer());
            mapper.registerModule(module);
            return mapper.readValue(responseJSON.toString(), DirectionsResponse.class);
        } catch (IOException | JSONException exc) {
            throw new RequestException(exc.getMessage());
        }
    }

    /**
     * Verify for inconsistencies in the parameters.
     *
     * @throws InvalidParameters if some error was encountered.
     */
    private void verifyErrors() throws InvalidParameters {
        boolean missingParameters = parameters.getApiKey() == null ||
                parameters.getProfile() == null ||
                parameters.getCoordinates() == null;
        if(missingParameters)
            throw new InvalidParameters("Parameters Api Key, Profile and/or Coordinates can't be missing.");
        if(parameters.getGeometryFormat().getTypedValue() == EnumDirectionsGeomType.ENCODEDPOLYLINE)
            throw new InvalidParameters("Geometry Format encodedpolyline not supported.");
        if(parameters.getFormat() != null && parameters.getFormat().getTypedValue() != FormatEnum.JSON)
            throw new InvalidParameters("For this version, only JSON format is supported.");
        if(parameters.getRadiuses() != null &&
                parameters.getRadiuses().getTypedValue().size() != parameters.getCoordinates().getTypedValue().size())
            throw new InvalidParameters("Radius size must be the same as coordinates.");
    }

    private String buildURL() throws UnsupportedEncodingException {
        UrlBuilder builder = new UrlBuilder();
        builder.addBaseUrl(ORSEnum.BASE_URL);
        builder.addPathParam(ORSEnum.DIRECTIONS_PATH);
        builder.addQueryParam(parameters);
        return builder.build();
    }

}
