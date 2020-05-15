package com.github.marcoshsc.orsApiTools.directions.helperclasses;

import java.util.List;

/**
 * Abstraction of segment object, shows the total distance and duration of it, it's steps, start and end waypoints. There
 * might be ascent, descent, average speed, detour factor and percentage values, but they can be null.
 *
 * @author Marcos Henrique
 */
public class Segment {

    /**
     * Contains the distance of the segment in specified units.
     */
    double distance;
    /**
     * Contains the duration of the segment in seconds.
     */
    double duration;
    /**
     * Contains ascent of this segment in meters for elevation=true.
     */
    Double ascent;
    /**
     * Contains descent of this segment in meters for elevation=true.
     */
    Double descent;
    /**
     * Contains the average speed of this segment in km/h.
     */
    Double avgSpeed;
    /**
     * Contains the deviation compared to a straight line that would have the factor 1.
     * Double the Distance would be a 2.
     */
    Double detourFactor;
    /**
     * Contains the proportion of the route in percent.
     */
    Double percentage;
    /**
     * List containing the specific steps the segment consists of.
     */
    List<Step> steps;
    /**
     * Index of the start way point in the geometry array.
     */
    int startWayPoint;
    /**
     * Index of the end way point in the geometry array.
     */
    int endWayPoint;

    public Segment(double distance, double duration, Double ascent, Double descent, Double avgSpeed, Double detourFactor,
                   Double percentage, List<Step> steps, int startWayPoint, int endWayPoint) {
        this.distance = distance;
        this.duration = duration;
        this.ascent = ascent;
        this.descent = descent;
        this.avgSpeed = avgSpeed;
        this.detourFactor = detourFactor;
        this.percentage = percentage;
        this.steps = steps;
        this.startWayPoint = startWayPoint;
        this.endWayPoint = endWayPoint;
    }

    public double getDistance() {
        return distance;
    }

    public double getDuration() {
        return duration;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public int getStartWayPoint() {
        return startWayPoint;
    }

    public int getEndWayPoint() {
        return endWayPoint;
    }

    public Double getAscent() {
        return ascent;
    }

    public Double getDescent() {
        return descent;
    }

    public Double getAvgSpeed() {
        return avgSpeed;
    }

    public Double getDetourFactor() {
        return detourFactor;
    }

    public Double getPercentage() {
        return percentage;
    }
}
