package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.NumericParameter;

/**
 * Radius of circular boundary around the center coordinate in kilometers.
 * Use with {@link BoundaryCircleLongitude} and {@link BoundaryCircleLatitude}
 *
 * Default value is 50 kilometers.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class BoundaryCircleRadius extends NumericParameter<Double> {

    private final String name = ORSEnum.BOUNDARY_CIRCLE_RADIUS.toString();

    public BoundaryCircleRadius(Double value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }
}
