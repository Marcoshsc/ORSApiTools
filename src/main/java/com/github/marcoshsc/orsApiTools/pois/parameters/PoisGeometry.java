package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.json.serializers.PoisBoundingBoxSerializer;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.GeoJSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * The geometry object which is a geojson or a bounding box object, optionally buffered.
 * Buffer value: it's not required but if you don't specify it will not return any results. Increasing the value of the
 * buffer will increase the number of returned results, if available.
 *
 * Bounding box OR geoJSON can be set as null if they are not being used.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@AllArgsConstructor
public class PoisGeometry {

    /**
     * Bounding box of geometry object.
     */
    @JsonProperty("bbox")
    @JsonSerialize(using = PoisBoundingBoxSerializer.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final BoundingBox boundingBox;

    /**
     * GeoJSON object representing either a Point, LineString or Polygon.
     */
    @JsonProperty("geojson")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final GeoJSON geoJSON;

    /**
     * Total buffer size. Greater buffer values mean more results returned. [1, 2000] interval.
     */
    @JsonProperty("buffer")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer buffer;

}
