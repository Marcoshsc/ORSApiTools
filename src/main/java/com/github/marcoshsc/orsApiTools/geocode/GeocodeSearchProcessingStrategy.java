package com.github.marcoshsc.orsApiTools.geocode;

import com.github.marcoshsc.orsApiTools.general.interfaces.JSONProcessingStrategy;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.Location;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.util.*;

/**
 * JSON processing strategy implementation, for geocode/search endpoint.
 *
 * @author Marcos Henrique
 */
public class GeocodeSearchProcessingStrategy implements JSONProcessingStrategy<GeocodeSearchResponse> {

    /**
     *
     * @param obj the JSON to be processed.
     * @return java object resulting of the JSON processing.
     * @throws JSONException if some JSON parsing error happened.
     */
    @Override
    public GeocodeSearchResponse processJSON(JSONObject obj) throws JSONException {
        List<Location> locations = new ArrayList<>();
        JSONArray features = obj.getJSONArray("features");
        for (int i = 0; i < features.length(); i++) {
            JSONObject feature = features.getJSONObject(i);
            Location location = getLocation(feature);
            locations.add(location);
        }
        return new GeocodeSearchResponse(obj, locations);
    }

    private Location getLocation(JSONObject feature) throws JSONException {
        Coordinate coords = getCoordinates(feature);

        Map<String, String> properties = getProperties(feature);

        BoundingBox boundingBox = getBoundingBox(feature);

        return new Location(coords, properties, boundingBox);
    }

    private Coordinate getCoordinates(JSONObject feature) throws JSONException {
        JSONArray coordsArray = feature.getJSONObject("geometry").getJSONArray("coordinates");
        return new Coordinate(coordsArray.getDouble(0), coordsArray.getDouble(1));
    }

    private Map<String, String> getProperties(JSONObject feature) throws JSONException {
        JSONObject propertiesJSON = feature.getJSONObject("properties");
        Iterator<?> keys = propertiesJSON.keys();
        Map<String, String> properties = new HashMap<>();
        while(keys.hasNext()) {
            String key = keys.next().toString();
            String value = propertiesJSON.get(key).toString();
            properties.put(key, value);
        }
        return properties;
    }

    private BoundingBox getBoundingBox(JSONObject feature) throws JSONException {
        if(!feature.has("bbox"))
            return null;
        JSONArray boundingBoxJSON = feature.getJSONArray("bbox");
        return new BoundingBox(
                boundingBoxJSON.getDouble(1),
                boundingBoxJSON.getDouble(3),
                boundingBoxJSON.getDouble(0),
                boundingBoxJSON.getDouble(2)
        );
    }

}
