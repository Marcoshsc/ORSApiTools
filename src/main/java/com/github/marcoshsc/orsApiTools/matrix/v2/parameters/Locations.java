package com.github.marcoshsc.orsApiTools.matrix.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoshsc.orsApiTools.json.serializers.CoordinateListSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * List of comma separated lists of longitude,latitude coordinates.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Locations {

    @JsonValue
    @JsonSerialize(using = CoordinateListSerializer.class)
    private final List<Coordinate> locations;

}
