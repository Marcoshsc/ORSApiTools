package com.github.marcoshsc.orsApiTools.isochrones;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.isochrones.parameters.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IsochronesParameters {

    /**
     * Specifies the route profile.
     */
    @JsonIgnore
    private Profile profile;

    /**
     * The locations to use for the route as an array of longitude/latitude pairs
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("locations")
    private Locations locations;

    /**
     * Maximum range value of the analysis in seconds for time and metres for distance.Alternatively a comma separated
     * list of specific single range values if more than one location is set.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("range")
    private Range range;

    /**
     * List of isochrones attributes
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("attributes")
    private Attributes attributes;

    /**
     * Arbitrary identification string of the request reflected in the meta information.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    private Id id;

    /**
     * Specifies whether to return intersecting polygons.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("intersections")
    private Intersections intersections;

    /**
     * Interval of isochrones or equidistants for one range value. Value in seconds for time and meters for distance.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("interval")
    private Interval interval;

    /**
     * start treats the location(s) as starting point, destination as goal.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("location_type")
    private LocationType locationType;

    /**
     * Specifies the isochrones reachability type.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("range_type")
    private RangeType rangeType;

    /**
     * Applies a level of generalisation to the isochrone polygons generated as a smoothing_factor between 0 and 100.0.
     * Generalisation is produced by determining a maximum length of a connecting line between two points found on
     * the outside of a containing polygon. If the distance is larger than a threshold value, the line between the
     * two points is removed and a smaller connecting line between other points is used. Note that the minimum length
     * of this connecting line is ~1333m, and so when the smoothing_factor results in a distance smaller than this, the
     * minimum value is used. The threshold value is determined as (maximum_radius_of_isochrone / 100) * smoothing_factor.
     * Therefore, a value closer to 100 will result in a more generalised shape. The polygon generation algorithm is
     * based on Duckham and al. (2008) "Efficient generation of simple polygons for characterizing the shape of a
     * set of points in the plane."
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("smoothing")
    private Smoothing smoothing;

    /**
     * Specifies the area unit.
     * Default: m.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("area_units")
    private AreaUnits areaUnits;

    /**
     * Specifies the distance units only if range_type is set to distance.
     * Default: m.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("units")
    private Units units;



}
