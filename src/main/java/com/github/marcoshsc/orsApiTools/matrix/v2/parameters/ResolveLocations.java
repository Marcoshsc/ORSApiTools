package com.github.marcoshsc.orsApiTools.matrix.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Specifies whether given locations are resolved or not. If the parameter value set to true, every element
 * in destinations and sources will contain a name element that identifies the name of the closest street.
 * Default is false.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResolveLocations {

    @JsonValue
    private final boolean value;

}
