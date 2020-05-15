package com.github.marcoshsc.orsApiTools.directions;

import com.github.marcoshsc.orsApiTools.directions.helperclasses.RequestOptions;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.Segment;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo.DirectionsExtraInfo;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Abstraction of a response from the directions route of ORS API.
 * It might have the ascent, descent and average speed of the route. You must check it before using the fields.
 *
 * @author Marcos Henrique
 */
public class DirectionsResponse {

    /**
     * JSON data of the response, without any processing.
     */
    JSONObject jsonData;
    /**
     * Total route distance in specified units.
     */
    double distance;
    /**
     * Total duration in seconds.
     */
    double duration;
    /**
     * Total ascent in meters.
     */
    Double ascent;
    /**
     * Total descent in meters.
     */
    Double descent;
    /**
     * Total average speed in km/h
     */
    Double avgSpeed;
    /**
     * Contains the geometry in the defined geometry format.
     */
    List<Coordinate> geometry;
    /**
     * List containing the segments and its correspoding steps which make up the route.
     */
    List<Segment> segments;
    /**
     * Requested extra information, divided into summary and values.
     */
    DirectionsExtraInfo extraInfo;
    /**
     * Contains the minimum bounding box of the route.
     */
    BoundingBox boundingBox;
    /**
     * Request data passed to make this response.
     */
    RequestOptions options;

    public DirectionsResponse(JSONObject jsonData, double distance, double duration, Double ascent, Double descent,
                              Double avgSpeed, List<Coordinate> geometry, List<Segment> segments,
                              DirectionsExtraInfo extraInfo, BoundingBox boundingBox, RequestOptions options) {
        this.jsonData = jsonData;
        this.distance = distance;
        this.duration = duration;
        this.ascent = ascent;
        this.descent = descent;
        this.avgSpeed = avgSpeed;
        this.geometry = geometry;
        this.segments = segments;
        this.extraInfo = extraInfo;
        this.boundingBox = boundingBox;
        this.options = options;
    }

    public JSONObject getJsonData() {
        return jsonData;
    }

    public double getDistance() {
        return distance;
    }

    public double getDuration() {
        return duration;
    }

    public List<Coordinate> getGeometry() {
        return geometry;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public DirectionsExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public Double getAscent() {
        return ascent;
    }

    public Double getDescent() {
        return descent;
    }

    public Double getAvgSpeed() {
        return avgSpeed;
    }

    public RequestOptions getOptions() {
        return options;
    }
}
