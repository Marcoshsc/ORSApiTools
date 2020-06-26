package com.github.marcoshsc.orsApiTools.matrix.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.matrix.general.helperclasses.Location;
import com.github.marcoshsc.orsApiTools.matrix.general.superclasses.AbstractMatrixResponse;

import java.util.List;

public class MatrixV2Response extends AbstractMatrixResponse {

    public MatrixV2Response(@JsonProperty("durations") List<List<Double>> durations,
                            @JsonProperty("distances") List<List<Double>> distances,
                            @JsonProperty("sources") List<Location> sources,
                            @JsonProperty("destinations") List<Location> destinations) {
        super(durations, distances, sources, destinations);
    }

}
