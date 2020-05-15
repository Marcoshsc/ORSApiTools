package com.github.marcoshsc.orsApiTools.pois.enums;

/**
 * Represent all the possible values to the "filters" parameter.
 *
 * @author Marcos Henrique
 */
public enum FiltersEnum {

    CATEGORY_GROUP_IDS("category_group_ids"),
    CATEGORY_IDS("category_ids"),
    NAME("name"),
    WHEELCHAIR("wheelchair"),
    SMOKING("smoking"),
    FEE("fee");

    private String value;

    FiltersEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
