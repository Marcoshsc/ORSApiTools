package com.github.marcoshsc.orsApiTools.matrix.v2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.matrix.helperclasses.MatrixRequestOptions;
import com.github.marcoshsc.orsApiTools.matrix.v2.helperclasses.Location;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatrixV2Response {

    private final List<List<Double>> durations;
    private final List<List<Double>> distances;
    private final List<Location> sources;
    private final List<Location> destinations;

    @Setter
    private MatrixRequestOptions options;

    public MatrixV2Response(@JsonProperty("durations") List<List<Double>> durations,
                            @JsonProperty("distances") List<List<Double>> distances,
                            @JsonProperty("sources") List<Location> sources,
                            @JsonProperty("destinations") List<Location> destinations) {
        this.durations = durations;
        this.distances = distances;
        this.sources = sources;
        this.destinations = destinations;
    }

    /**
     * Concatenate a new matrix left-vertically in the received target. Also update sources if needed.
     * Concatenates both distance and duration matrix, or one of them if one is missing.
     * @param target the target of concatenation.
     * @param toConcat the matrix to be concatenated.
     */
    public static void concatNewLine(MatrixV2Response target, MatrixV2Response toConcat) {
        if(toConcat == null || target == null)
            return;
        if(target.distances != null && toConcat.distances != null) {
            target.distances.addAll(toConcat.distances);
        }
        if(target.durations != null && toConcat.durations != null) {
            target.durations.addAll(toConcat.durations);
        }
        target.sources.addAll(toConcat.sources);
    }

    /**
     * Concatenate a new matrix bottom-horizontally in the received target. Also update destinations if needed.
     * Concatenates both distance and duration matrix, or one of them if one is missing.
     * @param target the target of concatenation.
     * @param toConcat the matrix to be concatenated.
     */
    public static void concatNewColumns(MatrixV2Response target, MatrixV2Response toConcat) {
        if(toConcat == null || target == null)
            throw new IllegalArgumentException(String.format("Target: %s, Matrix to concat: %s, one of them are null.",
                    target, toConcat));
        int distancesInitialSize = -1;
        int durationsInitialSize = -1;
        if(toConcat.distances != null && target.distances != null) {
            distancesInitialSize = target.distances.get(0).size();
            for (int i = 0, j = target.distances.size() - toConcat.distances.size(); i < toConcat.distances.size(); i++, j++) {
                target.distances.get(j).addAll(toConcat.distances.get(i));
            }
        }
        if(toConcat.durations != null && target.durations != null) {
            durationsInitialSize = target.durations.get(0).size();
            for (int i = 0, j = target.durations.size() - toConcat.durations.size(); i < toConcat.durations.size(); i++, j++) {
                target.durations.get(j).addAll(toConcat.durations.get(i));
            }
        }
        if(target.distances != null && toConcat.distances != null) {
            if(target.distances.get(0).size() > distancesInitialSize)
                target.destinations.addAll(toConcat.destinations);
            return;
        }
        if(target.durations != null && toConcat.durations != null) {
            if(target.durations.get(0).size() > durationsInitialSize)
                target.destinations.addAll(toConcat.destinations);
        }
    }

}
