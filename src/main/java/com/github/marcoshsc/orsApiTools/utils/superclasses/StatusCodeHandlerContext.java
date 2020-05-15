package com.github.marcoshsc.orsApiTools.utils.superclasses;

import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.utils.interfaces.StatusCodeHandlerStrategy;

public abstract class StatusCodeHandlerContext implements StatusCodeHandlerStrategy {

    private StatusCodeHandlerStrategy handler;

    public StatusCodeHandlerContext(StatusCodeHandlerStrategy handler) {
        this.handler = handler;
    }

    @Override
    public void verifyStatusCode(int statusCode) throws RequestException {
        handler.verifyStatusCode(statusCode);
    }
}
