package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.NumericParameter;

/**
 * Right border of rectangular boundary to narrow results.
 * Use with {@link BoundaryRectMaximumLatitude} and {@link BoundaryRectMinimumLatitude}
 * and {@link BoundaryRectMinimumLongitude}.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class BoundaryRectMaximumLongitude extends NumericParameter<Double> {

    private final String name = ORSEnum.BOUNDARY_RECTANGLE_MAXIMUM_LONGITUDE.toString();

    public BoundaryRectMaximumLongitude(Double value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }
}
