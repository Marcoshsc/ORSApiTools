package com.github.marcoshsc.orsApiTools.directions.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * Describes a step object. It will have a total distance, duration, instruction and start/end waypoints.
 * It might have name and maneuver, so they must be checked before use.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {

    /**
     * The distance for the step in meters.
     */
    private final double distance;

    /**
     * The duration for the step in seconds.
     */
    private final double duration;

    /**
     * The instruction action for symbolisation purposes.
     * https://github.com/GIScience/openrouteservice-docs#instruction-types for more information
     */
    private final int type;

    /**
     * The routing instruction text for the step.
     */
    private final String instruction;

    /**
     * The name of the next street.
     */
    private final String name;

    /**
     * Object with information about the maneuver to be done.
     */
    private final Maneuever maneuever;

    private final StepWayPoints wayPoints;

    @JsonCreator
    public Step(@JsonProperty(value = "distance", required = true)
                        double distance,
                @JsonProperty(value = "duration", required = true)
                        double duration,
                @JsonProperty(value = "type", required = true)
                        int type,
                @JsonProperty("instruction")
                        String instruction,
                @JsonProperty("name")
                        String name,
                @JsonProperty("maneuver")
                        Maneuever maneuever,
                @JsonProperty("way_points")
                        StepWayPoints wayPoints) {
        this.distance = distance;
        this.duration = duration;
        this.type = type;
        this.instruction = instruction;
        this.name = name;
        this.maneuever = maneuever;
        this.wayPoints = wayPoints;
    }

}
