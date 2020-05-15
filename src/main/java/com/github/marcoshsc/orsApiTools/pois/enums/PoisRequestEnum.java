package com.github.marcoshsc.orsApiTools.pois.enums;

/**
 * Represent all the possible values to the "request" parameter.
 *
 * @author Marcos Henrique
 */
public enum PoisRequestEnum {

    /**
     * will return a GeoJSON FeatureCollection in your specified bounding box or geometry.
     */
    POIS("pois"),

    /**
     * will do the same but group by the categories, ultimately returning a JSON object with the absolute numbers of
     * pois of a certain group
     */
    STATS("stats"),

    /**
     *  will return a JSON object with all the categories available.
     */
    LIST("list");

    private String value;

    PoisRequestEnum(String value) {
        this.value = value;
    }

    public static PoisRequestEnum getByStr(String value) {
        for (PoisRequestEnum element :
                PoisRequestEnum.values()) {
            if(element.toString().equals(value))
                return element;
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
