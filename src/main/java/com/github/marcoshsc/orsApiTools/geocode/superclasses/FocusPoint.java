package com.github.marcoshsc.orsApiTools.geocode.superclasses;

import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;

/**
 * Focus.point.* parameters generalization.
 *
 * @author Marcos Henrique in 28-04-2020
 */
public abstract class FocusPoint implements QueryParameter<Double> {

    private Double value;

    public FocusPoint(Double value) {
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
