package com.github.marcoshsc.apiTests;

import com.github.marcoshsc.orsApiTools.general.exceptions.InvalidParameters;
import com.github.marcoshsc.orsApiTools.general.exceptions.RequestException;
import com.github.marcoshsc.orsApiTools.general.parameters.ApiKey;
import com.github.marcoshsc.orsApiTools.geocode.GeocodeSearchRequest;
import com.github.marcoshsc.orsApiTools.geocode.GeocodeSearchResponse;
import com.github.marcoshsc.orsApiTools.geocode.enums.GeocodeLayers;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.Location;
import com.github.marcoshsc.orsApiTools.geocode.parameters.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import util.ApiKeyGetter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GeocodeTest {

    @Test
    public void simpleTest() throws InvalidParameters, RequestException, IOException {
        String key = ApiKeyGetter.getApiKey();
        GeocodeSearchRequest request = new GeocodeSearchRequest(key);
        request.getParameters().setText(new Text("Avenida Getúlio Vargas, JM"));
        GeocodeSearchResponse response = request.makeRequest();
        for (Location location :
                response.getFoundLocations()) {
            System.out.println(location.getCoordinates());
        }
    }

    @SuppressWarnings("unlikely-arg-type")
	@Test
    public void gonnaFoundCitiesTest() throws InvalidParameters, RequestException, IOException {
        GeocodeSearchRequest req = new GeocodeSearchRequest(ApiKeyGetter.getApiKey());
        req.getParameters().setText(new Text("Avenida Getúlio Vargas, JM"));
        GeocodeSearchResponse res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 10);
        List<Integer> lengthArray = getGonnaFoundSizes();
        List<Coordinate> coordArray = getGonnaFoundCoordinates();
        for(int i = 0; i < lengthArray.size(); i++) {
            assertEquals(res.getFoundLocations().get(i).getProperties().size(), lengthArray.get(i).intValue());
            assertTrue(res.getFoundLocations().get(i).getCoordinates().equals2D(coordArray.get(i)));
        }

        // Testing for maximum size
        req.getParameters().setSize(new Size(100));
        res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 40);

        // Minimum size
        req.getParameters().setSize(new Size(0));
        res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 1);

        // Country
        req.getParameters().setSize(null);
        req.getParameters().setBoundaryCountry(new BoundaryCountry("DE"));
        res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 3);

        // invalid text
        req.getParameters().setBoundaryCountry(null);
        req.getParameters().setText(new Text("feowjfepwoifjew"));
        res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 0);

        // boundary.circle
        req.getParameters().setText(new Text("Avenida Getúlio Vargas, JM"));
        req.getParameters().setBoundaryCircleLongitude(new BoundaryCircleLongitude(-43.1748));
        req.getParameters().setBoundaryCircleLatitude(new BoundaryCircleLatitude(-19.820358));
        res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 3);

        // boundary.circle
        req.getParameters().setBoundaryCircleRadius(new BoundaryCircleRadius(100d));
        res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 10);

        // focus.point and boundary.circle
        req.getParameters().setBoundaryCircleRadius(null);
        req.getParameters().setFocusPointLatitude(new FocusPointLatitude(-19.820358));
        req.getParameters().setFocusPointLongitude(new FocusPointLongitude(-43.1748));
        res = req.makeRequest();
        assertTrue(res.getFoundLocations().get(0).getCoordinates().equals2D(new Coordinate(-43.169208,
                -19.809736)));

        // focus.point
        req.getParameters().setBoundaryCircleLatitude(null);
        req.getParameters().setBoundaryCircleLongitude(null);
        res = req.makeRequest();
        assertTrue(res.getFoundLocations().get(0).getCoordinates().equals2D(new Coordinate(-43.169208,
                -19.809736)));

        // boundary.rect
        req.getParameters().setFocusPointLongitude(null);
        req.getParameters().setFocusPointLatitude(null);
        req.getParameters().setBoundaryRectMaximumLatitude(new BoundaryRectMaximumLatitude(-19.7870631));
        req.getParameters().setBoundaryRectMinimumLatitude(new BoundaryRectMinimumLatitude(-19.896));
        req.getParameters().setBoundaryRectMaximumLongitude(new BoundaryRectMaximumLongitude(-43.0901341));
        req.getParameters().setBoundaryRectMinimumLongitude(new BoundaryRectMinimumLongitude(-43.2235222));
        res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 1);

        // boundary.rect and focus.point
        req.getParameters().setText(new Text("rua"));
        req.getParameters().setFocusPointLongitude(new FocusPointLongitude(-43.1748));
        req.getParameters().setFocusPointLatitude(new FocusPointLatitude(-19.820358));
        res = req.makeRequest();
        assertTrue(res.getFoundLocations().get(0).getCoordinates().equals2D(new Coordinate(-43.173416,
                -19.81884)));

        // boundary.rect and focus.point and boundary.circle
        req.getParameters().setBoundaryCircleLongitude(new BoundaryCircleLongitude(-43.1748));
        req.getParameters().setBoundaryCircleLatitude(new BoundaryCircleLatitude(-19.820358));
        req.getParameters().setBoundaryCircleRadius(new BoundaryCircleRadius(100d));
        res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 10);

        // single layer
        req.getParameters().setText(new Text("avenida"));
        req.getParameters().setLayers(new Layers(Arrays.asList(GeocodeLayers.VENUE)));
        res = req.makeRequest();
        assertEquals(res.getFoundLocations().size(), 1);

        req.getParameters().setLayers(new Layers(Arrays.asList(GeocodeLayers.VENUE, GeocodeLayers.ADDRESS,
                GeocodeLayers.BOROUGH)));
        res = req.makeRequest();
        try {
            JSONArray layers = res.getJsonData().getJSONObject("geocoding").getJSONObject("query").getJSONArray("layers");
            List<String> layersStr = new ArrayList<>();
            for (int i = 0; i < layers.length(); i++) {
                layersStr.add(layers.getString(i));
            }
            assertTrue(layersStr.contains("venue") &&
                        layersStr.contains("address") &&
                        layersStr.contains("borough") &&
                        !layersStr.containsAll(Arrays.asList(GeocodeLayers.values())));
        } catch(JSONException exc) {
            System.out.println(exc.getMessage());
        }
    }

    @Test
    public void testErrors() throws IOException {
        GeocodeSearchRequest req = new GeocodeSearchRequest(ApiKeyGetter.getApiKey());
        try {
            req.makeRequest();
            fail("Didnt failed with no text.");
        } catch(InvalidParameters exc) {
            System.out.println("CORRECT: It fails with no text.");
        } catch(RequestException exc) {
            fail("Didnt failed with no text.");
        }

        req.getParameters().setText(new Text("avenida"));
        req.getParameters().setApiKey(null);
        try {
            req.makeRequest();
            fail("Didnt failed with no api key.");
        } catch(InvalidParameters exc) {
            System.out.println("CORRECT: It fails with no api key.");
        } catch(RequestException exc) {
            fail("Didnt failed with no api key.");
        }

        req.getParameters().setApiKey(new ApiKey(ApiKeyGetter.getApiKey()));
        req.getParameters().setBoundaryRectMinimumLongitude(new BoundaryRectMinimumLongitude(2d));
        testing(req);
        req.getParameters().setBoundaryRectMinimumLongitude(null);

        req.getParameters().setBoundaryRectMaximumLongitude(new BoundaryRectMaximumLongitude(2d));
        testing(req);
        req.getParameters().setBoundaryRectMaximumLongitude(null);

        req.getParameters().setBoundaryRectMinimumLatitude(new BoundaryRectMinimumLatitude(2d));
        testing(req);
        req.getParameters().setBoundaryRectMinimumLatitude(null);

        req.getParameters().setBoundaryRectMaximumLatitude(new BoundaryRectMaximumLatitude(2d));
        testing(req);
        req.getParameters().setBoundaryRectMaximumLatitude(null);

        req.getParameters().setBoundaryCircleLongitude(new BoundaryCircleLongitude(2d));
        testing(req);
        req.getParameters().setBoundaryCircleLongitude(null);

        req.getParameters().setBoundaryCircleLatitude(new BoundaryCircleLatitude(2d));
        testing(req);
        req.getParameters().setBoundaryCircleLatitude(null);

        req.getParameters().setBoundaryCircleRadius(new BoundaryCircleRadius(2d));
        testing(req);
        req.getParameters().setBoundaryCircleRadius(null);

        req.getParameters().setFocusPointLatitude(new FocusPointLatitude(2d));
        testing(req);
        req.getParameters().setFocusPointLatitude(null);

        req.getParameters().setFocusPointLongitude(new FocusPointLongitude(2d));
        testing(req);
        req.getParameters().setFocusPointLongitude(null);
    }

    private void testing(GeocodeSearchRequest req) {
        try {
            req.makeRequest();
            fail("Didnt failed with missing parameters.");
        } catch(InvalidParameters exc) {
            System.out.println(exc.getMessage());
        } catch(RequestException exc) {
            fail("Didnt failed with missing parameters.");
        }
    }

    private List<Coordinate> getGonnaFoundCoordinates() {
        List<Coordinate> list = new ArrayList<>();
        list.add(new Coordinate(-61.300138,
                -5.812255));
        list.add(new Coordinate(-37.326516,
                -6.84619));
        list.add(new Coordinate(-59.892183,
                -7.206265));
        list.add(new Coordinate(-47.679827,
                -9.963001));
        list.add(new Coordinate(-49.373798,
                -28.673107));
        list.add(new Coordinate(-48.215586,
                -13.510241));
        list.add(new Coordinate(-49.045182,
                -22.359325));
        list.add(new Coordinate(-53.407797,
                -27.159569));
        list.add(new Coordinate(-43.42403,
                -19.037162));
        list.add(new Coordinate(-43.477421,
                -19.937013));
        return list;
    }

    private List<Integer> getGonnaFoundSizes() {
        List<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(23);
        list.add(23);
        list.add(23);
        list.add(25);
        list.add(25);
        list.add(25);
        list.add(23);
        list.add(25);
        list.add(25);
        return list;
    }

}
