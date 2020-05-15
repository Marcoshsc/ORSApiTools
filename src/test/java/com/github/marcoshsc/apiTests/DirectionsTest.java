package com.github.marcoshsc.apiTests;

import com.github.marcoshsc.orsApiTools.directions.DirectionsResponse;
import com.github.marcoshsc.orsApiTools.directions.ORSDirectionsRequest;
import com.github.marcoshsc.orsApiTools.directions.enums.*;
import com.github.marcoshsc.orsApiTools.directions.parameters.*;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.Segment;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.Step;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.parameters.Profile;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import util.ApiKeyGetter;

import java.io.IOException;
import java.util.Arrays;

public class DirectionsTest {

    @Test
    public void simpleTest() throws IOException {
        ORSDirectionsRequest req = new ORSDirectionsRequest(ApiKeyGetter.getApiKey());
        req.getParameters().setProfile(new Profile(EnumProfile.DRIVING_CAR));
        req.getParameters().setGeometryFormat(new GeometryFormat(EnumDirectionsGeomType.GEOJSON));
        req.getParameters().setCoordinates(new Coordinates(Arrays.asList(
//                new Coordinate(-43.5876127,-19.6845878),
//                new Coordinate(-43.5840602,-19.6416472)
                new Coordinate(-43.167751,-19.835670),
                new Coordinate(-43.177152,-19.807156),
                new Coordinate(-43.177,-19.807)

        )));
        req.getParameters().setAttributes(new Attributes(Arrays.asList(AttributesEnum.values())));
        req.getParameters().setElevation(new Elevation(false));
        req.getParameters().setManeuvers(new Maneuvers(true));
        req.getParameters().setInstructionsFormat(new InstructionsFormat(InstructionsFormatEnum.HTML));
        req.getParameters().setExtraInfo(new ExtraInfo(ExtraInfoEnum.AVERAGE_SPEED));
        try {
            DirectionsResponse res = req.makeRequest();
//            ExtraInfoField e = res.getExtraInfo().getAvgSpeed();
//            for (int i = 0; i < e.getValues().size(); i++) {
//                System.out.println(e.getValues().get(i).getStartWayPoint());
//                System.out.println(e.getValues().get(i).getEndWayPoint());
//                System.out.println(e.getValues().get(i).getValue());
//                System.out.println("PASSING");
//            }
//            System.out.println();
//            System.out.println("GENERAL");
//            System.out.println("ASCENT " + res.getAscent());
//            System.out.println("DESCENT " + res.getDescent());
//            System.out.println("AVGSPEED " + res.getAvgSpeed());
            for (int i = 0; i < res.getSegments().size(); i++) {
                Segment s = res.getSegments().get(i);
                for (int j = 0; j < s.getSteps().size(); j++) {
                    Step step = s.getSteps().get(j);
                    System.out.println(step.getManeuever());
                }
                System.out.println();
                System.out.println("SEGMENT");
                System.out.println("ASCENT " + res.getSegments().get(i).getAscent());
                System.out.println("DESCENT " + res.getSegments().get(i).getDescent());
                System.out.println("AVGSPEEED " + res.getSegments().get(i).getAvgSpeed());
                System.out.println("PERCENTAGE " + res.getSegments().get(i).getPercentage());
                System.out.println("DETOURFACTOR " + res.getSegments().get(i).getDetourFactor());
            }
//            System.out.println("Stepness");
//            System.out.println(res.getExtraInfo().getSteepness());
//
//            System.out.println("Suitability");
//            System.out.println(res.getExtraInfo().getSuitability());
//
//            System.out.println("surface");
//            System.out.println(res.getExtraInfo().getSurface());
//
//            System.out.println("waycategory");
//            System.out.println(res.getExtraInfo().getWaycategory());
//
//            System.out.println("waytype");
//            System.out.println(res.getExtraInfo().getWaytype());
//
//            System.out.println("tollways");
//            System.out.println(res.getExtraInfo().getTollways());
//
//            System.out.println("traildifficulty");
//            System.out.println(res.getExtraInfo().getTrailDifficulty());
//
//            System.out.println("roadaccessrest");
//            System.out.println(res.getExtraInfo().getRoadAccessRestrictions());
//
//            System.out.println("avgspeed");
//            System.out.println(res.getExtraInfo().getAvgSpeed());
//
//            System.out.println("countryinfo");
//            System.out.println(res.getExtraInfo().getCountryInfo());
//            int soma = 0;
//            for(Segment s : res.getSegments())
//                soma += s.getSteps().size();
//            System.out.println("Distances: " + soma);
//            System.out.println(res.getGeometry().get(0));
//            System.out.println(res.getGeometry().get(1));
//            System.out.println(res.getGeometry().get(res.getGeometry().size() - 1));
//            System.out.println(res.getGeometry().get(res.getGeometry().size() - 2));
//            System.out.println(res.getSegments().size());
//            System.out.println(res.getSegments().get(0).getSteps().size());
//            System.out.println(res.getSegments().get(1).getSteps().size());
//            System.out.println(res.getOptions());
            for (Coordinate coord :
                    res.getGeometry()) {
                System.out.println(coord);
            }
        } catch (RequestException | InvalidParameters e) {
            e.printStackTrace();
        }
    }
}
