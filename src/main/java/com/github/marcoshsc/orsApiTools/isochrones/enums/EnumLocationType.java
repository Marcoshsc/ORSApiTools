package com.github.marcoshsc.orsApiTools.isochrones.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EnumLocationType {

    START("start"), DESTINATION("destination");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public EnumLocationType getFromString(String type) {
        for (EnumLocationType elt : EnumLocationType.values()) {
            if(elt.getValue().toUpperCase().equals(type.toUpperCase()))
                return elt;
        }
        throw new IllegalArgumentException("Invalid location type.");
    }


    @Override
    public String toString() {
        return value;
    }
}
