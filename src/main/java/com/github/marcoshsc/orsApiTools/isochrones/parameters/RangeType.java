package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.isochrones.enums.EnumRangeType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Specifies the isochrones reachability type.
 */
@Getter
@AllArgsConstructor
public class RangeType {

    @JsonValue
    private final EnumRangeType value;

}
