package com.github.marcoshsc.orsApiTools.pois.enums;

/**
 * Represent all the possible values to the "geojson.type" parameter.
 *
 * @author Marcos Henrique
 */
public enum GeoJSONTypes {

    /**
     * Single coordinate
     */
    POINT("Point"),

    /**
     * List of coordinates
     */
    LINE_STRING("LineString"),

    /**
     * List of Lists of coordinates.
     */
    POLYGON("Polygon");

    private String value;

    GeoJSONTypes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
