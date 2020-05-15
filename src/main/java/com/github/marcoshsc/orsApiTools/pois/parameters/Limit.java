package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;

/**
 * The limit of objects to be returned in the response.
 * Must be between 1 and 2000, inclusive.
 *
 * @author Marcos Henrique
 */
public class Limit implements JSONBodyParameter<Integer> {

    private static final String name = ORSEnum.LIMIT_BODY_PARAM.toString();
    /**
     * Limit [1, 2000] of returned results.
     */
    private int value;

    /**
     *
     * @param value the limit value
     */
    public Limit(int value) {
        this.value = value;
    }

    /**
     *
     * @return the parameter name.
     */
    @Override
    public String getKey() {
        return name;
    }

    /**
     *
     * @return the final processed object referent to the parameter.
     */
    @Override
    public Integer getValue() {
        return value;
    }
}
