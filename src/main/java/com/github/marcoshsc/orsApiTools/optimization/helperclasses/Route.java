package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * Represents a route object. A route object have a set of points that must be visited in order, and other metrics.
 *
 * @author Marcos Henrique
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {

    /**
     * Identifier of the vehicle that will do the route.
     */
    private final int vehicleId;

    /**
     * List of steps to be followed.
     */
    private final List<Step> steps;

    /**
     * Total cost of the route. Cost = duration
     */
    private final int cost;

    /**
     * Total time spent on the route.
     */
    private final int service;

    /**
     * Total duration of the route.
     */
    private final int duration;

    /**
     * Total time waited in the route.
     */
    private final int waitingTime;

    /**
     * List of quantities to be picked up in the route.
     */
    private final List<Integer> pickup;

    /**
     * List of quantities to be delivered in the route.
     */
    private final List<Integer> delivery;

    /**
     * Encoded polyline geometry. It is included just if "g" parameter is set.
     */
    private final String geometry;

    /**
     * Total distance of the route. It is included just if "g" parameter is set.
     */
    private final Double distance;

    @JsonCreator
    public Route(@JsonProperty(value = "vehicle", required = true) int vehicleId,
                 @JsonProperty(value = "steps", required = true) List<Step> steps,
                 @JsonProperty(value = "cost", required = true) int cost,
                 @JsonProperty(value = "service", required = true) int service,
                 @JsonProperty(value = "duration", required = true) int duration,
                 @JsonProperty(value = "waiting_time", required = true) int waitingTime,
                 @JsonProperty(value = "pickup", required = true) List<Integer> pickup,
                 @JsonProperty(value = "delivery", required = true) List<Integer> delivery,
                 @JsonProperty("geometry") String geometry,
                 @JsonProperty("distance") Double distance) {
        this.vehicleId = vehicleId;
        this.steps = steps;
        this.cost = cost;
        this.service = service;
        this.duration = duration;
        this.waitingTime = waitingTime;
        this.pickup = pickup;
        this.delivery = delivery;
        this.geometry = geometry;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "vehicleId=" + vehicleId +
                ", steps=" + steps +
                ", cost=" + cost +
                ", service=" + service +
                ", duration=" + duration +
                ", waitingTime=" + waitingTime +
                ", pickup=" + pickup +
                ", delivery=" + delivery +
                ", geometry='" + geometry + '\'' +
                ", distance=" + distance +
                "}\n";
    }

}
