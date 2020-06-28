package com.github.marcoshsc.orsApiTools.matrix.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Arbitrary identification string of the request reflected in the meta information.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Id {

    @JsonValue
    private final String id;

}
