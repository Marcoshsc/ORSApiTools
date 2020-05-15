package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.NumericParameter;

/**
 * Set the number of returned results. Default value: 10. Maximum size is 40.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class Size extends NumericParameter<Integer> {

    private final String name = ORSEnum.SIZE_PARAM.toString();

    public Size(Integer value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }

}
