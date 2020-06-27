package com.github.marcoshsc.orsApiTools.geocode.helperclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.json.deserializers.GeometryDeserializer;
import com.github.marcoshsc.orsApiTools.json.deserializers.GeneralBoundingBoxDeserializer;
import lombok.Getter;
import lombok.ToString;
import org.wololo.geojson.Geometry;

import java.util.Map;

/**
 *
 * A location's representation, with it's coordinates in the map, bounding box and properties. Note that properties
 * is a map, and it's keys/values might differ from one Location to another.
 * NOTE: BoundingBox can be null.
 *
 * @author Marcos Henrique in 28-04-2020
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private final Geometry geometry;
    private final Map<String, Object> properties;
    private final BoundingBox boundingBox;

    public Location(@JsonProperty("geometry")
                    @JsonDeserialize(using = GeometryDeserializer.class)
                            Geometry geometry,
                    @JsonProperty("properties")
                        Map<String, Object> properties,
                    @JsonProperty("bbox")
                    @JsonDeserialize(using = GeneralBoundingBoxDeserializer.class)
                        BoundingBox boundingBox) {
        this.geometry = geometry;
        this.properties = properties;
        this.boundingBox = boundingBox;
    }
//
//    public Coordinate getGeometry() {
//        return geometry;
//    }
//
//    public Map<String, String> getProperties() {
//        return properties;
//    }
//
//    public BoundingBox getBoundingBox() {
//        return boundingBox;
//    }

}
