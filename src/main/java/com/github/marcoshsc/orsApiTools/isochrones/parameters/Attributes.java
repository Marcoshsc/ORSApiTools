package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.isochrones.enums.EnumAttributes;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * List of isochrones attributes
 */
@Getter
@AllArgsConstructor
public class Attributes {

    @JsonValue
    private final List<EnumAttributes> value;

}
