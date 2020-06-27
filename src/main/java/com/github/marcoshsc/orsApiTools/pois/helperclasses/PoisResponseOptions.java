package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.json.deserializers.GeometryDeserializer;
import com.github.marcoshsc.orsApiTools.json.deserializers.PoisQueryBoundingBoxDeserializer;
import com.github.marcoshsc.orsApiTools.pois.enums.FiltersEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.PoisRequestEnum;
import lombok.Getter;
import lombok.ToString;
import org.wololo.geojson.Geometry;

import java.util.List;
import java.util.Map;

/**
 * Represent the response options, which are the request values passed to make the response. Buffer will be 0 if not
 * encountered, and just the request field is guaranteed to be not null.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoisResponseOptions {

    /**
     * Type of the request passed.
     */
    private final PoisRequestEnum request;

    /**
     * Filters used in the request, if available
     */
    private final Map<FiltersEnum, List<String>> filters;

    /**
     * Bounding box of results, used in the request, if available.
     */
    private final BoundingBox boundingBox;

    /**
     * Coordinate used in the request
     */
    private final Geometry geoJSON;

    /**
     * Buffer size used in the request.
     */
    private final int buffer;

    public PoisResponseOptions(@JsonProperty("request")
                                       PoisRequestEnum request,
                               @JsonProperty("filters")
                                       Map<FiltersEnum, List<String>> filters,
                               @JsonProperty("boundingBox")
                               @JsonDeserialize(using = PoisQueryBoundingBoxDeserializer.class)
                                       BoundingBox boundingBox,
                               @JsonProperty("geojson")
                               @JsonDeserialize(using = GeometryDeserializer.class)
                                       Geometry geoJSON,
                               @JsonProperty("buffer")
                                       int buffer) {
        this.request = request;
        this.filters = filters;
        this.boundingBox = boundingBox;
        this.geoJSON = geoJSON;
        this.buffer = buffer;
    }

}
