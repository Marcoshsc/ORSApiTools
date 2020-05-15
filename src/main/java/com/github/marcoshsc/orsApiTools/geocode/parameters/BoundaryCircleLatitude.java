package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.NumericParameter;

/**
 * Center Latitude of circular boundary to narrow results.
 * Use with {@link BoundaryCircleLongitude} & {@link BoundaryCircleRadius}.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class BoundaryCircleLatitude extends NumericParameter<Double> {

    private final String name = ORSEnum.BOUNDARY_CIRCLE_LATITUDE.toString();

    public BoundaryCircleLatitude(Double value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }
}
