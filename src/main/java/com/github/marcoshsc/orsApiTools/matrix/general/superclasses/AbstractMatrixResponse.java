package com.github.marcoshsc.orsApiTools.matrix.general.superclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.marcoshsc.orsApiTools.matrix.general.helperclasses.Location;
import com.github.marcoshsc.orsApiTools.matrix.general.helperclasses.MatrixRequestOptions;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractMatrixResponse {

    private final List<List<Double>> durations;
    private final List<List<Double>> distances;
    private final List<Location> sources;
    private final List<Location> destinations;

    @Setter
    private MatrixRequestOptions options;

    @Getter
    @Setter
    private int requestCounter = 1;

    public AbstractMatrixResponse(List<List<Double>> durations, List<List<Double>> distances, List<Location> sources,
                                  List<Location> destinations) {
        this.durations = durations;
        this.distances = distances;
        this.sources = sources;
        this.destinations = destinations;
    }

    public void incrementCounter() {
        requestCounter++;
    }

    /**
     * Concatenate a new matrix left-vertically in the received target. Also update sources if needed.
     * Concatenates both distance and duration matrix, or one of them if one is missing.
     * @param toConcat the matrix to be concatenated.
     */
    public void concatNewLine(AbstractMatrixResponse toConcat) {
        if(toConcat == null)
            return;
        if(distances != null && toConcat.distances != null) {
            distances.addAll(toConcat.distances);
        }
        if(durations != null && toConcat.durations != null) {
            durations.addAll(toConcat.durations);
        }
        sources.addAll(toConcat.sources);
    }

    /**
     * Concatenate a new matrix bottom-horizontally in the received target. Also update destinations if needed.
     * Concatenates both distance and duration matrix, or one of them if one is missing.
     * @param toConcat the matrix to be concatenated.
     */
    public void concatNewColumns(AbstractMatrixResponse toConcat) {
        if(toConcat == null)
            throw new IllegalArgumentException("Matrix to concat is null.");
        int distancesInitialSize = -1;
        int durationsInitialSize = -1;
        if(toConcat.distances != null && distances != null) {
            distancesInitialSize = distances.get(0).size();
            for (int i = 0, j = distances.size() - toConcat.distances.size(); i < toConcat.distances.size(); i++, j++) {
                distances.get(j).addAll(toConcat.distances.get(i));
            }
        }
        if(toConcat.durations != null && durations != null) {
            durationsInitialSize = durations.get(0).size();
            for (int i = 0, j = durations.size() - toConcat.durations.size(); i < toConcat.durations.size(); i++, j++) {
                durations.get(j).addAll(toConcat.durations.get(i));
            }
        }
        if(distances != null && toConcat.distances != null) {
            if(distances.get(0).size() > distancesInitialSize)
                destinations.addAll(toConcat.destinations);
            return;
        }
        if(durations != null && toConcat.durations != null) {
            if(durations.get(0).size() > durationsInitialSize)
                destinations.addAll(toConcat.destinations);
        }
    }

}
