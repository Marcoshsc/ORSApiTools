package com.github.marcoshsc.orsApiTools.general.superclasses;

import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;

public abstract class EnumParameter<T extends Enum<?>> implements QueryParameter<T> {

    private T value;

    public EnumParameter(T value) {
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
