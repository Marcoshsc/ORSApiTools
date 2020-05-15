package com.github.marcoshsc.orsApiTools.general.superclasses;

import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;

public abstract class BooleanParameter implements QueryParameter<Boolean> {

    private Boolean value;

    public BooleanParameter(Boolean value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value.toString();
    }

    @Override
    public Boolean getTypedValue() {
        return value;
    }

}
