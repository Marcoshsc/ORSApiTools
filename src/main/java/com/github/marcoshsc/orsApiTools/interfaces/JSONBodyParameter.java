package com.github.marcoshsc.orsApiTools.interfaces;

import org.json.JSONException;

public interface JSONBodyParameter<T> {

    /**
     *
     * @return the parameter name.
     */
    String getKey();

    /**
     *
     * @return the final processed object referent to the parameter.
     */
    T getValue() throws JSONException;

}
