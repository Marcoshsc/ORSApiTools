package com.github.marcoshsc.orsApiTools.optimization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.interfaces.Request;
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
 * Implements a request to the optimization endpoint of the ORS api.
 *
 * @author Marcos Henrique
 */
@Getter
public class OptimizationRequest implements Request<OptimizationResponse> {

    /**
     * Parameters of the request.
     */
    private final OptimizationParameters parameters = new OptimizationParameters();
    /**
     * Headers of the request.
     */
    private final Map<String, String> headers = new HashMap<>();

    /**
     *
     * @param apiKey the api key to be used.
     */
    public OptimizationRequest(String apiKey) {
        configureDefaultHeaders(apiKey);
    }

    /**
     *
     * @return a java object representing the response.
     * @throws RequestException if some error occurred during the request.
     */
    @Override
    public OptimizationResponse makeRequest() throws RequestException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String URL = buildURL();
            String json = mapper.writeValueAsString(parameters);
            System.out.println(json);
            HttpResponse response = UtilityFunctions.postHttpRequest(URL, json, headers);
            UtilityFunctions.handleOSMStatusCode(response);
            return mapper.readValue(EntityUtils.toString(response.getEntity()), OptimizationResponse.class);
        } catch (JSONException | IOException e) {
            throw new RequestException(e.getMessage());
        }
    }

    private void configureDefaultHeaders(String apiKey) {
        headers.put("Authorization", apiKey);
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("Accept", "application/json; charset=utf-8");
    }

    private String buildURL() throws UnsupportedEncodingException {
        UrlBuilder builder = new UrlBuilder();
        builder.addBaseUrl(ORSEnum.BASE_URL);
        builder.addPathParam(ORSEnum.OPTIMIZATION_PATH_PARAM);
        return builder.build();
    }

}
