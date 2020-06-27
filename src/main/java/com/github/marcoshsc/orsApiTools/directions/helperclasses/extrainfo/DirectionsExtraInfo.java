package com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * Describe all possible extra_info fields in a directions request. Note that fields can be null, and it must be verified
 * before usage.
 * https://github.com/GIScience/openrouteservice-docs for more information
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectionsExtraInfo {

    /**
     * Negative values indicate decline, positive incline.
     */
    private final ExtraInfoField steepness;

    /**
     * The Suitability values for the selected profile range from 10 for best suitability to 1 for worst suitability.
     */
    private final ExtraInfoField suitability;

    /**
     * Surface type in the route.
     */
    private final ExtraInfoField surface;

    /**
     * The exponential assignment of the values is used for bit fields. One route section may belong to different
     * categories. https://github.com/GIScience/openrouteservice-docs for more information.
     */
    private final ExtraInfoField waycategory;

    /**
     * Type of the ways in the route.
     */
    private final ExtraInfoField waytype;

    /**
     * Tollway specific information for the selected mode of transport.
     */
    private final ExtraInfoField tollways;

    /**
     * This extra provides information about a trails difficulty for hiking as well as for mountain-biking.
     */
    private final ExtraInfoField trailDifficulty;

    /**
     * Provides information about possible restrictions on roads.
     */
    private final ExtraInfoField roadAccessRestrictions;

    /**
     * This value is in km/h and equals the average speed for this way segment after grading and applying factors.
     */
    private final ExtraInfoField avgSpeed;

    private final ExtraInfoField countryInfo;

    @JsonCreator
    public DirectionsExtraInfo(@JsonProperty("steepness") ExtraInfoField steepness,
                               @JsonProperty("suitability") ExtraInfoField suitability,
                               @JsonProperty("surface") ExtraInfoField surface,
                               @JsonProperty("waycategory") ExtraInfoField waycategory,
                               @JsonProperty("waytypes") ExtraInfoField waytype,
                               @JsonProperty("tollways") ExtraInfoField tollways,
                               @JsonProperty("traildifficulty") ExtraInfoField trailDifficulty,
                               @JsonProperty("roadaccessrestrictions") ExtraInfoField roadAccessRestrictions,
                               @JsonProperty("avgspeed") ExtraInfoField avgSpeed,
                               @JsonProperty("countryinfo") ExtraInfoField countryInfo) {
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

}
