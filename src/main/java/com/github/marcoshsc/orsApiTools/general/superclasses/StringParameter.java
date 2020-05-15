package com.github.marcoshsc.orsApiTools.general.superclasses;

import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;

public abstract class StringParameter implements QueryParameter<String> {

    private String value;

    public StringParameter(String value) {
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
