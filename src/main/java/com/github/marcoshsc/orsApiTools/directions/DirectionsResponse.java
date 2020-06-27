package com.github.marcoshsc.orsApiTools.directions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.RequestOptions;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.Segment;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.Summary;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo.DirectionsExtraInfo;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.json.deserializers.DirectionsGeometryDeserializer;
import com.github.marcoshsc.orsApiTools.json.deserializers.GeneralBoundingBoxDeserializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Abstraction of a response from the directions route of ORS API.
 * It might have the ascent, descent and average speed of the route. You must check it before using the fields.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectionsResponse {

    private final Summary summary;

    /**
     * Contains the geometry in the defined geometry format.
     */
    private final List<Coordinate> geometry;

    /**
     * List containing the segments and its correspoding steps which make up the route.
     */
    private final List<Segment> segments;

    private final List<Integer> wayPoints;

    /**
     * Requested extra information, divided into summary and values.
     */
    private final DirectionsExtraInfo extraInfo;

    /**
     * Contains the minimum bounding box of the route.
     */
    private final BoundingBox boundingBox;

    /**
     * Request data passed to make this response.
     */
    @Setter
    private RequestOptions options;

    @JsonCreator
    public DirectionsResponse(@JsonProperty(value = "summary", required = true)
                                      Summary summary,
                              @JsonProperty("geometry")
                              @JsonDeserialize(using = DirectionsGeometryDeserializer.class)
                                      List<Coordinate> geometry,
                              @JsonProperty("segments")
                                      List<Segment> segments,
                              @JsonProperty("way_points")
                                      List<Integer> wayPoints,
                              @JsonProperty("extras")
                                      DirectionsExtraInfo extraInfo,
                              @JsonProperty(value = "bbox", required = true)
                              @JsonDeserialize(using = GeneralBoundingBoxDeserializer.class)
                                      BoundingBox boundingBox) {
        this.summary = summary;
        this.geometry = geometry;
        this.segments = segments;
        this.wayPoints = wayPoints;
        this.extraInfo = extraInfo;
        this.boundingBox = boundingBox;
    }

}
