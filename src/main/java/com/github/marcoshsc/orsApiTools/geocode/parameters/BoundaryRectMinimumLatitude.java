package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.NumericParameter;

/**
 * Bottom border of rectangular boundary to narrow results.
 * Use with {@link BoundaryRectMaximumLongitude} and {@link BoundaryRectMaximumLatitude}
 * and {@link BoundaryRectMinimumLongitude}.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class BoundaryRectMinimumLatitude extends NumericParameter<Double> {

    private final String name = ORSEnum.BOUNDARY_RECTANGLE_MINIMUM_LATITUDE.toString();

    public BoundaryRectMinimumLatitude(Double value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }
}
