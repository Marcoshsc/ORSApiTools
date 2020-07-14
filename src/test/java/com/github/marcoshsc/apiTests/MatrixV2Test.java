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
                new Coordinate(-47.050871,-17.841496),
                new Coordinate(-47.044044,-17.636455),
                new Coordinate(-47.100653,-17.795555),
                new Coordinate(-47.030208,-17.81385),
                new Coordinate(-47.214168,-17.733528),
                new Coordinate(-47.230037,-17.615438),
                new Coordinate(-47.045742,-17.637855),
                new Coordinate(-47.180205,-17.837552),
                new Coordinate(-47.038742,-17.811614),
                new Coordinate(-46.957815,-17.725709),
                new Coordinate(-46.994026,-17.640546),
                new Coordinate(-47.221698,-17.608034),
                new Coordinate(-47.212646,-17.557435),
                new Coordinate(-47.196921,-17.845318),
                new Coordinate(-47.044529,-17.637544),
                new Coordinate(-46.956895,-17.830569),
                new Coordinate(-47.273093,-17.823871),
                new Coordinate(-46.940951,-17.651787),
                new Coordinate(-47.077461,-17.91545),
                new Coordinate(-47.167979,-17.748248),
                new Coordinate(-47.098308,-17.790426),
                new Coordinate(-47.101275,-17.796878),
                new Coordinate(-47.144636,-17.616475),
                new Coordinate(-46.961961,-17.658821),
                new Coordinate(-46.975274,-17.727186),
                new Coordinate(-47.213063,-17.557258),
                new Coordinate(-47.255373,-17.794005),
                new Coordinate(-47.019825,-17.812159),
                new Coordinate(-47.071233,-17.633857),
                new Coordinate(-47.08376,-17.837992),
                new Coordinate(-47.0439,-17.636732),
                new Coordinate(-46.989641,-17.641681),
                new Coordinate(-46.956855,-17.847884),
                new Coordinate(-46.989942,-17.535757),
                new Coordinate(-47.269328,-17.824983),
                new Coordinate(-47.183902,-17.726916),
                new Coordinate(-47.270905,-17.824544),
                new Coordinate(-46.971528,-17.503723),
                new Coordinate(-47.036725,-17.814653),
                new Coordinate(-47.278273,-17.788993),
                new Coordinate(-47.100789,-17.579894),
                new Coordinate(-47.092928,-17.647314),
                new Coordinate(-47.205936,-17.729907),
                new Coordinate(-47.183924,-17.662),
                new Coordinate(-47.108914,-17.752202),
                new Coordinate(-47.114604,-17.828741),
                new Coordinate(-46.972566,-17.725117),
                new Coordinate(-47.090097,-17.723001),
                new Coordinate(-47.235103,-17.591986),
                new Coordinate(-46.988398,-17.536862),
                new Coordinate(-46.95296,-17.510526),
                new Coordinate(-46.970393,-17.530027),
                new Coordinate(-46.972948,-17.543213),
                new Coordinate(-47.157865,-17.879513),
                new Coordinate(-47.076427,-17.857825),
                new Coordinate(-46.889136,-17.481196),
                new Coordinate(-47.040709,-17.475712),
                new Coordinate(-47.19574,-17.845822),
                new Coordinate(-47.273972,-17.8236),
                new Coordinate(-47.242066,-17.506598),
                new Coordinate(-47.198272,-17.844729),
                new Coordinate(-47.042804,-17.679744),
                new Coordinate(-47.040574,-17.774594),
                new Coordinate(-47.08642,-17.640546),
                new Coordinate(-47.093099,-17.777059),
                new Coordinate(-47.060969,-17.875745),
                new Coordinate(-46.982509,-17.644894),
                new Coordinate(-47.26995,-17.82481),
                new Coordinate(-47.102394,-17.799258),
                new Coordinate(-47.269603,-17.824907),
                new Coordinate(-47.042698,-17.637887),
                new Coordinate(-47.055396,-17.883709),
                new Coordinate(-47.140151,-17.682517),
                new Coordinate(-47.03261,-17.644889),
                new Coordinate(-47.141259,-17.608946),
                new Coordinate(-47.15822,-17.91289),
                new Coordinate(-46.9245,-17.742211),
                new Coordinate(-46.981592,-17.887025),
                new Coordinate(-47.335205,-17.787028),
                new Coordinate(-47.098827,-17.582673),
                new Coordinate(-46.973566,-17.546432),
                new Coordinate(-47.094659,-17.745237),
                new Coordinate(-47.257028,-17.772421),
                new Coordinate(-47.090549,-17.831443),
                new Coordinate(-47.189298,-17.556417),
                new Coordinate(-47.247939,-17.657026),
                new Coordinate(-47.128808,-17.834567),
                new Coordinate(-47.017515,-17.554828),
                new Coordinate(-47.272136,-17.824166),
                new Coordinate(-46.958554,-17.725603),
                new Coordinate(-46.95497,-17.511345),
                new Coordinate(-47.042836,-17.905891),
                new Coordinate(-47.137685,-17.834412),
                new Coordinate(-47.041531,-17.775228),
                new Coordinate(-46.979563,-17.534312),
                new Coordinate(-47.250222,-17.805005),
                new Coordinate(-46.889464,-17.215513),
                new Coordinate(-47.271258,-17.824437),
                new Coordinate(-47.048252,-17.838946),
                new Coordinate(-47.108333,-17.751119),
                new Coordinate(-47.031546,-17.608405),
                new Coordinate(-47.085643,-17.666115),
                new Coordinate(-47.123486,-17.744083),
                new Coordinate(-47.067528,-17.705862),
                new Coordinate(-47.101291,-17.74268),
                new Coordinate(-46.93531,-17.502505),
                new Coordinate(-47.215363,-17.55554),
                new Coordinate(-47.071426,-17.909084),
                new Coordinate(-47.271503,-17.824362),
                new Coordinate(-46.982041,-17.520928),
                new Coordinate(-47.210396,-17.558386),
                new Coordinate(-47.036048,-17.649703),
                new Coordinate(-47.094022,-17.650923),
                new Coordinate(-47.294733,-17.79262),
                new Coordinate(-47.087789,-17.57117),
                new Coordinate(-47.009801,-17.64667),
                new Coordinate(-47.058609,-17.890659),
                new Coordinate(-47.271253,-17.824439),
                new Coordinate(-47.218391,-17.630239),
                new Coordinate(-47.089152,-17.643388),
                new Coordinate(-47.047195,-17.687797),
                new Coordinate(-47.043495,-17.637445),
                new Coordinate(-47.272133,-17.824167),
                new Coordinate(-47.218515,-17.552534),
                new Coordinate(-47.02966,-17.649625),
                new Coordinate(-47.202239,-17.561758),
                new Coordinate(-47.20347,-17.561256),
                new Coordinate(-47.09262,-17.729822),
                new Coordinate(-47.167444,-17.76355),
                new Coordinate(-47.037091,-17.62149),
                new Coordinate(-47.012189,-17.646835),
                new Coordinate(-47.060247,-17.87673),
                new Coordinate(-47.04527,-17.832384),
                new Coordinate(-47.252608,-17.827987),
                new Coordinate(-47.197296,-17.559226),
                new Coordinate(-47.025886,-17.602948),
                new Coordinate(-47.239248,-17.520214),
                new Coordinate(-46.970087,-17.512416),
                new Coordinate(-46.987641,-17.53691),
                new Coordinate(-47.050861,-17.609304),
                new Coordinate(-46.952085,-17.840177),
                new Coordinate(-47.273695,-17.823685),
                new Coordinate(-47.123749,-17.833982),
                new Coordinate(-47.092595,-17.699643),
                new Coordinate(-47.048371,-17.775064),
                new Coordinate(-47.317102,-17.85112),
                new Coordinate(-46.982696,-17.784573),
                new Coordinate(-47.318081,-17.742848),
                new Coordinate(-47.270254,-17.824725),
                new Coordinate(-47.109593,-17.947106),
                new Coordinate(-46.99345,-17.570786),
                new Coordinate(-47.12858,-17.834542),
                new Coordinate(-47.22979,-17.615632),
                new Coordinate(-47.090609,-17.776531),
                new Coordinate(-47.31749,-17.741654),

                new Coordinate(-47.247939,-17.657026),
                new Coordinate(-47.017515,-17.554828),
                new Coordinate(-47.27148,-17.82429),
                new Coordinate(-46.98964,-17.64168),
                new Coordinate(-47.214168,-17.733528),
                new Coordinate(-47.12375,-17.83398),
                new Coordinate(-47.042836,-17.905891),
                new Coordinate(-47.180205,-17.837552),
                new Coordinate(-47.137685,-17.834412),
                new Coordinate(-46.98764,-17.5369),
                new Coordinate(-47.221698,-17.608034),
                new Coordinate(-47.09012,-17.72299),
                new Coordinate(-47.31808,-17.74285),
                new Coordinate(-47.250222,-17.805005),
                new Coordinate(-46.95628,-17.83188),
                new Coordinate(-46.889464,-17.215513),
                new Coordinate(-47.21535,-17.55553),
                new Coordinate(-47.031546,-17.608405),
                new Coordinate(-47.0554,-17.88371),
                new Coordinate(-47.085643,-17.666115),
                new Coordinate(-46.940951,-17.651787),
                new Coordinate(-47.123486,-17.744083),
                new Coordinate(-47.067528,-17.705862),
                new Coordinate(-47.167979,-17.748248),
                new Coordinate(-46.93531,-17.502505),
                new Coordinate(-47.04825,-17.83895),
                new Coordinate(-47.20347,-17.56126),
                new Coordinate(-46.961961,-17.658821),
                new Coordinate(-47.19573,-17.84579),
                new Coordinate(-47.019825,-17.812159),
                new Coordinate(-47.036048,-17.649703),
                new Coordinate(-47.10074,-17.79552),
                new Coordinate(-46.95296,-17.51053),
                new Coordinate(-47.183902,-17.726916),
                new Coordinate(-47.094022,-17.650923),
                new Coordinate(-47.294733,-17.79262),
                new Coordinate(-47.09474,-17.73561),
                new Coordinate(-47.087789,-17.57117),
                new Coordinate(-46.97009,-17.51242),
                new Coordinate(-47.10834,-17.75112),
                new Coordinate(-47.03873,-17.81158),
                new Coordinate(-47.218391,-17.630239),
                new Coordinate(-47.278273,-17.788993),
                new Coordinate(-47.205936,-17.729907),
                new Coordinate(-47.04453,-17.63754),
                new Coordinate(-47.10088,-17.57997),
                new Coordinate(-47.183924,-17.662),
                new Coordinate(-47.114604,-17.828741),
                new Coordinate(-46.98078,-17.53192),
                new Coordinate(-47.235103,-17.591986),
                new Coordinate(-47.07746,-17.91545),
                new Coordinate(-47.167444,-17.76355),
                new Coordinate(-47.157865,-17.879513),
                new Coordinate(-46.972948,-17.543213),
                new Coordinate(-46.970393,-17.530027),
                new Coordinate(-47.076427,-17.857825),
                new Coordinate(-47.14461,-17.61648),
                new Coordinate(-46.889136,-17.481196),
                new Coordinate(-47.040709,-17.475712),
                new Coordinate(-46.97527,-17.72719),
                new Coordinate(-47.0472,-17.68779),
                new Coordinate(-47.252608,-17.827987),
                new Coordinate(-47.239248,-17.520214),
                new Coordinate(-47.025886,-17.602948),
                new Coordinate(-47.242066,-17.506598),
                new Coordinate(-47.09284,-17.77715),
                new Coordinate(-46.9568,-17.84791),
                new Coordinate(-47.21305,-17.55722),
                new Coordinate(-47.050861,-17.609304),
                new Coordinate(-47.12881,-17.83457),
                new Coordinate(-47.08375,-17.83798),
                new Coordinate(-47.07848,-17.63219),
                new Coordinate(-47.092595,-17.699643),
                new Coordinate(-47.048371,-17.775064),
                new Coordinate(-47.02966,-17.64962),
                new Coordinate(-47.04477,-17.62468),
                new Coordinate(-47.25022,-17.80501),
                new Coordinate(-47.317102,-17.85112),
                new Coordinate(-47.04153,-17.77523),
                new Coordinate(-47.23004,-17.61544),
                new Coordinate(-47.140151,-17.682517),
                new Coordinate(-47.09292,-17.64732),
                new Coordinate(-46.982696,-17.784573),
                new Coordinate(-46.95781,-17.72571),
                new Coordinate(-47.15822,-17.91289),
                new Coordinate(-46.9245,-17.742211),
                new Coordinate(-46.99345,-17.570786),
                new Coordinate(-46.981592,-17.887025),
                new Coordinate(-47.109593,-17.947106),
                new Coordinate(-47.335205,-17.787028),
                new Coordinate(-47.03264,-17.64493),
                new Coordinate(-46.973566,-17.546432),
                new Coordinate(-47.094659,-17.745237),
                new Coordinate(-47.257028,-17.772421),
                new Coordinate(-47.0098,-17.64667),
                new Coordinate(-47.189298,-17.556417)
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
        List<Integer> sourceIndexes = UtilityFunctions.getIntegerList(0, 156);
        System.out.println(UtilityFunctions.getIntegerJSONArray(sourceIndexes));
        System.out.println(sourceIndexes.size());
        req.getParameters().setSources(new Sources(sourceIndexes));
//        req.getParameters().setDestinations(new Destinations(new Integer[] {0,1,2,3,4,5,6,7}));
        List<Integer> destinationIndexes = UtilityFunctions.getIntegerList(156, req.getParameters().getLocations().getLocations().size());
        System.out.println(destinationIndexes.size());
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

