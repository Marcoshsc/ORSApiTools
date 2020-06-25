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

    @JsonIgnore
    private Profile profile;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("locations")
    private Locations locations;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("destinations")
    private Destinations destinations;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id")
    private Id id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("metrics")
    private Metrics metrics;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("resolve_locations")
    private ResolveLocations resolveLocations;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("sources")
    private Sources sources;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("units")
    private Units units;

}
