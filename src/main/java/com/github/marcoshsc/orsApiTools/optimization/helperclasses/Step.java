package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.CoordinateDeserializer;
import com.github.marcoshsc.orsApiTools.optimization.enums.StepTypeEnum;
import lombok.Getter;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describes a step object. A step object describes one of the types described in {@link StepTypeEnum}, with detailed
 * information.
 *
 * @author Marcos Henrique
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {

    /**
     * Type of the step.
     */
    private final StepTypeEnum type;

    /**
     * 	Estimated time of arrival at this step
     */
    private final int arrival;

    /**
     * 	Cumulated travel time upon arrival at this step
     */
    private final int duration;

    /**
     * Location of the step.
     */
    private final Coordinate location;

    /**
     * Id of the job performed at this step (not provided for start and end)
     */
    private final Integer job;

    /**
     * vehicle load after step completion (with capacity constraints)
     */
    private final List<Integer> load;

    /**
     * service time at this step (not provided for start and end)
     */
    private final Integer service;

    /**
     * waiting time upon arrival at this step (not provided for start and end)
     */
    private final Integer waitingTime;

    /**
     * traveled distance upon arrival at this step. (provided only if "g" parameter is set)
     */
    private final Double distance;

    public Step(@JsonProperty(value = "type", required = true)
                        StepTypeEnum type,
                @JsonProperty(value = "arrival", required = true)
                        int arrival,
                @JsonProperty(value = "duration", required = true)
                        int duration,
                @JsonProperty("location")
                @JsonDeserialize(using = CoordinateDeserializer.class)
                        Coordinate location,
                @JsonProperty("job")
                        Integer job,
                @JsonProperty("load")
                        List<Integer> load,
                @JsonProperty(value = "service")
                        Integer service,
                @JsonProperty("waiting_time")
                        Integer waitingTime,
                @JsonProperty("distance")
                        Double distance) {
        this.type = type;
        this.arrival = arrival;
        this.duration = duration;
        this.location = location;
        this.job = job;
        this.load = load;
        this.service = service;
        this.waitingTime = waitingTime;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Step{" +
                "type=" + type +
                ", arrival=" + arrival +
                ", duration=" + duration +
                ", location=" + location +
                ", job=" + job +
                ", load=" + load +
                ", service=" + service +
                ", waitingTime=" + waitingTime +
                ", distance=" + distance +
                "}\n";
    }

}
