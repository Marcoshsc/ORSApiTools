package com.github.marcoshsc.apiTests;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumMetrics;
import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.general.ORSEndpoints;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.parameters.Profile;
import com.github.marcoshsc.orsApiTools.matrix.MatrixResponse;
import com.github.marcoshsc.orsApiTools.matrix.ORSMatrixRequest;
import com.github.marcoshsc.orsApiTools.matrix.parameters.*;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import util.ApiKeyGetter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MatrixTest {

    @Test
    public void simpleTest() throws InvalidParameters, RequestException, IOException {
        ORSMatrixRequest req = ORSEndpoints.getMatrix(ApiKeyGetter.getApiKey());
        req.getParameters().setProfile(new Profile(EnumProfile.DRIVING_CAR));
        req.getParameters().setLocations(new Locations(Arrays.asList(
//                new Coordinate(-43.177152,-19.807156),
//                new Coordinate(-43.167751,-19.835670),
//                new Coordinate(-43.167317,-19.817133),
//                new Coordinate(-43.152841,-19.817006),
//                new Coordinate(-43.152820,-19.816),
//                new Coordinate(-43.1528,-19.818)
                //autogeneradas daqui pra baixo
                new Coordinate(-43.137310,-19.826766),
                new Coordinate(-43.194550,-19.837363),
                new Coordinate(-43.159798,-19.821897),
                new Coordinate(-43.178737,-19.830605),
                new Coordinate(-43.189509,-19.831796),
                new Coordinate(-43.183802,-19.807486),
                new Coordinate(-43.178038,-19.843729),
                new Coordinate(-43.159512,-19.844640),
                new Coordinate(-43.139293,-19.796781),
                new Coordinate(-43.178895,-19.805000),
                new Coordinate(-43.142083,-19.850139),
                new Coordinate(-43.133913,-19.825313),
                new Coordinate(-43.133747,-19.802278),
                new Coordinate(-43.174012,-19.802087),
                new Coordinate(-43.166371,-19.842228),
                new Coordinate(-43.185446,-19.848877),
                new Coordinate(-43.201951,-19.831793),
                new Coordinate(-43.158656,-19.832994),
                new Coordinate(-43.150216,-19.819367),
                new Coordinate(-43.137168,-19.839537),
                new Coordinate(-43.134750,-19.816855),
                new Coordinate(-43.201297,-19.802718),
                new Coordinate(-43.142207,-19.837923),
                new Coordinate(-43.152685,-19.845241),
                new Coordinate(-43.147659,-19.801968),
                new Coordinate(-43.153089,-19.823931),
                new Coordinate(-43.134152,-19.817772),
                new Coordinate(-43.137807,-19.829920),
                new Coordinate(-43.158881,-19.813998),
                new Coordinate(-43.171193,-19.823648),
                new Coordinate(-43.177524,-19.834850),
                new Coordinate(-43.193820,-19.825711),
                new Coordinate(-43.133185,-19.837486),
                new Coordinate(-43.166705,-19.830471),
                new Coordinate(-43.137047,-19.835883),
                new Coordinate(-43.147317,-19.827705),
                new Coordinate(-43.131744,-19.835914),
                new Coordinate(-43.141999,-19.819998),
                new Coordinate(-43.185579,-19.843292),
                new Coordinate(-43.168947,-19.824531),
                new Coordinate(-43.140941,-19.839817),
                new Coordinate(-43.164545,-19.807489),
                new Coordinate(-43.192651,-19.819996),
                new Coordinate(-43.195857,-19.839219),
                new Coordinate(-43.186413,-19.812171),
                new Coordinate(-43.186485,-19.806849),
                new Coordinate(-43.165418,-19.796225),
                new Coordinate(-43.170638,-19.817956),
                new Coordinate(-43.163621,-19.838823),
                new Coordinate(-43.200464,-19.829726),
                new Coordinate(-43.192428,-19.817792),
                new Coordinate(-43.165027,-19.842499),
                new Coordinate(-43.174371,-19.839877),
                new Coordinate(-43.134429,-19.824615),
                new Coordinate(-43.162898,-19.847214),
                new Coordinate(-43.144513,-19.817275),
                new Coordinate(-43.135451,-19.820674),
                new Coordinate(-43.175193,-19.811572),
                new Coordinate(-43.143461,-19.833478),
                new Coordinate(-43.194732,-19.828124),
        new Coordinate(-43.138380,-19.837383),
        new Coordinate(-43.133921,-19.815077),
        new Coordinate(-43.142618,-19.846531),
        new Coordinate(-43.151651,-19.819036),
        new Coordinate(-43.197074,-19.816779),
        new Coordinate(-43.169701,-19.848078),
        new Coordinate(-43.198745,-19.830764),
        new Coordinate(-43.178526,-19.810324),
        new Coordinate(-43.192925,-19.798249),
        new Coordinate(-43.152140,-19.811561),
        new Coordinate(-43.163646,-19.813063),
        new Coordinate(-43.135045,-19.822324),
        new Coordinate(-43.158930,-19.819878),
        new Coordinate(-43.170520,-19.844599),
        new Coordinate(-43.193816,-19.805762),
        new Coordinate(-43.190015,-19.808200),
        new Coordinate(-43.144176,-19.819391),
        new Coordinate(-43.133983,-19.821531),
        new Coordinate(-43.145805,-19.829724),
        new Coordinate(-43.184427,-19.802548),
        new Coordinate(-43.152104,-19.816611),
        new Coordinate(-43.162511,-19.839505),
        new Coordinate(-43.179168,-19.794607),
        new Coordinate(-43.191375,-19.805986),
        new Coordinate(-43.141078,-19.846292),
        new Coordinate(-43.190830,-19.797717),
        new Coordinate(-43.167626,-19.830777),
        new Coordinate(-43.154837,-19.821237),
        new Coordinate(-43.184345,-19.839003),
        new Coordinate(-43.151023,-19.822772),
        new Coordinate(-43.194560,-19.798264),
        new Coordinate(-43.140561,-19.805366),
        new Coordinate(-43.154416,-19.813132),
        new Coordinate(-43.167139,-19.796400),
        new Coordinate(-43.176333,-19.816244),
        new Coordinate(-43.186754,-19.815066),
        new Coordinate(-43.186897,-19.841501),
        new Coordinate(-43.152371,-19.825712),
        new Coordinate(-43.152816,-19.818377),
        new Coordinate(-43.186176,-19.835351),
        new Coordinate(-43.188870,-19.838144),
        new Coordinate(-43.171055,-19.830346),
        new Coordinate(-43.170749,-19.798352),
        new Coordinate(-43.159247,-19.842658),
        new Coordinate(-43.138297,-19.821480),
        new Coordinate(-43.166201,-19.817220),
        new Coordinate(-43.187283,-19.823300),
        new Coordinate(-43.153831,-19.841788),
        new Coordinate(-43.153686,-19.847893),
        new Coordinate(-43.161852,-19.806649),
        new Coordinate(-43.185851,-19.811326),
        new Coordinate(-43.154119,-19.836572),
        new Coordinate(-43.148051,-19.821009),
        new Coordinate(-43.157787,-19.822056),
        new Coordinate(-43.181324,-19.800365),
        new Coordinate(-43.195541,-19.794742),
        new Coordinate(-43.182377,-19.844435),
        new Coordinate(-43.160946,-19.842204),
        new Coordinate(-43.157686,-19.812777),
        new Coordinate(-43.187969,-19.807985),
        new Coordinate(-43.195283,-19.815306),
        new Coordinate(-43.185148,-19.823741),
        new Coordinate(-43.161902,-19.817097),
        new Coordinate(-43.160632,-19.798104),
        new Coordinate(-43.163518,-19.838859),
        new Coordinate(-43.182360,-19.836640),
        new Coordinate(-43.184702,-19.818572),
        new Coordinate(-43.169480,-19.820271),
        new Coordinate(-43.144011,-19.822211),
        new Coordinate(-43.155658,-19.797423),
        new Coordinate(-43.190481,-19.846870),
        new Coordinate(-43.174106,-19.820251),
        new Coordinate(-43.172091,-19.795887),
        new Coordinate(-43.171847,-19.848849),
        new Coordinate(-43.169122,-19.846150),
        new Coordinate(-43.180242,-19.803801),
        new Coordinate(-43.191464,-19.811105),
        new Coordinate(-43.193806,-19.804218),
        new Coordinate(-43.137762,-19.817661),
        new Coordinate(-43.134547,-19.827942),
        new Coordinate(-43.182967,-19.810025),
        new Coordinate(-43.148550,-19.817352),
        new Coordinate(-43.149343,-19.828889),
        new Coordinate(-43.197602,-19.813115),
        new Coordinate(-43.139676,-19.844481),
        new Coordinate(-43.165309,-19.812648),
        new Coordinate(-43.194738,-19.812242),
        new Coordinate(-43.169683,-19.839142),
        new Coordinate(-43.189309,-19.842454),
        new Coordinate(-43.134682,-19.836964),
        new Coordinate(-43.195494,-19.847239),
        new Coordinate(-43.147558,-19.834825),
        new Coordinate(-43.152575,-19.841115),
        new Coordinate(-43.137658,-19.805643),
        new Coordinate(-43.186960,-19.847914),
        new Coordinate(-43.157062,-19.825759),
        new Coordinate(-43.149382,-19.835430),
        new Coordinate(-43.159212,-19.828296),
        new Coordinate(-43.191653,-19.820961),
        new Coordinate(-43.179149,-19.823771),
        new Coordinate(-43.178952,-19.843416),
        new Coordinate(-43.145204,-19.800754),
        new Coordinate(-43.145261,-19.844047),
        new Coordinate(-43.194295,-19.811928),
        new Coordinate(-43.202533,-19.829984),
        new Coordinate(-43.200913,-19.838787),
        new Coordinate(-43.142668,-19.831351),
        new Coordinate(-43.193484,-19.839856),
        new Coordinate(-43.161002,-19.811312),
        new Coordinate(-43.198829,-19.826824),
        new Coordinate(-43.193623,-19.814633),
        new Coordinate(-43.159393,-19.833284),
        new Coordinate(-43.148420,-19.835068),
        new Coordinate(-43.191447,-19.813480),
        new Coordinate(-43.165649,-19.840301),
        new Coordinate(-43.184518,-19.798916),
        new Coordinate(-43.199260,-19.836112),
        new Coordinate(-43.151979,-19.806128),
        new Coordinate(-43.151032,-19.839919),
        new Coordinate(-43.201752,-19.818936),
        new Coordinate(-43.162968,-19.819559),
        new Coordinate(-43.162935,-19.799354),
        new Coordinate(-43.167713,-19.840807),
        new Coordinate(-43.179279,-19.814170),
        new Coordinate(-43.160158,-19.815118),
        new Coordinate(-43.160539,-19.843328),
        new Coordinate(-43.144916,-19.820410),
        new Coordinate(-43.171750,-19.804688),
        new Coordinate(-43.146155,-19.833619),
        new Coordinate(-43.201965,-19.836520),
        new Coordinate(-43.202394,-19.825165),
        new Coordinate(-43.171121,-19.849858),
        new Coordinate(-43.143871,-19.849777),
        new Coordinate(-43.147014,-19.850660),
        new Coordinate(-43.199510,-19.824271),
        new Coordinate(-43.145749,-19.816143),
        new Coordinate(-43.162397,-19.833052),
        new Coordinate(-43.192708,-19.830783),
        new Coordinate(-43.201001,-19.850220),
        new Coordinate(-43.173462,-19.822818)

        )));
//        if(true) {
//            for (Coordinate c : req.getParameters().getLocations().getTypedValue())
//                System.out.printf("%f,%f|", c.getX(), c.getY());
//            return;
//        }
        System.out.println("COORDSIZE: " + req.getParameters().getLocations().getTypedValue().size());
        req.getParameters().setMetrics(new Metrics(Arrays.asList(EnumMetrics.values())));
        req.getParameters().setResolveLocations(new ResolveLocations(true));
//        req.getParameters().setSources(new Sources(new Integer[] {8,9,10,11,12,13,14,15,16,17}));
        List<Integer> sourceIndexes = UtilityFunctions.getIntegerList(0, 70);
        req.getParameters().setSources(new Sources(sourceIndexes));
//        req.getParameters().setDestinations(new Destinations(new Integer[] {0,1,2,3,4,5,6,7}));
        List<Integer> destinationIndexes = UtilityFunctions.getIntegerList(70, 124);
        req.getParameters().setDestinations(new Destinations(destinationIndexes));
//        req.getParameters().setSources(new Sources(req.getParameters().getLocations().getTypedValue().subList(0, 3)));
//        try {
        MatrixResponse res = req.makeRequest();
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
