package com.github.marcoshsc.orsApiTools.pois.enums;

/**
 * Represents all the possible values to the "sortby" parameter.
 *
 * @author Marcos Henrique
 */
public enum SortByEnum {

    CATEGORY("category"),
    DISTANCE("distance");

    private String value;

    SortByEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
