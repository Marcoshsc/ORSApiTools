package com.github.marcoshsc.orsApiTools.directions.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.interfaces.Request;
import com.github.marcoshsc.orsApiTools.json.deserializers.DirectionsV2Deserializer;
import com.github.marcoshsc.orsApiTools.urlUtils.UrlBuilder;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import lombok.Getter;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Getter
public class DirectionsV2Request implements Request<DirectionsV2Response> {

    private final DirectionsV2Parameters parameters = new DirectionsV2Parameters();
    private final Map<String, String> headers = new HashMap<>();

    public DirectionsV2Request(String apiKey) {
        headers.put("Authorization", apiKey);
    }

    @Override
    public DirectionsV2Response makeRequest() throws RequestException, InvalidParameters {
        try {
            String URL = getUrl();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(parameters);
            System.out.println(json);
            HttpResponse response = UtilityFunctions.postHttpRequest(URL, json, headers);
            UtilityFunctions.handleOSMStatusCode(response);
            SimpleModule module = new SimpleModule();
            module.addDeserializer(DirectionsV2Response.class,
                    new DirectionsV2Deserializer(parameters.getElevation() != null &&
                            parameters.getElevation().isValue()));
            mapper.registerModule(module);
            return mapper.readValue(EntityUtils.toString(response.getEntity()), DirectionsV2Response.class);
        } catch (IOException exc) {
            throw new RequestException("Error with the request. Log: " + exc.getMessage());
        }
    }

    private String getUrl() throws UnsupportedEncodingException {
        if(parameters.getProfile() == null) throw new IllegalArgumentException("No profile was provided.");
        UrlBuilder builder = new UrlBuilder();
        builder.addBaseUrl("https://api.openrouteservice.org");
        builder.addPathParam("v2");
        builder.addPathParam("directions");
        builder.addPathParam(parameters.getProfile().getValue());
        return builder.build();
    }

}
