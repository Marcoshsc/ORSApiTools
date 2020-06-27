package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * The limit of objects to be returned in the response.
 * Must be between 1 and 2000, inclusive.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@AllArgsConstructor
public class Limit {

    /**
     * Limit [1, 2000] of returned results.
     */
    @JsonValue
    private final int value;

}
