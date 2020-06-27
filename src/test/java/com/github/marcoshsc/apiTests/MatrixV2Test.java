package com.github.marcoshsc.apiTests;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumMetrics;
import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.general.ORSEndpoints;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.matrix.v2.MatrixV2Request;
import com.github.marcoshsc.orsApiTools.matrix.v2.MatrixV2Response;
import com.github.marcoshsc.orsApiTools.matrix.v2.parameters.*;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import util.ApiKeyGetter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MatrixV2Test {

    @Test
    public void simpleTest() throws InvalidParameters, RequestException, IOException {
        MatrixV2Request req = ORSEndpoints.getMatrixV2(ApiKeyGetter.getApiKey());
        req.getParameters().setProfile(new Profile(EnumProfile.FOOT_WALKING));
        req.getParameters().setLocations(new Locations(Arrays.asList(
                new Coordinate(-40.76612, -19.247029),
                new Coordinate(-40.704441, -19.288167),
                new Coordinate(-40.729849, -19.108081),
                new Coordinate(-40.838284, -19.228513),
                new Coordinate(-40.817816, -19.057122),
                new Coordinate(-40.861674, -18.953331),
                new Coordinate(-40.849368, -18.941690)
        )));
        System.out.println(UtilityFunctions.getJSONArrayFromCoordinateList(req.getParameters().getLocations().getLocations()));
//        if(true) {
//            for (Coordinate c : req.getParameters().getLocations().getTypedValue())
//                System.out.printf("%f,%f|", c.getX(), c.getY());
//            return;
//        }
        System.out.println("COORDSIZE: " + req.getParameters().getLocations().getLocations().size());
        req.getParameters().setMetrics(new Metrics(Arrays.asList(EnumMetrics.values())));
        req.getParameters().setResolveLocations(new ResolveLocations(true));
//        req.getParameters().setSources(new Sources(new Integer[] {8,9,10,11,12,13,14,15,16,17}));
        List<Integer> sourceIndexes = UtilityFunctions.getIntegerList(0, 3);
        System.out.println(UtilityFunctions.getIntegerJSONArray(sourceIndexes));
        req.getParameters().setSources(new Sources(sourceIndexes));
//        req.getParameters().setDestinations(new Destinations(new Integer[] {0,1,2,3,4,5,6,7}));
        List<Integer> destinationIndexes = UtilityFunctions.getIntegerList(3, req.getParameters().getLocations().getLocations().size());
        System.out.println(UtilityFunctions.getIntegerJSONArray(destinationIndexes));
        req.getParameters().setDestinations(new Destinations(destinationIndexes));
//        req.getParameters().setSources(new Sources(req.getParameters().getLocations().getTypedValue().subList(0, 3)));
//        try {
        MatrixV2Response res = req.makeRequest();
        System.out.println(res.getRequestCounter() + " Requests");
        int rows = res.getDistances().size();
        Assert.assertEquals(rows, sourceIndexes.size());
        for (List<Double> distances : res.getDistances())
            Assert.assertEquals(destinationIndexes.size(), distances.size());
        System.out.println(res.getOptions().getLocations().size());
        System.out.println(res.getOptions().getSources().size());
        System.out.println(res.getOptions().getDestinations().size());
//            System.out.println("DURATIONS");
//            if(res.getDurations() != null)
//                for (List<Double> i :
//                        res.getDurations()) {
//                    for (Double j :
//                            i) {
//                        System.out.print(j + "               ");
//                    }
//                    System.out.println();
//                }
//            else
//                System.out.println("null");
//            System.out.println("DISTANCES");
//            if(res.getDistances() != null)
//                for (List<Double> i :
//                        res.getDistances()) {
//                    for (Double j :
//                            i) {
//                        System.out.print(j + "               ");
//                    }
//                    System.out.println();
//                }
//            else
//                System.out.println("null");
//            System.out.println("SOURCES");
//            for (LocationDescription ld :
//                    res.getSources()) {
//                System.out.println(ld);
//            }
//            System.out.println("DESTINATIONS");
//            for (LocationDescription ld :
//                    res.getDestinations()) {
//                System.out.println(ld);
//            }
//            System.out.println("OPTIONS");
//            System.out.println(res.getOptions().getProfile());
//            System.out.println(res.getOptions().getUnits());
//        } catch (InvalidParameters | RequestException invalidParameters) {
//            invalidParameters.printStackTrace();
//        }
    }
}

