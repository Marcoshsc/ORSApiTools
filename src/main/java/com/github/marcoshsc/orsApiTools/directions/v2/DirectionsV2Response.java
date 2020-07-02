package com.github.marcoshsc.orsApiTools.directions.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.directions.v2.helperclasses.BoundingBoxWithElevation;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.RequestOptions;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo.DirectionsExtraInfo;
import com.github.marcoshsc.orsApiTools.directions.v2.helperclasses.Segment;
import com.github.marcoshsc.orsApiTools.directions.v2.helperclasses.Summary;
import com.github.marcoshsc.orsApiTools.json.deserializers.BoundingBoxDeserializerWithElevation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectionsV2Response {

    private final Summary summary;

    /**
     * Contains the geometry in the defined geometry format.
     */
    @Setter
    @JsonIgnore
    private List<Coordinate> geometry;

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
    private final BoundingBoxWithElevation boundingBox;

    /**
     * Request data passed to make this response.
     */
    @Setter
    private RequestOptions options;

    public DirectionsV2Response(@JsonProperty(value = "summary", required = true)
                                        Summary summary,
                                @JsonProperty("segments")
                                        List<Segment> segments,
                                @JsonProperty("way_points")
                                        List<Integer> wayPoints,
                                @JsonProperty("extras")
                                        DirectionsExtraInfo extraInfo,
                                @JsonProperty(value = "bbox", required = true)
                                @JsonDeserialize(using = BoundingBoxDeserializerWithElevation.class)
                                        BoundingBoxWithElevation boundingBox) {
        this.summary = summary;
        this.segments = segments;
        this.wayPoints = wayPoints;
        this.extraInfo = extraInfo;
        this.boundingBox = boundingBox;
    }
}
