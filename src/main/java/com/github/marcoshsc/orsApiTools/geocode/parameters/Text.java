package com.github.marcoshsc.orsApiTools.geocode.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.StringParameter;

/**
 * Name of location, street address or postal code.
 * Note: The search also match similarities.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public class Text extends StringParameter {

    private final String name = ORSEnum.TEXT_PARAM.toString();

    public Text(String value) {
        super(value);
    }

    @Override
    public String getName() {
        return name;
    }

}
