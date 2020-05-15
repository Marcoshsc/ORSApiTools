package com.github.marcoshsc.orsApiTools.optimization;

import com.github.marcoshsc.orsApiTools.general.ORSJSONProcessor;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.interfaces.Request;
import com.github.marcoshsc.orsApiTools.general.superclasses.JSONProcessingContext;
import com.github.marcoshsc.orsApiTools.optimization.handlers.OptimizationHandler;
import com.github.marcoshsc.orsApiTools.urlUtils.UrlBuilder;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import com.github.marcoshsc.orsApiTools.utils.interfaces.StatusCodeHandlerStrategy;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements a request to the optimization endpoint of the ORS api.
 *
 * @author Marcos Henrique
 */
public class OptimizationRequest implements Request<OptimizationResponse> {

    /**
     * Parameters of the request.
     */
    private OptimizationParameters parameters = new OptimizationParameters();
    /**
     * Headers of the request.
     */
    private Map<String, String> headers = new HashMap<>();

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
            String URL = buildURL();
            JSONObject jsonResponse = UtilityFunctions.makePostHttpRequestWithoutHandler(URL, headers, parameters);
            StatusCodeHandlerStrategy handler = new OptimizationHandler(jsonResponse);
            handler.verifyStatusCode(jsonResponse.getInt("statusCodeToHandle"));
            JSONProcessingContext<OptimizationResponse> context = new ORSJSONProcessor<>(new OptimizationProcessingStrategy());
            return context.processJSON(jsonResponse);
        } catch (UnsupportedEncodingException | JSONException e) {
            throw new RequestException(e.getMessage());
        }
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public OptimizationParameters getParameters() {
        return parameters;
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
