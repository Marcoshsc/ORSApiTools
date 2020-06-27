package com.github.marcoshsc.apiTests;

import com.github.marcoshsc.orsApiTools.general.ORSEndpoints;
import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.pois.PoisRequest;
import com.github.marcoshsc.orsApiTools.pois.PoisResponse;
import com.github.marcoshsc.orsApiTools.pois.enums.FeeEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.PoisRequestEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.SortByEnum;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.GeoJSON;
import com.github.marcoshsc.orsApiTools.pois.parameters.*;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.wololo.geojson.Point;
import util.ApiKeyGetter;

import java.io.IOException;
import java.util.Arrays;

public class PoisTest {

    @Test
    public void simpleTest() throws InvalidParameters, RequestException, IOException {
        PoisRequest req = ORSEndpoints.getPois(ApiKeyGetter.getApiKey());
//        new PoisGeometry(new BoundingBox(-19.817912,
//                -19.811088,
//                -43.185859,
//                -43.156382
//        )
        req.getParameters().setRequest(new PoisParameterRequest(PoisRequestEnum.POIS));
        req.getParameters().setGeometry(new PoisGeometry(new BoundingBox(53.0756,
                53.0456,
                8.8034,
                8.7834
        ), new GeoJSON(new Point(new double[] {8.8034,
                53.0756})), 500));
        req.getParameters().setLimit(new Limit(12));
        req.getParameters().setSortBy(new SortBy(SortByEnum.DISTANCE));
        req.getParameters().setFilters(new Filters(
                null,
                Arrays.asList(601),
                null,
                null,
                null,
                Arrays.asList(FeeEnum.YES)
        ));
        PoisResponse res = req.makeRequest();
        for (int i = 0; i < res.getFeatures().size(); i++) {
            System.out.println(res.getFeatures().get(i));
        }
//        System.out.println(res.getBoundingBox());
        System.out.println(res.getOptions());
    }
}
