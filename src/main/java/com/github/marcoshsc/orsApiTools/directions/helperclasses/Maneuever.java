package com.github.marcoshsc.orsApiTools.directions.helperclasses;

import org.locationtech.jts.geom.Coordinate;

/**
 * Components of a maneuver object, contained inside a step.
 *
 * @author Marcos Henrique
 */
public class Maneuever {
    /**
     * The azimuth angle (in degrees) of the direction right before the maneuver.
     */
    double bearingBefore;
    /**
     * The azimuth angle (in degrees) of the direction right after the maneuver.
     */
    double bearingAfter;
    /**
     * The coordinate of the point where a maneuver takes place.
     */
    Coordinate location;

    public Maneuever(double bearingBefore, double bearingAfter, Coordinate location) {
        this.bearingBefore = bearingBefore;
        this.bearingAfter = bearingAfter;
        this.location = location;
    }

    public double getBearingBefore() {
        return bearingBefore;
    }

    public double getBearingAfter() {
        return bearingAfter;
    }

    public Coordinate getLocation() {
        return location;
    }
}
