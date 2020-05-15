package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.pois.enums.SortByEnum;

/**
 * Either you can sort by category or the distance to the geometry object provided in the request.
 * In this moment of time sorting by category was not working, so it is disabled.
 * Results are sorted from the smallest to the biggest distance, if it was the sorting value selected.
 *
 * @author Marcos Henrique
 */
public class SortBy implements JSONBodyParameter<String> {

    private static final String name = ORSEnum.SORT_BY_BODY_PARAM.toString();
    /**
     * Sorting strategy.
     */
    private SortByEnum value;

    public SortBy(SortByEnum value) {
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

    public SortByEnum getEnumValue() {
        return value;
    }

}
