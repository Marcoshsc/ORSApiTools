package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.StringParameter;

/**
 * Restrict results to single country. Possible values are alpha-2 and alpha-3 country codes.
 * Example: DEU or DE for Germany.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class BoundaryCountry extends StringParameter {

    private final String name = ORSEnum.BOUNDARY_COUNTRY.toString();

    public BoundaryCountry(String value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }
}
