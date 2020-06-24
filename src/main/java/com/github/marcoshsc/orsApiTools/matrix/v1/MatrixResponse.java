package com.github.marcoshsc.orsApiTools.matrix.v1;

import com.github.marcoshsc.orsApiTools.matrix.v1.helperclasses.LocationDescription;
import com.github.marcoshsc.orsApiTools.matrix.v1.helperclasses.MatrixRequestOptions;

import java.util.List;

/**
 * Abstract the matrix response from the ORS API. This class purpose is to be as most read-only as possible, except if
 * concatenation of matrixes is needed, in this case there are the methods to do it.
 *
 * @author Marcos Henrique
 */
public class MatrixResponse {
    private List<List<Double>> distances;
    private List<List<Double>> durations;
    private List<LocationDescription> sources;
    private List<LocationDescription> destinations;
    private MatrixRequestOptions options;

    public MatrixResponse(List<List<Double>> distances, List<List<Double>> durations, List<LocationDescription> sources,
                          List<LocationDescription> destinations, MatrixRequestOptions options) {
        this.distances = distances;
        this.durations = durations;
        this.sources = sources;
        this.destinations = destinations;
        this.options = options;
    }

    /**
     * Concatenate a new matrix left-vertically in the received target. Also update sources if needed.
     * Concatenates both distance and duration matrix, or one of them if one is missing.
     * @param target the target of concatenation.
     * @param toConcat the matrix to be concatenated.
     */
    public static void concatNewLine(MatrixResponse target, MatrixResponse toConcat) {
        if(toConcat == null || target == null)
            return;
        if(target.distances != null && toConcat.distances != null) {
            List<List<Double>> targetDistances = target.distances;
            targetDistances.addAll(toConcat.distances);
        }
        if(target.durations != null && toConcat.durations != null) {
            List<List<Double>> targetDurations = target.durations;
            targetDurations.addAll(toConcat.durations);
        }
        target.sources.addAll(toConcat.sources);
    }

    /**
     * Concatenate a new matrix bottom-horizontally in the received target. Also update destinations if needed.
     * Concatenates both distance and duration matrix, or one of them if one is missing.
     * @param target the target of concatenation.
     * @param toConcat the matrix to be concatenated.
     */
    public static void concatNewColumns(MatrixResponse target, MatrixResponse toConcat) {
        if(toConcat == null || target == null)
            throw new IllegalArgumentException(String.format("Target: %s, Matrix to concat: %s, one of them are null.",
                    target, toConcat));
        int distancesInitialSize = -1;
        int durationsInitialSize = -1;
        if(toConcat.distances != null && target.distances != null) {
            distancesInitialSize = target.distances.get(0).size();
            List<List<Double>> targetDistances = target.distances;
            for (int i = 0, j = target.distances.size() - toConcat.distances.size(); i < toConcat.distances.size(); i++, j++) {
                targetDistances.get(j).addAll(toConcat.distances.get(i));
            }
        }
        if(toConcat.durations != null && target.durations != null) {
            durationsInitialSize = target.durations.get(0).size();
            List<List<Double>> targetDurations = target.durations;
            for (int i = 0, j = target.durations.size() - toConcat.durations.size(); i < toConcat.durations.size(); i++, j++) {
                targetDurations.get(j).addAll(toConcat.durations.get(i));
            }
        }
        if(target.distances != null && toConcat.distances != null) {
            if(distancesInitialSize != -1 && target.distances.get(0).size() > distancesInitialSize)
                target.destinations.addAll(toConcat.destinations);
            return;
        }
        if(target.durations != null && toConcat.durations != null) {
            if(durationsInitialSize != -1 && target.durations.get(0).size() > durationsInitialSize)
                target.destinations.addAll(toConcat.destinations);
            return;
        }
    }

    public List<List<Double>> getDistances() {
        return distances;
    }

    public List<List<Double>> getDurations() {
        return durations;
    }

    public List<LocationDescription> getSources() {
        return sources;
    }

    public List<LocationDescription> getDestinations() {
        return destinations;
    }

    public MatrixRequestOptions getOptions() {
        return options;
    }
}
