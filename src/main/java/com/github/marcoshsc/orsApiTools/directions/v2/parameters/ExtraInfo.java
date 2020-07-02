package com.github.marcoshsc.orsApiTools.directions.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.directions.enums.ExtraInfoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ExtraInfo {

    @JsonValue
    private final List<ExtraInfoEnum> extraInfoList;

}
