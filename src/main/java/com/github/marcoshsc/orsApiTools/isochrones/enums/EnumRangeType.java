package com.github.marcoshsc.orsApiTools.isochrones.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EnumRangeType {

    TIME("time"), DISTANCE("distance");

    private final String type;

    @JsonValue
    public String getType() {
        return type;
    }

    @JsonCreator
    public EnumRangeType getFromString(String type) {
        for (EnumRangeType elt : EnumRangeType.values()) {
            if(elt.getType().toUpperCase().equals(type.toUpperCase()))
                return elt;
        }
        throw new IllegalArgumentException("Invalid location type.");
    }

}
