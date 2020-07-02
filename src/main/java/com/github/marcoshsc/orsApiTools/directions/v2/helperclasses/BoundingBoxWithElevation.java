package com.github.marcoshsc.orsApiTools.directions.v2.helperclasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class BoundingBoxWithElevation {

    private final double minLon;
    private final double minLat;
    private final Double minElevation;
    private final double maxLon;
    private final double maxLat;
    private final Double maxElevation;

}
