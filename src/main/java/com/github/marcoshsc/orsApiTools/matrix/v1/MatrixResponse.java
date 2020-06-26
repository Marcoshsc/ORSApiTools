package com.github.marcoshsc.orsApiTools.matrix.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.matrix.general.helperclasses.Location;
import com.github.marcoshsc.orsApiTools.matrix.general.superclasses.AbstractMatrixResponse;

import java.util.List;

/**
 * Abstract the matrix response from the ORS API. This class purpose is to be as most read-only as possible, except if
 * concatenation of matrixes is needed, in this case there are the methods to do it.
 *
 * @author Marcos Henrique
 */
public class MatrixResponse extends AbstractMatrixResponse {
    public MatrixResponse(@JsonProperty("durations") List<List<Double>> durations,
                            @JsonProperty("distances") List<List<Double>> distances,
                            @JsonProperty("sources") List<Location> sources,
                            @JsonProperty("destinations") List<Location> destinations) {
        super(durations, distances, sources, destinations);
    }
}
