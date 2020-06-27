package com.github.marcoshsc.orsApiTools.pois.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * Represent all the possible values to the "fee" parameter.
 *
 * @author Marcos Henrique
 */
@RequiredArgsConstructor
public enum FeeEnum {

    /**
     * a fee is usually charged
     */
    YES("yes"),

    /**
     * no fee usually charged
     */
    NO("no");

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
