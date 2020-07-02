package com.github.marcoshsc.orsApiTools.directions.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoundaboutExits {

    @JsonValue
    private final boolean value;

}
