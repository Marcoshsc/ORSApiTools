package com.github.marcoshsc.orsApiTools.matrix.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.directions.enums.UnitsEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Specifies the distance unit.
 * Default: m.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Units {

    @JsonValue
    private final UnitsEnum units;

}
