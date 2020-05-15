package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.NumericParameter;

/**
 * Longitude of the focus.point. Specify the focus point to order results by linear distance to this point.
 * Works for up to 100 kilometers distance. Use with FocusPointLatitude.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class FocusPointLatitude extends NumericParameter<Double> {

    private final String name = ORSEnum.FOCUS_POINT_LATITUDE_PARAM.toString();

    public FocusPointLatitude(Double value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }
}
