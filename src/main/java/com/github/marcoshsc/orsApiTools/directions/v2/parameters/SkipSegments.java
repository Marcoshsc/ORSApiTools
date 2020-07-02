package com.github.marcoshsc.orsApiTools.directions.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SkipSegments {

    @JsonValue
    private final List<Integer> value;

}
