package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Interval of isochrones or equidistants for one range value. Value in seconds for time and meters for distance.
 */
@Getter
@AllArgsConstructor
public class Interval {

    @JsonValue
    private final int value;

}
