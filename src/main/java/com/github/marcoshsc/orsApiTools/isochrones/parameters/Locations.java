package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoshsc.orsApiTools.json.serializers.CoordinateListSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

@Getter
@AllArgsConstructor
public class Locations {

    @JsonValue
    @JsonSerialize(using = CoordinateListSerializer.class)
    private final List<Coordinate> value;


}
