package com.github.marcoshsc.orsApiTools.isochrones.helperclasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.marcoshsc.orsApiTools.isochrones.enums.EnumAttributes;
import com.github.marcoshsc.orsApiTools.isochrones.enums.EnumRangeType;
import com.github.marcoshsc.orsApiTools.json.deserializers.CoordinateListDeserializer;
import lombok.Getter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {

    private final List<Integer> range;

    @JsonDeserialize(using = CoordinateListDeserializer.class)
    private final List<Coordinate> locations;

    private final EnumRangeType rangeType;
    private final List<EnumAttributes> attributes;

    public Info(@JsonProperty(value = "range", required = true) List<Integer> range,
                @JsonProperty(value = "locations", required = true) List<Coordinate> locations,
                @JsonProperty(value = "range_type") EnumRangeType rangeType,
                @JsonProperty("attributes") List<EnumAttributes> attributes) {
        this.range = range;
        this.locations = locations;
        this.rangeType = rangeType == null ? EnumRangeType.TIME : rangeType;
        this.attributes = attributes == null ? new ArrayList<>() : attributes;
    }
}
