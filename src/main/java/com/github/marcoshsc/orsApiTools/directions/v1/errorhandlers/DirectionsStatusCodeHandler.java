package com.github.marcoshsc.orsApiTools.directions.v1.errorhandlers;

import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.utils.interfaces.StatusCodeHandlerStrategy;

/**
 * Strategy to handle Directions requests status codes.
 *
 * @author Marcos Henrique
 */
public class DirectionsStatusCodeHandler implements StatusCodeHandlerStrategy {

    /**
     *
     * @param statusCode status code to be analysed
     * @throws RequestException if it's a error status code
     */
    @Override
    public void verifyStatusCode(int statusCode) throws RequestException {
        switch (statusCode) {
            case 400:
                throw new RequestException("ERROR 400: The request is incorrect and therefore can't be processed.");
            case 401:
                throw new RequestException("ERROR 401: API Key is missing");
            case 403:
                throw new RequestException("ERROR 403: Key not authorized");
            case 404:
                throw new RequestException("ERROR 404: Unable to find a route between points / One or more points " +
                        "specified cannot be found in the routing network. Try adding -1 radius values in the parameters" +
                        " and changing the profile.");
            case 405:
                throw new RequestException("ERROR 405: The specified HTTP method is not supported.");
            case 413:
                throw new RequestException("ERROR 413: The request is larger than the server is able to process, " +
                        "the data provided in the request exceeds the capacity limit.");
            case 500:
                throw new RequestException("ERROR 500: Unexpected error. See https://openrouteservice.org/dev/#/api-docs/directions/get " +
                        "to get a better understanding of this error.");
            case 501:
                throw new RequestException("ERROR 501: The server does not support the functionality needed to fulfill " +
                        "the request.");
            case 503:
                throw new RequestException("ERROR 503: The server is currently unavailable due to overload or maintenance.");
        }
    }
}
