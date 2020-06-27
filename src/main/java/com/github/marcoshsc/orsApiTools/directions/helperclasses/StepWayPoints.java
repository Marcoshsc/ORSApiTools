package com.github.marcoshsc.orsApiTools.directions.helperclasses;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.StepWayPointsDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonDeserialize(using = StepWayPointsDeserializer.class)
@AllArgsConstructor
public class StepWayPoints {

    private final int start;
    private final int end;

}
