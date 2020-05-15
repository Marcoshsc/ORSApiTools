package com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo;

/**
 * Describe all possible extra_info fields in a directions request. Note that fields can be null, and it must be verified
 * before usage.
 * https://github.com/GIScience/openrouteservice-docs for more information
 *
 * @author Marcos Henrique
 */
public class DirectionsExtraInfo {

    /**
     * Negative values indicate decline, positive incline.
     */
    private ExtraInfoField steepness;
    /**
     * The Suitability values for the selected profile range from 10 for best suitability to 1 for worst suitability.
     */
    private ExtraInfoField suitability;
    /**
     * Surface type in the route.
     */
    private ExtraInfoField surface;
    /**
     * The exponential assignment of the values is used for bit fields. One route section may belong to different
     * categories. https://github.com/GIScience/openrouteservice-docs for more information.
     */
    private ExtraInfoField waycategory;
    /**
     * Type of the ways in the route.
     */
    private ExtraInfoField waytype;
    /**
     * Tollway specific information for the selected mode of transport.
     */
    private ExtraInfoField tollways;
    /**
     * This extra provides information about a trails difficulty for hiking as well as for mountain-biking.
     */
    private ExtraInfoField trailDifficulty;
    /**
     * Provides information about possible restrictions on roads.
     */
    private ExtraInfoField roadAccessRestrictions;
    /**
     * This value is in km/h and equals the average speed for this way segment after grading and applying factors.
     */
    private ExtraInfoField avgSpeed;
    private ExtraInfoField countryInfo;

    public DirectionsExtraInfo(ExtraInfoField steepness, ExtraInfoField suitability, ExtraInfoField surface,
                               ExtraInfoField waycategory, ExtraInfoField waytype, ExtraInfoField tollways,
                               ExtraInfoField trailDifficulty, ExtraInfoField roadAccessRestrictions,
                               ExtraInfoField avgSpeed, ExtraInfoField countryInfo) {
        this.steepness = steepness;
        this.suitability = suitability;
        this.surface = surface;
        this.waycategory = waycategory;
        this.waytype = waytype;
        this.tollways = tollways;
        this.trailDifficulty = trailDifficulty;
        this.roadAccessRestrictions = roadAccessRestrictions;
        this.avgSpeed = avgSpeed;
        this.countryInfo = countryInfo;
    }

    public ExtraInfoField getSteepness() {
        return steepness;
    }

    public ExtraInfoField getSuitability() {
        return suitability;
    }

    public ExtraInfoField getSurface() {
        return surface;
    }

    public ExtraInfoField getWaycategory() {
        return waycategory;
    }

    public ExtraInfoField getWaytype() {
        return waytype;
    }

    public ExtraInfoField getTollways() {
        return tollways;
    }

    public ExtraInfoField getTrailDifficulty() {
        return trailDifficulty;
    }

    public ExtraInfoField getRoadAccessRestrictions() {
        return roadAccessRestrictions;
    }

    public ExtraInfoField getAvgSpeed() {
        return avgSpeed;
    }

    public ExtraInfoField getCountryInfo() {
        return countryInfo;
    }
}
