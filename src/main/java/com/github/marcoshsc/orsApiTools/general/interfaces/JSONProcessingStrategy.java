package com.github.marcoshsc.orsApiTools.general.interfaces;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * Define the strategy interface for processing JSON. Can be used for processing a JSON in different ways.
 *
 * @param <T> Return type of the processing method.
 *
 * Created By Marcos Henrique in 28-04-2020
 */
public interface JSONProcessingStrategy<T> {
    T processJSON(JSONObject obj) throws JSONException;
}
