package com.github.marcoshsc.orsApiTools.geocode.helperclasses;

import org.locationtech.jts.geom.Coordinate;

import java.util.Map;

/**
 *
 * A location's representation, with it's coordinates in the map, bounding box and properties. Note that properties
 * is a map, and it's keys/values might differ from one Location to another.
 * NOTE: BoundingBox can be null.
 *
 * @author Marcos Henrique in 28-04-2020
 */
public class Location {

    private Coordinate coordinates;
    private Map<String, String> properties;
    private BoundingBox boundingBox;

    public Location(Coordinate coordinates, Map<String, String> properties, BoundingBox boundingBox) {
        this.coordinates = coordinates;
        this.properties = properties;
        this.boundingBox = boundingBox;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

}
