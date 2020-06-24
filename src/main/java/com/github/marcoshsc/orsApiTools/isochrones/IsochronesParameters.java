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

    @JsonIgnore
    private Profile profile;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("locations")
    private Locations locations;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("range")
    private Range range;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("attributes")
    private Attributes attributes;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    private Id id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("intersections")
    private Intersections intersections;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("interval")
    private Interval interval;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("location_type")
    private LocationType locationType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("range_type")
    private RangeType rangeType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("smoothing")
    private Smoothing smoothing;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("area_units")
    private AreaUnits areaUnits;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("units")
    private Units units;



}
