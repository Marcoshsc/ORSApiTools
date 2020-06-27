package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.wololo.geojson.Geometry;

/**
 * A GeoJSON representation. It holds a type and a point. Currently only supported type is "Point".
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@AllArgsConstructor
public class GeoJSON {

    @JsonValue
    private final Geometry geometry;

}
