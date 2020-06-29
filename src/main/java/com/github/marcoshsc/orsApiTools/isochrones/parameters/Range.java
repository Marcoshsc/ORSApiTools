package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoshsc.orsApiTools.json.serializers.RangeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Maximum range value of the analysis in seconds for time and metres for distance.Alternatively a comma separated
 * list of specific single range values if more than one location is set.
 */
@Getter
@AllArgsConstructor
public class Range {

    @JsonValue
    @JsonSerialize(using = RangeSerializer.class)
    private final List<Double> value;

}
