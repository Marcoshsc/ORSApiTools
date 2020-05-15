package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.GeoJSON;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

/**
 * The geometry object which is a geojson or a bounding box object, optionally buffered.
 * Buffer value: it's not required but if you don't specify it will not return any results. Increasing the value of the
 * buffer will increase the number of returned results, if available.
 *
 * Bounding box OR geoJSON can be set as null if they are not being used.
 *
 * @author Marcos Henrique
 */
public class PoisGeometry implements JSONBodyParameter<JSONObject> {

    private static final String name = "geometry";
    /**
     * Bounding box of geometry object.
     */
    private BoundingBox boundingBox;
    /**
     * GeoJSON object representing either a Point, LineString or Polygon.
     */
    private GeoJSON geoJSON;
    /**
     * Total buffer size. Greater buffer values mean more results returned. [1, 2000] interval.
     */
    int buffer;

    public PoisGeometry(BoundingBox boundingBox, GeoJSON geoJSON, int buffer) {
        this.boundingBox = boundingBox;
        this.geoJSON = geoJSON;
        this.buffer = buffer;
    }

    /**
     *
     * @return the parameter name.
     */
    @Override
    public String getKey() {
        return name;
    }

    /**
     *
     * @return the final processed object referent to the parameter.
     */
    @Override
    public JSONObject getValue() throws JSONException {
        JSONObject finalObj = new JSONObject();
        if(boundingBox != null)
            finalObj.put("bbox", getJSONArrayBoundingBox());
        if(geoJSON != null)
            finalObj.put("geojson", geoJSON.getGeoJSON());
        finalObj.put("buffer", buffer);
        return finalObj;
    }

    private JSONArray getJSONArrayBoundingBox() throws JSONException {
        JSONArray fullArray = new JSONArray();
        fullArray.put(UtilityFunctions.getCoordinateJSONArray(boundingBox.getMinLongitude(), boundingBox.getMinLatitude()));
        fullArray.put(UtilityFunctions.getCoordinateJSONArray(boundingBox.getMaxLongitude(), boundingBox.getMaxLatidude()));
        return fullArray;
    }

    public static void main(String[] args) throws JSONException {
        JSONObject obj = new JSONObject();
        PoisGeometry geo = new PoisGeometry(new BoundingBox(2,4,1,3),
                new GeoJSON(new Coordinate(1, 2)), 250);
        obj.put(geo.getKey(), geo.getValue());
        System.out.println(obj);
    }

    public int getBuffer() {
        return buffer;
    }

    public GeoJSON getGeoJSON() {
        return geoJSON;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
}
