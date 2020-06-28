package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Arbitrary identification string of the request reflected in the meta information.
 */
@Getter
@AllArgsConstructor
public class Id {

    @JsonValue
    private final String value;

}
