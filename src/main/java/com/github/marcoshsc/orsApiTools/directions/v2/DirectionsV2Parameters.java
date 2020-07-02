package com.github.marcoshsc.orsApiTools.directions.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.directions.v2.parameters.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectionsV2Parameters {

    @JsonIgnore
    private Profile profile;

    @JsonProperty("attributes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Attributes attributes;

    @JsonProperty("coordinates")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Coordinates coordinates;

    @JsonProperty("elevation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Elevation elevation;

    @JsonProperty("extra_info")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ExtraInfo extraInfo;

    @JsonProperty("geometry")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Geometry geometry;

    @JsonProperty("geometry_simplify")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GeometrySimplify geometrySimplify;

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Id id;

    @JsonProperty("instructions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Instructions instructions;

    @JsonProperty("instructions_format")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private InstructionsFormat instructionsFormat;

    @JsonProperty("language")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Language language;

    @JsonProperty("maneuvers")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Maneuvers maneuvers;

    @JsonProperty("preference")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Preference preference;

    @JsonProperty("radiuses")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Radiuses radiuses;

    @JsonProperty("roundabout_exits")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RoundaboutExits roundaboutExits;

    @JsonProperty("skip_segments")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SkipSegments skipSegments;

    @JsonProperty("suppress_warnings")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SupressWarnings supressWarnings;

    @JsonProperty("units")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Units units;

}
