package com.github.marcoshsc.orsApiTools.directions.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {

    /**
     * Total route distance in specified units.
     */
    private final double distance;

    /**
     * Total duration in seconds.
     */
    private final double duration;

    /**
     * Total ascent in meters.
     */
    private final Double ascent;

    /**
     * Total descent in meters.
     */
    private final Double descent;

    /**
     * Total average speed in km/h
     */
    private final Double avgSpeed;

    @JsonCreator
    public Summary(@JsonProperty(value = "distance", required = true)
                           double distance,
                   @JsonProperty(value = "duration", required = true)
                           double duration,
                   @JsonProperty("ascent")
                           Double ascent,
                   @JsonProperty("descent")
                           Double descent,
                   @JsonProperty("avgspeed")
                           Double avgSpeed) {
        this.distance = distance;
        this.duration = duration;
        this.ascent = ascent;
        this.descent = descent;
        this.avgSpeed = avgSpeed;
    }
}
