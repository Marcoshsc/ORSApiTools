package com.github.marcoshsc.orsApiTools.matrix.v1.helperclasses;

import org.locationtech.jts.geom.Coordinate;

/**
 * Describe either a source or destination of the matrix response on the ORS API.
 *
 * @author Marcos Henrique
 */
public class LocationDescription {
    /**
     * {longitude},{latitude} coordinates of the closest accessible point on the routing graph
     */
    private Coordinate location;
    /**
     * Name of the street the closest accessible point is situated on.
     * Only for resolve_locations=true and only if name is available.
     */
    private String name;
    /**
     * Distance between the source/destination Location and the used point on the routing graph.
     */
    double snappedDistance;

    public LocationDescription(Coordinate location, String name, double snappedDistance) {
        this.location = location;
        this.name = name;
        this.snappedDistance = snappedDistance;
    }

    public Coordinate getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public double getSnappedDistance() {
        return snappedDistance;
    }

    @Override
    public String toString() {
        return "LocationDescription{" +
                "location=" + location +
                ", name='" + name + '\'' +
                ", snappedDistance=" + snappedDistance +
                '}';
    }
}
