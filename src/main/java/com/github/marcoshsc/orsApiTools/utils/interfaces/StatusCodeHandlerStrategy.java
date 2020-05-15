package com.github.marcoshsc.orsApiTools.utils.interfaces;

import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;

public interface StatusCodeHandlerStrategy {
    void verifyStatusCode(int statusCode) throws RequestException;
}
