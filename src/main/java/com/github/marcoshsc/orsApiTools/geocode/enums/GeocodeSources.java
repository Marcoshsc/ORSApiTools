package com.github.marcoshsc.orsApiTools.geocode.enums;

/**
 * Description of all possible sources on the ORS API (Geocoding).
 *
 * @author Marcos Henrique in 27-04-2020
 */
public enum GeocodeSources {

    OPEN_STREET_MAPS("osm"),
    OPEN_ADDRESSES("oa"),
    WHOS_ON_FIRST("wof"),
    GEONAMES("gn");

    private String value;

    GeocodeSources(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
