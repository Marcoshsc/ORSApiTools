package com.github.marcoshsc.orsApiTools.geocode.helperclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a simple bounding box with 4 coordinates. This class should be read-only.
 *
 * @author Marcos Henrique in 28-04-2020
 */
@Getter
@ToString
@AllArgsConstructor
public class BoundingBox {

    private final double minLatitude;
    private final double maxLatitude;
    private final double minLongitude;
    private final double maxLongitude;

}
