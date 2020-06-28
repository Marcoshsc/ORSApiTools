package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.directions.enums.UnitsEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Specifies the distance units only if range_type is set to distance.
 * Default: m.
 */
@Getter
@AllArgsConstructor
public class Units {

    @JsonValue
    private final UnitsEnum value;

}
