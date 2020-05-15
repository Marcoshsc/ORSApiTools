package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.NumericParameter;

/**
 * Left border of rectangular boundary to narrow results.
 * Use with {@link BoundaryRectMaximumLongitude} & {@link BoundaryRectMaximumLatitude}
 * & {@link BoundaryRectMinimumLatitude}.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class BoundaryRectMinimumLongitude extends NumericParameter<Double> {

    private final String name = ORSEnum.BOUNDARY_RECTANGLE_MINIMUM_LONGITUDE.toString();

    public BoundaryRectMinimumLongitude(Double value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }
}
