package com.github.marcoshsc.orsApiTools.optimization.parameters;

import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

/**
 * Optional two-dimensional array describing a custom matrix
 *
 * @author Marcos Henrique
 */
public class OptimizationMatrix implements JSONBodyParameter<JSONArray> {

    private static final String name = "matrix";
    /**
     * Quadratic matrix of durations
     */
    List<List<Integer>> durations;

    public OptimizationMatrix(List<List<Integer>> durations) {
        this.durations = durations;
    }

    /**
     *
     * @return the name of the parameter.
     */
    @Override
    public String getKey() {
        return name;
    }

    /**
     *
     * @return an JSONArray representing the matrix.
     * @throws JSONException if some JSON parsing exception happened.
     */
    @Override
    public JSONArray getValue() throws JSONException {
        return UtilityFunctions.getTwoDimensionIntegerJSONArray(durations);
    }



}
