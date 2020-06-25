package com.github.marcoshsc.orsApiTools.matrix.v2.helperclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.CoordinateDeserializer;
import lombok.Getter;
import org.locationtech.jts.geom.Coordinate;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private final Coordinate location;
    private final String name;
    private final Double snappedDistance;

    public Location(@JsonProperty(value = "location", required = true)
                    @JsonDeserialize(using = CoordinateDeserializer.class)
                            Coordinate location,
                    @JsonProperty("name")
                            String name,
                    @JsonProperty("snapped_distance")
                            Double snappedDistance) {
        this.location = location;
        this.name = name;
        this.snappedDistance = snappedDistance == null ? 0 : snappedDistance;
    }
}
