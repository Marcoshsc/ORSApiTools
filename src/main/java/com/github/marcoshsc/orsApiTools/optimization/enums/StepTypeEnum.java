package com.github.marcoshsc.orsApiTools.optimization.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

/**
 * Describe all the possible values that a step can have.
 *
 * @author Marcos Henrique
 */
@RequiredArgsConstructor
public enum StepTypeEnum {

    START("start"),
    JOB("job"),
    PICKUP("pickup"),
    DELIVERY("delivery"),
    BREAK("break"),
    END("end");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static StepTypeEnum getByStr(String value) {
        for (StepTypeEnum element :
                StepTypeEnum.values()) {
            if(element.getValue().toUpperCase().equals(value.toUpperCase()))
                return element;
        }
        return null;
    }

    public String toString() {
        return value;
    }

}
