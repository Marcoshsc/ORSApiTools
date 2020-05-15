package com.github.marcoshsc.orsApiTools.general;

import com.github.marcoshsc.orsApiTools.general.interfaces.JSONProcessingStrategy;
import com.github.marcoshsc.orsApiTools.general.superclasses.JSONProcessingContext;

/**
 *
 * Concrete context class of JSON processing strategy.
 *
 * @param <T> Return type of the strategy interface's method.
 *
 * Created By Marcos Henrique in 28-04-2020
 */
public class ORSJSONProcessor<T> extends JSONProcessingContext<T> {

    public ORSJSONProcessor(JSONProcessingStrategy<T> strategy) {
        super(strategy);
    }

}
