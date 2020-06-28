package com.github.marcoshsc.orsApiTools.matrix.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.matrix.v2.parameters.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MatrixV2Parameters {

    /**
     * Specifies the route profile.
     */
    @JsonIgnore
    private Profile profile;

    /**
     * List of comma separated lists of longitude,latitude coordinates.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("locations")
    private Locations locations;

    /**
     * A list of indices that refers to the list of locations (starting with 0). {index_1},{index_2}[,{index_N} ...]
     * or all (default). [0,3] for the first and fourth locations
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("destinations")
    private Destinations destinations;

    /**
     * Arbitrary identification string of the request reflected in the meta information.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    private Id id;

    /**
     * Specifies a list of returned metrics.
     *
     * distance - Returns distance matrix for specified points in defined units.
     * duration - Returns duration matrix for specified points in seconds.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("metrics")
    private Metrics metrics;

    /**
     * Specifies whether given locations are resolved or not. If the parameter value set to true, every element
     * in destinations and sources will contain a name element that identifies the name of the closest street.
     * Default is false.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("resolve_locations")
    private ResolveLocations resolveLocations;

    /**
     * A list of indices that refers to the list of locations (starting with 0). {index_1},{index_2}[,{index_N} ...]
     * or all (default). example [0,3] for the first and fourth locations
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("sources")
    private Sources sources;

    /**
     * Specifies the distance unit.
     * Default: m.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("units")
    private Units units;

}
