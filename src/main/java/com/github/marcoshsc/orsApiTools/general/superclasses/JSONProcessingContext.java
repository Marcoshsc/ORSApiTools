package com.github.marcoshsc.orsApiTools.general.superclasses;

import com.github.marcoshsc.orsApiTools.general.interfaces.JSONProcessingStrategy;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Defines the context of the JSON processing strategy.
 * @param <T> Return type of strategy interface's method.
 *
 * Created By Marcos Henrique in 28-04-2020
 */
public abstract class JSONProcessingContext<T> implements JSONProcessingStrategy<T> {

    private JSONProcessingStrategy<T> strategy;

    public JSONProcessingContext(JSONProcessingStrategy<T> strategy) {
        this.strategy = strategy;
    }

    @Override
    public T processJSON(JSONObject obj) throws JSONException {
        return strategy.processJSON(obj);
    }
}
