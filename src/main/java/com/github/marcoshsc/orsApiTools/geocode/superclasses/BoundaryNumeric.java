package com.github.marcoshsc.orsApiTools.geocode.superclasses;

import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;

/**
 * Boundary.* parameters that uses Double values.
 *
 * @author Marcos Henrique in 28-04-2020
 */
public abstract class BoundaryNumeric implements QueryParameter<Double> {

    private Double value;

    public BoundaryNumeric(Double value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value.toString();
    }

    @Override
    public Double getTypedValue() {
        return value;
    }
}
