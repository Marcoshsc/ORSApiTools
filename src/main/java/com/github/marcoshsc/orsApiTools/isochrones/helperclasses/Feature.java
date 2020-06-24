package com.github.marcoshsc.orsApiTools.isochrones.helperclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.wololo.geojson.Polygon;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

    private final Polygon geometry;

    private final Properties properties;

    public Feature(@JsonProperty(value = "geometry", required = true) Polygon geometry,
                   @JsonProperty(value = "properties", required = true) Properties properties) {
        this.geometry = geometry;
        this.properties = properties;
    }
}
