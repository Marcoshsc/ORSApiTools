package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import java.util.List;

/**
 * Object summarizing solution indicators.
 *
 * @author Marcos Henrique
 */
public class Summary {
    /**
     * Total cost for all routes
     */
    private int cost;
    /**
     * Number of jobs that could not be served
     */
    private int unassigned;
    /**
     * Total service time for all routes
     */
    private int service;
    /**
     * Total travel time for all routes
     */
    private int duration;
    /**
     * Total waiting time for all routes
     */
    private int waitingTime;
    /**
     * Time spent computing the response
     */
    private ComputingTime computingTime;
    /**
     * Total pickup for all routes
     */
    private List<Integer> pickup;
    /**
     * Total delivery for all routes
     */
    private List<Integer> delivery;
    /**
     * Total distance for all routes. Only provided if "g" parameter is set.
     */
    private Double distance;

    public Summary(int cost, int unassigned, int service, int duration, int waitingTime, ComputingTime computingTime,
                   List<Integer> pickup, List<Integer> delivery, Double distance) {
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

    public int getCost() {
        return cost;
    }

    public int getUnassigned() {
        return unassigned;
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

    public ComputingTime getComputingTime() {
        return computingTime;
    }

    public List<Integer> getPickup() {
        return pickup;
    }

    public List<Integer> getDelivery() {
        return delivery;
    }

    public Double getDistance() {
        return distance;
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
