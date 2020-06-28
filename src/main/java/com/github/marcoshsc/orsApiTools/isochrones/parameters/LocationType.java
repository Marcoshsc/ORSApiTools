package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.isochrones.enums.EnumLocationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * start treats the location(s) as starting point, destination as goal.
 */
@Getter
@AllArgsConstructor
public class LocationType {

    @JsonValue
    private final EnumLocationType value;

}
