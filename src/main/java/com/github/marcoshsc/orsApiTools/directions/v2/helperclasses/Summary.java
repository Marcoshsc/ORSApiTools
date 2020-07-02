package com.github.marcoshsc.orsApiTools.directions.v2.helperclasses;

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

    @JsonCreator
    public Summary(@JsonProperty(value = "distance")
                           Double distance,
                   @JsonProperty(value = "duration")
                           Double duration,
                   @JsonProperty("ascent")
                           Double ascent,
                   @JsonProperty("descent")
                           Double descent) {
        this.distance = distance == null ? 0 : distance;
        this.duration = duration == null ? 0 : duration;
        this.ascent = ascent;
        this.descent = descent;
    }

}
