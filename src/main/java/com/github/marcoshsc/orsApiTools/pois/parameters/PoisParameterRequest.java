package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.pois.enums.PoisRequestEnum;

/**
 * Type of the request to be made. Currently the only supported value is "pois".
 *
 * @author Marcos Henrique
 */
public class PoisParameterRequest implements JSONBodyParameter<String> {

    private final String name = ORSEnum.REQUEST_BODY_PARAM.toString();

    /**
     * The type of the request.
     */
    private PoisRequestEnum value;

    public PoisParameterRequest(PoisRequestEnum value) {
        this.value = value;
    }

    /**
     *
     * @return the parameter name.
     */
    @Override
    public String getKey() {
        return name;
    }

    /**
     *
     * @return the final processed object referent to the parameter.
     */
    @Override
    public String getValue() {
        return value.toString();
    }

    public PoisRequestEnum getRequestValue() {
        return value;
    }

}
