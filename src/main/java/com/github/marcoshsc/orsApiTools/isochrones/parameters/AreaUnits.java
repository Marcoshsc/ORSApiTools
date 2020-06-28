package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.directions.enums.UnitsEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Specifies the area unit.
 * Default: m.
 */
@Getter
@AllArgsConstructor
public class AreaUnits {

    @JsonValue
    private final UnitsEnum value;

}
