package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Specifies whether to return intersecting polygons.
 */
@Getter
@AllArgsConstructor
public class Intersections {

    @JsonValue
    private final boolean value;

}
