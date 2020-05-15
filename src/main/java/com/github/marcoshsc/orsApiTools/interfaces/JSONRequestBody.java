package com.github.marcoshsc.orsApiTools.interfaces;

import org.json.JSONException;
import org.json.JSONObject;

public interface JSONRequestBody {

    /**
     *
     * @return JSON body built with the parameters avaliable
     */
    JSONObject getBody() throws JSONException;

}
