package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import org.locationtech.jts.geom.Coordinate;

/**
 * Represents a location, that have a coordinate and it's properties. Both are guaranteed to not be null.
 *
 * @author Marcos Henrique
 */
public class PoisLocation {

    /**
     * Location point
     */
    private Coordinate coordinate;
    /**
     * Properties about the location
     */
    private Properties properties;

    public PoisLocation(Coordinate coordinate, Properties properties) {
        this.coordinate = coordinate;
        this.properties = properties;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "PoisLocation{" +
                "coordinate=" + coordinate +
                ", properties=" + properties +
                "}\n";
    }
}
