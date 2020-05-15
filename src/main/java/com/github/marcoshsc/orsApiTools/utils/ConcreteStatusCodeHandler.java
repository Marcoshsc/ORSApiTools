package com.github.marcoshsc.orsApiTools.utils;

import com.github.marcoshsc.orsApiTools.utils.interfaces.StatusCodeHandlerStrategy;
import com.github.marcoshsc.orsApiTools.utils.superclasses.StatusCodeHandlerContext;

public class ConcreteStatusCodeHandler extends StatusCodeHandlerContext {
    public ConcreteStatusCodeHandler(StatusCodeHandlerStrategy handler) {
        super(handler);
    }
}
