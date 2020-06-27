package com.github.marcoshsc.orsApiTools.pois.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * Represents all the possible values to the "sortby" parameter.
 *
 * @author Marcos Henrique
 */
@RequiredArgsConstructor
public enum SortByEnum {

    CATEGORY("category"),
    DISTANCE("distance");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
