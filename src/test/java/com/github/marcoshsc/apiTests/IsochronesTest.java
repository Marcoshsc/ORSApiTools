package com.github.marcoshsc.apiTests;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.general.ORSEndpoints;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.isochrones.IsochronesParameters;
import com.github.marcoshsc.orsApiTools.isochrones.IsochronesRequest;
import com.github.marcoshsc.orsApiTools.isochrones.IsochronesResponse;
import com.github.marcoshsc.orsApiTools.isochrones.enums.EnumAttributes;
import com.github.marcoshsc.orsApiTools.isochrones.enums.EnumRangeType;
import com.github.marcoshsc.orsApiTools.isochrones.parameters.*;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import util.ApiKeyGetter;

import java.io.IOException;
import java.util.Arrays;

public class IsochronesTest {

    @Test
    public void testing() throws IOException, RequestException {
        IsochronesRequest req = ORSEndpoints.getIsochrones(ApiKeyGetter.getApiKey());
        IsochronesParameters parameters = req.getParameters();
        parameters.setProfile(new Profile(EnumProfile.DRIVING_HGV));
        parameters.setLocations(new Locations(Arrays.asList(new Coordinate(8.681495,
                49.41461), new Coordinate(8.686507,49.41943))));
//        parameters.setRangeType(new RangeType(EnumRangeType.DISTANCE));
        parameters.setRange(new Range(Arrays.asList(100.2, 200.0)));
        parameters.setSmoothing(new Smoothing(13));
//        parameters.setAttributes(new Attributes(Arrays.asList(EnumAttributes.values())));
        IsochronesResponse response = req.makeRequest();
    }

}
