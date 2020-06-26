package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.CoordinateDeserializer;
import lombok.Getter;
import org.locationtech.jts.geom.Coordinate;

/**
 * Describe unassigned jobs.
 *
 * @author Marcos Henrique
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Unassigned {

    /**
     * Identifier of the job.
     */
    private final int id;

    /**
     * Location of the job, if provided.
     */
    private final Coordinate location;

    @JsonCreator
    public Unassigned(@JsonProperty(value = "id", required = true)
                              int id,
                      @JsonProperty(value = "location", required = true)
                      @JsonDeserialize(using = CoordinateDeserializer.class)
                              Coordinate location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Unassigned{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }

}
