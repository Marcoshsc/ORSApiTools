package com.github.marcoshsc.orsApiTools.matrix.errorhandlers;

import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.utils.interfaces.StatusCodeHandlerStrategy;

/**
 * Handle error status codes from the /matrix endpoint of the ORS API.
 *
 * @author Marcos Henrique
 */
public class MatrixStatusCodeHandler implements StatusCodeHandlerStrategy {

    /**
     * https://openrouteservice.org/dev/#/api-docs/matrix/get V1 for better understanding.
     * @param statusCode the status code to be analyzed.
     * @throws RequestException if the status code refers to an error.
     */
    @Override
    public void verifyStatusCode(int statusCode) throws RequestException {
        switch (statusCode) {
            case 400:
                throw new RequestException("ERROR 400: The request is incorrect and therefore can't be processed.");
            case 401:
                throw new RequestException("ERROR 401: API Key is missing");
            case 403:
                throw new RequestException("ERROR 403: Key not authorised");
            case 404:
                throw new RequestException("ERROR 404: Points out of bounds / One or more points " +
                        "specified cannot be found in the routing network. Try to change the profile parameter, which " +
                        "is generally the cause of this status code.");
            case 405:
                throw new RequestException("ERROR 405: The specified HTTP method is not supported.");
            case 413:
                throw new RequestException("ERROR 413: The request is larger than the server is able to process, " +
                        "the data provided in the request exceeds the capacity limit.");
            case 500:
                throw new RequestException("ERROR 500: Unexpected error. See https://openrouteservice.org/dev/#/api-docs/matrix/get " +
                        "to get a better understanding of this error.");
            case 501:
                throw new RequestException("ERROR 501: The server does not support the functionality needed to fulfill " +
                        "the request.");
            case 503:
                throw new RequestException("ERROR 503: The server is currently unavailable due to overload or maintenance.");
        }
    }

}
