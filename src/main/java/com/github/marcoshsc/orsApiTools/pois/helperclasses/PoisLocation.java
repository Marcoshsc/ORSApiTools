package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.GeometryDeserializer;
import lombok.Getter;
import lombok.ToString;
import org.wololo.geojson.Geometry;

/**
 * Represents a location, that have a coordinate and it's properties. Both are guaranteed to not be null.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PoisLocation {

    /**
     * Location point
     */
    private final Geometry geometry;

    /**
     * Properties about the location
     */
    private final Properties properties;

    public PoisLocation(@JsonProperty(value = "geometry", required = true)
                        @JsonDeserialize(using = GeometryDeserializer.class)
                                Geometry geometry,
                        @JsonProperty(value = "properties", required = true)
                            Properties properties) {
        this.geometry = geometry;
        this.properties = properties;
    }

}
