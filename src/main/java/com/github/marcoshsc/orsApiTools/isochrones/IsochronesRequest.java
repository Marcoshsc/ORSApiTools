package com.github.marcoshsc.orsApiTools.isochrones;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.interfaces.Request;
import com.github.marcoshsc.orsApiTools.urlUtils.UrlBuilder;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import lombok.Getter;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The Isochrone Service supports time and distance analyses for one single or multiple locations.
 * You may also specify the isochrone interval or provide multiple exact isochrone range values.
 * This service allows the same range of profile options as the /directions endpoint,
 * which help you to further customize your request to obtain a more detailed reachability area response.
 */
@Getter
public class IsochronesRequest implements Request<IsochronesResponse> {

    private final IsochronesParameters parameters = new IsochronesParameters();
    private final Map<String, String> headers = new HashMap<>();

    public IsochronesRequest(String apiKey) {
        headers.put("Authorization", apiKey);
    }

    @Override
    public IsochronesResponse makeRequest() throws RequestException {
        try {
            HttpResponse response = makeHttpRequest();
            UtilityFunctions.handleOSMStatusCode(response);
            return new ObjectMapper().readValue(EntityUtils.toString(response.getEntity()), IsochronesResponse.class);
        } catch(IOException exc) {
            throw new RequestException("Error with the request. Log: " + exc.getMessage());
        }
    }

    private HttpResponse makeHttpRequest() throws IOException {
        if(parameters.getProfile() == null) throw new IllegalArgumentException("Invalid Profile.");
        EnumProfile profile = parameters.getProfile().getProfile();
        UrlBuilder builder = new UrlBuilder();
        builder.addBaseUrl("https://api.openrouteservice.org/v2/isochrones");
        builder.addPathParam(profile);
        String json = new ObjectMapper().writeValueAsString(parameters);
        return UtilityFunctions.postHttpRequest(builder.build(), json, headers);
    }

}
