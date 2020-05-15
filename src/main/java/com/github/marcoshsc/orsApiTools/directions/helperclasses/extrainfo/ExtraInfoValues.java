package com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo;

/**
 * Describe waypoints and values for the category. Note that wayPoints are just indexes of the geometry object.
 *
 * @author Marcos Henrique
 */
public class ExtraInfoValues {

    /**
     * Index of the starting geometry for this section.
     */
    private int startWayPoint;
    /**
     * Index of the end geometry for this section.
     */
    private int endWayPoint;
    /**
     * Value assigned to this section.
     */
    private double value;

    public ExtraInfoValues(int startWayPoint, int endWayPoint, double value) {
        this.startWayPoint = startWayPoint;
        this.endWayPoint = endWayPoint;
        this.value = value;
    }

    public int getStartWayPoint() {
        return startWayPoint;
    }

    public int getEndWayPoint() {
        return endWayPoint;
    }

    public double getValue() {
        return value;
    }
}
