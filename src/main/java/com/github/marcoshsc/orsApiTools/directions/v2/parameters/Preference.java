package com.github.marcoshsc.orsApiTools.directions.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.directions.enums.PreferenceEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Preference {

    @JsonValue
    private final PreferenceEnum value;

}
