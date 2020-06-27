package com.github.marcoshsc.orsApiTools.directions.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.CoordinateDeserializer;
import lombok.Getter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

/**
 * Components of a maneuver object, contained inside a step.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Maneuever {

    /**
     * The azimuth angle (in degrees) of the direction right before the maneuver.
     */
    private final double bearingBefore;

    /**
     * The azimuth angle (in degrees) of the direction right after the maneuver.
     */
    private final double bearingAfter;

    /**
     * The coordinate of the point where a maneuver takes place.
     */
    private final Coordinate location;

    @JsonCreator
    public Maneuever(@JsonProperty(value = "bearing_before", required = true)
                             double bearingBefore,
                     @JsonProperty(value = "bearing_after", required = true)
                             double bearingAfter,
                     @JsonProperty("location")
                     @JsonDeserialize(using = CoordinateDeserializer.class)
                             Coordinate location) {
        this.bearingBefore = bearingBefore;
        this.bearingAfter = bearingAfter;
        this.location = location;
    }

}
