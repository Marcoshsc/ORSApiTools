package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.NumericParameter;

/**
 * Center Longitude of circular boundary to narrow results.
 * Use with {@link BoundaryCircleLatitude} & {@link BoundaryCircleRadius}.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class BoundaryCircleLongitude extends NumericParameter<Double> {

    private final String name = ORSEnum.BOUNDARY_CIRCLE_LONGITUDE.toString();

    public BoundaryCircleLongitude(Double value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }
}
