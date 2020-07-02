package com.github.marcoshsc.orsApiTools.directions.v2.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.directions.helperclasses.Step;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Segment {

    /**
     * Contains the distance of the segment in specified units.
     */
    private final double distance;

    /**
     * Contains the duration of the segment in seconds.
     */
    private final double duration;

    /**
     * Contains ascent of this segment in meters for elevation=true.
     */
    private final Double ascent;

    /**
     * Contains descent of this segment in meters for elevation=true.
     */
    private final Double descent;

    /**
     * Contains the average speed of this segment in km/h.
     */
    private final Double avgSpeed;

    /**
     * Contains the deviation compared to a straight line that would have the factor 1.
     * Double the Distance would be a 2.
     */
    private final Double detourFactor;

    /**
     * Contains the proportion of the route in percent.
     */
    private final Double percentage;

    /**
     * List containing the specific steps the segment consists of.
     */
    private final List<Step> steps;

    @JsonCreator
    public Segment(@JsonProperty(value = "distance")
                           Double distance,
                   @JsonProperty(value = "duration")
                           Double duration,
                   @JsonProperty("ascent")
                           Double ascent,
                   @JsonProperty("descent")
                           Double descent,
                   @JsonProperty("avgspeed")
                           Double avgSpeed,
                   @JsonProperty("detourfactor")
                           Double detourFactor,
                   @JsonProperty("percentage")
                           Double percentage,
                   @JsonProperty("steps")
                           List<Step> steps) {
        this.distance = distance == null ? 0 : distance;
        this.duration = duration == null ? 0 : duration;
        this.ascent = ascent;
        this.descent = descent;
        this.avgSpeed = avgSpeed;
        this.detourFactor = detourFactor;
        this.percentage = percentage;
        this.steps = steps;
    }

}
