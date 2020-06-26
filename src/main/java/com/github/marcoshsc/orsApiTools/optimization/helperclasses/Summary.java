package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * Object summarizing solution indicators.
 *
 * @author Marcos Henrique
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {

    /**
     * Total cost for all routes
     */
    private final int cost;
    /**
     * Number of jobs that could not be served
     */
    private final int unassigned;
    /**
     * Total service time for all routes
     */
    private final int service;
    /**
     * Total travel time for all routes
     */
    private final int duration;
    /**
     * Total waiting time for all routes
     */
    private final int waitingTime;
    /**
     * Time spent computing the response
     */
    private final ComputingTime computingTime;
    /**
     * Total pickup for all routes
     */
    private final List<Integer> pickup;
    /**
     * Total delivery for all routes
     */
    private final List<Integer> delivery;
    /**
     * Total distance for all routes. Only provided if "g" parameter is set.
     */
    private final Double distance;

    @JsonCreator
    public Summary(@JsonProperty(value = "cost", required = true) int cost,
                   @JsonProperty(value = "unassigned", required = true) int unassigned,
                   @JsonProperty(value = "service", required = true) int service,
                   @JsonProperty(value = "duration", required = true) int duration,
                   @JsonProperty(value = "waiting_time", required = true) int waitingTime,
                   @JsonProperty(value = "computing_times", required = true) ComputingTime computingTime,
                   @JsonProperty(value = "pickup", required = true) List<Integer> pickup,
                   @JsonProperty(value = "delivery", required = true) List<Integer> delivery,
                   @JsonProperty(value = "distance") Double distance) {
        this.cost = cost;
        this.unassigned = unassigned;
        this.service = service;
        this.duration = duration;
        this.waitingTime = waitingTime;
        this.computingTime = computingTime;
        this.pickup = pickup;
        this.delivery = delivery;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "cost=" + cost +
                ", unassigned=" + unassigned +
                ", service=" + service +
                ", duration=" + duration +
                ", waitingTime=" + waitingTime +
                ", computingTime=" + computingTime +
                ", pickup=" + pickup +
                ", delivery=" + delivery +
                ", distance=" + distance +
                "}\n";
    }

}
