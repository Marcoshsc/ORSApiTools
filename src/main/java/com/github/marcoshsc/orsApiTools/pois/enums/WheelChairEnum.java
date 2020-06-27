package com.github.marcoshsc.orsApiTools.pois.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * Represents all the possible values to the "wheelchair" parameter.
 *
 * @author Marcos Henrique
 */
@RequiredArgsConstructor
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

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}
