package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.github.marcoshsc.orsApiTools.optimization.enums.StepTypeEnum;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describes a step object. A step object describes one of the types described in {@link StepTypeEnum}, with detailed
 * information.
 *
 * @author Marcos Henrique
 */
public class Step {
    /**
     * Type of the step.
     */
    private StepTypeEnum type;
    /**
     * 	Estimated time of arrival at this step
     */
    private int arrival;
    /**
     * 	Cumulated travel time upon arrival at this step
     */
    private int duration;
    /**
     * Location of the step.
     */
    private Coordinate location;
    /**
     * Id of the job performed at this step (not provided for start and end)
     */
    private Integer job;
    /**
     * vehicle load after step completion (with capacity constraints)
     */
    private List<Integer> load;
    /**
     * service time at this step (not provided for start and end)
     */
    private Integer service;
    /**
     * waiting time upon arrival at this step (not provided for start and end)
     */
    private Integer waitingTime;
    /**
     * traveled distance upon arrival at this step. (provided only if "g" parameter is set)
     */
    private Double distance;

    public Step(StepTypeEnum type, int arrival, int duration, Coordinate location, Integer job, List<Integer> load,
                Integer service, Integer waitingTime, Double distance) {
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

    public StepTypeEnum getType() {
        return type;
    }

    public int getArrival() {
        return arrival;
    }

    public int getDuration() {
        return duration;
    }

    public Coordinate getLocation() {
        return location;
    }

    public Integer getJob() {
        return job;
    }

    public List<Integer> getLoad() {
        return load;
    }

    public Integer getService() {
        return service;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public Double getDistance() {
        return distance;
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
