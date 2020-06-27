package com.github.marcoshsc.orsApiTools.pois.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * Represent all the possible values to the "filters" parameter.
 *
 * @author Marcos Henrique
 */
@RequiredArgsConstructor
public enum FiltersEnum {

    CATEGORY_GROUP_IDS("category_group_ids"),
    CATEGORY_IDS("category_ids"),
    NAME("name"),
    WHEELCHAIR("wheelchair"),
    SMOKING("smoking"),
    FEE("fee");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static FiltersEnum getFromString(String value) {
        for (FiltersEnum fe : FiltersEnum.values()) {
            if(fe.value.toUpperCase().equals(value.toUpperCase()))
                return fe;
        }
        throw new IllegalArgumentException("Invalid filter value.");
    }

    @Override
    public String toString() {
        return value;
    }

}
