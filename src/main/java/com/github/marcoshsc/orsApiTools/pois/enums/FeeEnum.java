package com.github.marcoshsc.orsApiTools.pois.enums;

/**
 * Represent all the possible values to the "fee" parameter.
 *
 * @author Marcos Henrique
 */
public enum FeeEnum {

    /**
     * a fee is usually charged
     */
    YES("yes"),

    /**
     * no fee usually charged
     */
    NO("no");

    private String value;

    FeeEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
