package com.github.marcoshsc.orsApiTools.general.superclasses;

import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;

public abstract class NumericParameter<T extends Number> implements QueryParameter<T> {

    private T value;

    public NumericParameter(T value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value.toString();
    }

    @Override
    public T getTypedValue() {
        return value;
    }
}
