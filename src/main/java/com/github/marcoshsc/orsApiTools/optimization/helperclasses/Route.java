package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import java.util.List;

/**
 * Represents a route object. A route object have a set of points that must be visited in order, and other metrics.
 *
 * @author Marcos Henrique
 */
public class Route {
    /**
     * Identifier of the vehicle that will do the route.
     */
    private int vehicleId;
    /**
     * List of steps to be followed.
     */
    private List<Step> steps;
    /**
     * Total cost of the route. Cost = duration
     */
    private int cost;
    /**
     * Total time spent on the route.
     */
    private int service;
    /**
     * Total duration of the route.
     */
    private int duration;
    /**
     * Total time waited in the route.
     */
    private int waitingTime;
    /**
     * List of quantities to be picked up in the route.
     */
    private List<Integer> pickup;
    /**
     * List of quantities to be delivered in the route.
     */
    private List<Integer> delivery;
    /**
     * Encoded polyline geometry. It is included just if "g" parameter is set.
     */
    private String geometry;
    /**
     * Total distance of the route. It is included just if "g" parameter is set.
     */
    private Double distance;

    public Route(int vehicleId, List<Step> steps, int cost, int service, int duration, int waitingTime,
                 List<Integer> pickup, List<Integer> delivery, String geometry, Double distance) {
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

    public int getVehicleId() {
        return vehicleId;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public int getCost() {
        return cost;
    }

    public int getService() {
        return service;
    }

    public int getDuration() {
        return duration;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public List<Integer> getPickup() {
        return pickup;
    }

    public List<Integer> getDelivery() {
        return delivery;
    }

    public String getGeometry() {
        return geometry;
    }

    public Double getDistance() {
        return distance;
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
