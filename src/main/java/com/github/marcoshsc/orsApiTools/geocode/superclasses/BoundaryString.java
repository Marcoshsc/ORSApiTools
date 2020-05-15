package com.github.marcoshsc.orsApiTools.geocode.superclasses;

import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;

/**
 * Boundary.* parameters that use string values.
 *
 * @author Marcos Henrique in 28-04-2020
 */
public abstract class BoundaryString implements QueryParameter<String> {

    private String value;

    public BoundaryString(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getTypedValue() {
        return value;
    }

}
