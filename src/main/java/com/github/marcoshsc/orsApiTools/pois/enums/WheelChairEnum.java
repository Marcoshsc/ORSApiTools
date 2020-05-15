package com.github.marcoshsc.orsApiTools.pois.enums;

/**
 * Represents all the possible values to the "wheelchair" parameter.
 *
 * @author Marcos Henrique
 */
public enum WheelChairEnum {

    /**
     * Wheelchairs have full unrestricted access.
     */
    YES("yes"),

    /**
     * Wheelchairs have no unrestricted access (e.g. stair only access).
     */
    NO("no"),

    /**
     * Wheelchairs have partial access (e.g some areas can be accessed and others not, areas requiring assistance by
     * someone pushing up a steep gradient).
     */
    LIMITED("limited"),

    /**
     * The way or area is designated or purpose built for wheelchairs
     * (e.g. elevators designed for wheelchair access only). This is rarely used.
     */
    DESIGNATED("designated");

    private String value;

    WheelChairEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
