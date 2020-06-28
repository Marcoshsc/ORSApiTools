package com.github.marcoshsc.orsApiTools.isochrones.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Applies a level of generalisation to the isochrone polygons generated as a smoothing_factor between 0 and 100.0.
 * Generalisation is produced by determining a maximum length of a connecting line between two points found on
 * the outside of a containing polygon. If the distance is larger than a threshold value, the line between the
 * two points is removed and a smaller connecting line between other points is used. Note that the minimum length
 * of this connecting line is ~1333m, and so when the smoothing_factor results in a distance smaller than this, the
 * minimum value is used. The threshold value is determined as (maximum_radius_of_isochrone / 100) * smoothing_factor.
 * Therefore, a value closer to 100 will result in a more generalised shape. The polygon generation algorithm is
 * based on Duckham and al. (2008) "Efficient generation of simple polygons for characterizing the shape of a
 * set of points in the plane."
 */
@Getter
@AllArgsConstructor
public class Smoothing {

    @JsonValue
    private final int value;

}
