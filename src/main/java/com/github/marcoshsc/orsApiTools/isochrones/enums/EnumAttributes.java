package com.github.marcoshsc.orsApiTools.isochrones.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EnumAttributes {

    AREA("area"), REACHFACTOR("reachfactor"), TOTAL_POPULATION("total_pop");

    private final String attribute;

    @JsonValue
    public String getAttribute() {
        return attribute;
    }

    @JsonCreator
    public EnumAttributes getFromString(String value) {
        for (EnumAttributes attribute : EnumAttributes.values()) {
            if(attribute.getAttribute().toUpperCase().equals(value.toUpperCase()))
                return attribute;
        }
        throw new IllegalArgumentException("Invalid Attribute.");
    }

    @Override
    public String toString() {
        return attribute;
    }
}
