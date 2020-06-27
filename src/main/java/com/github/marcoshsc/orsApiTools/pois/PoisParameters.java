package com.github.marcoshsc.orsApiTools.pois;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.pois.parameters.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Group of the parameters to the POIS endpoint on the ORS API.
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
public class PoisParameters {

    /**
     * Type of the request.
     */
    @JsonProperty("request")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PoisParameterRequest request;

    /**
     * The geometry object which is a geojson or a bounding box object, optionally buffered.
     */
    @JsonProperty("geometry")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PoisGeometry geometry;

    /**
     * Filters in terms of osm_tags which should be applied to the query.
     */
    @JsonProperty("filters")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Filters filters;

    /**
     * The limit of objects to be returned in the response.
     */
    @JsonProperty("limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Limit limit;

    /**
     * Either you can sort by category or the distance to the geometry object provided in the request.
     * (Currently only distance sorting is allowed).
     */
    @JsonProperty("sortby")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SortBy sortBy;

}
