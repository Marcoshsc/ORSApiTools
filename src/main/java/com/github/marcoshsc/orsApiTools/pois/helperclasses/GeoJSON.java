package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import com.github.marcoshsc.orsApiTools.pois.enums.GeoJSONTypes;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

/**
 * A GeoJSON representation. It holds a type and a point. Currently only supported type is "Point".
 *
 * @author Marcos Henrique
 */
public class GeoJSON {

    /**
     * Type of GeoJSON to be used.
     */
    private GeoJSONTypes type = GeoJSONTypes.POINT;
    /**
     * Coordinate referencing a point in the map.
     */
    private Coordinate point;

    public GeoJSON(Coordinate point) {
        this.point = point;
    }

    /**
     * Return the GeoJSON object as a JSON.
     * @return the JSON representation of the object.
     * @throws JSONException if some JSON parsing error happened.
     */
    public JSONObject getGeoJSON() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("type", "Point");
        obj.put("coordinates", UtilityFunctions.getCoordinateJSONArray(point.getX(), point.getY()));
        return obj;
    }

    public GeoJSONTypes getType() {
        return type;
    }

    public Coordinate getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "GeoJSON{" +
                "type=" + type +
                ", point=" + point +
                "}\n";
    }
}
