package com.github.marcoshsc.orsApiTools.directions.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Radiuses {

    @JsonValue
    private final List<Double> value;

    public Radiuses(int size) {
        List<Double> radiusList = new ArrayList<>();
        for (int i = 0; i < size; i++)
            radiusList.add(-1d);
        this.value = radiusList;
    }
}
