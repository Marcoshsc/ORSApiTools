package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import org.locationtech.jts.geom.Coordinate;

/**
 * Describe unassigned jobs.
 *
 * @author Marcos Henrique
 */
public class Unassigned {
    /**
     * Identifier of the job.
     */
    private int id;
    /**
     * Location of the job, if provided.
     */
    private Coordinate location;

    public Unassigned(int id, Coordinate location) {
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public Coordinate getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Unassigned{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }
}
