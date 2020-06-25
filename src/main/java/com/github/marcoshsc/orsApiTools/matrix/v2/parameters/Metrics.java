package com.github.marcoshsc.orsApiTools.matrix.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.directions.enums.EnumMetrics;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Metrics {

    @JsonValue
    private final List<EnumMetrics> metrics;

}
