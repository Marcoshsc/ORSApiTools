package com.github.marcoshsc.orsApiTools.matrix.general.utils;

import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.matrix.general.superclasses.AbstractMatrixResponse;
import org.locationtech.jts.geom.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtilityMethods {

    public static void verifyMatrix(List<List<Double>> matrix, List<Integer> sources, List<Integer> destinations)
            throws RequestException {
        int matrixRows = matrix.size();
        int rows = sources.size();
        int columns = destinations.size();
        if(rows != matrixRows) {
            throw new RequestException(String.format("ORS Api error. The size of the matrix does not match with " +
                    "the size of the given parameters. Matrix rows: %d, Source rows: %d.", matrixRows, rows));
        }
        for (List<Double> list : matrix) {
            int matrixColumns = list.size();
            if(columns != matrixColumns) {
                throw new RequestException(String.format("ORS Api error. The size of the matrix does not match " +
                                "with the size of the given parameters. Matrix columns: %d, Destination columns: %d.",
                        matrixColumns, columns));
            }
        }
    }

    public static List<List<Double>> getNewDurations(AbstractMatrixResponse response) {
        if(response.getDurations() == null) return null;
        List<List<Double>> durations = response.getDurations();
        return transposeMatrix(response, durations);
    }

    public static List<List<Double>> getNewDistances(AbstractMatrixResponse response) {
        if(response.getDistances() == null) return null;
        List<List<Double>> distances = response.getDistances();
        return transposeMatrix(response, distances);
    }

    private static List<List<Double>> transposeMatrix(AbstractMatrixResponse response, List<List<Double>> durations) {
        List<List<Double>> newDurations = new ArrayList<>();
        for (int i = 0; i < response.getDestinations().size(); i++) {
            newDurations.add(new ArrayList<>());
        }
        for (List<Double> row : durations) {
            for (int j = 0; j < row.size(); j++)
                newDurations.get(j).add(row.get(j));
        }
        return newDurations;
    }

    public static List<Coordinate> concatLists(List<Coordinate> l1, List<Coordinate> l2) {
        List<Coordinate> concatenatedList = new ArrayList<>();
        concatenatedList.addAll(l1);
        concatenatedList.addAll(l2);
        return concatenatedList;
    }

}
