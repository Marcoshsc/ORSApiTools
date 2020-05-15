package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.NumericParameter;

/**
 * Latitude of the focus.point. Specify the focus point to order results by linear distance to this point.
 * Works for up to 100 kilometers distance. Use with FocusPointLongitude.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class FocusPointLongitude extends NumericParameter<Double> {

    public final String name = ORSEnum.FOCUS_POINT_LONGITUDE_PARAM.toString();

    public FocusPointLongitude(Double value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }

}
