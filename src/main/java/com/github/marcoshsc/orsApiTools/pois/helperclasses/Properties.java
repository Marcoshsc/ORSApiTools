package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import java.util.List;

/**
 * Represent a location's properties, which are the osmId, osmType, distance from the request point, list of categories
 * that the location have, and OSM tags.
 * All the values are guaranteed to not be null.
 *
 * @author Marcos Henrique
 */
public class Properties {

    /**
     * OSM ID of the location
     */
    private String osmId;
    /**
     * Location OSM type.
     */
    private int osmType;
    /**
     * Distance from the given point in the request.
     */
    private double distance;
    /**
     * List of location categories registered in OSM.
     */
    private List<PoisCategory> categories;
    /**
     * Location tags.
     */
    private OSMTags tags;

    public Properties(String osmId, int osmType, double distance, List<PoisCategory> categories, OSMTags tags) {
        this.osmId = osmId;
        this.osmType = osmType;
        this.distance = distance;
        this.categories = categories;
        this.tags = tags;
    }

    public String getOsmId() {
        return osmId;
    }

    public int getOsmType() {
        return osmType;
    }

    public double getDistance() {
        return distance;
    }

    public List<PoisCategory> getCategories() {
        return categories;
    }

    public OSMTags getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "osmId='" + osmId + '\'' +
                ", osmType=" + osmType +
                ", distance=" + distance +
                ", categories=" + categories +
                ", tags=" + tags +
                "}\n";
    }
}
