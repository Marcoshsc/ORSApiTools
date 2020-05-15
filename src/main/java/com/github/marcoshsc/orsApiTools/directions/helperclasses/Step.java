package com.github.marcoshsc.orsApiTools.directions.helperclasses;

/**
 * Describes a step object. It will have a total distance, duration, instruction and start/end waypoints.
 * It might have name and maneuver, so they must be checked before use.
 *
 * @author Marcos Henrique
 */
public class Step {

    /**
     * The distance for the step in meters.
     */
    double distance;
    /**
     * The duration for the step in seconds.
     */
    double duration;
    /**
     * The instruction action for symbolisation purposes.
     * https://github.com/GIScience/openrouteservice-docs#instruction-types for more information
     */
    int type;
    /**
     * The routing instruction text for the step.
     */
    String instruction;
    /**
     * The name of the next street.
     */
    String name;
    /**
     * Object with information about the maneuver to be done.
     */
    Maneuever maneuever;
    /**
     * Index of the start way point in the geometry array.
     */
    int startWayPoint;
    /**
     * Index of the end way point in the geometry array.
     */
    int endWayPoint;

    public Step(double distance, double duration, int type, String instruction, String name, Maneuever maneuever,
                int startWayPoint, int endWayPoint) {
        this.distance = distance;
        this.duration = duration;
        this.type = type;
        this.instruction = instruction;
        this.name = name;
        this.maneuever = maneuever;
        this.startWayPoint = startWayPoint;
        this.endWayPoint = endWayPoint;
    }

    public double getDistance() {
        return distance;
    }

    public double getDuration() {
        return duration;
    }

    public int getType() {
        return type;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getName() {
        return name;
    }

    public int getStartWayPoint() {
        return startWayPoint;
    }

    public int getEndWayPoint() {
        return endWayPoint;
    }

    public Maneuever getManeuever() {
        return maneuever;
    }
}
