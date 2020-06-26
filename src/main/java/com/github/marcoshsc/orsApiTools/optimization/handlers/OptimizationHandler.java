package com.github.marcoshsc.orsApiTools.optimization.handlers;

import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.utils.interfaces.StatusCodeHandlerStrategy;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Handle a optimization request status code. If an error status code is encountered, an exception is thrown.
 *
 * @author Marcos Henrique
 */
@AllArgsConstructor
public class OptimizationHandler implements StatusCodeHandlerStrategy {

    private final JSONObject response;

    /**
     *
     * @param statusCode the status code to be analyzed.
     * @throws RequestException if the status code refers to an error.
     */
    @Override
    public void verifyStatusCode(int statusCode) throws RequestException {
        if(statusCode >= 400) {
            try {
                if (response.has("error"))
                    throw new RequestException(response.getString("error"));
                throw new RequestException("Response returned status code " + statusCode);
            } catch(JSONException exc) {
                System.out.println("JSON parsing error");
            }
        }
    }

}
