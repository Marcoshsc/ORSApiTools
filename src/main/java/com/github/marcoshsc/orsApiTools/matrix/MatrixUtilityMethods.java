package com.github.marcoshsc.orsApiTools.matrix;

import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
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

    public static List<Coordinate> concatLists(List<Coordinate> l1, List<Coordinate> l2) {
        List<Coordinate> concatenatedList = new ArrayList<>();
        concatenatedList.addAll(l1);
        concatenatedList.addAll(l2);
        return concatenatedList;
    }

}
