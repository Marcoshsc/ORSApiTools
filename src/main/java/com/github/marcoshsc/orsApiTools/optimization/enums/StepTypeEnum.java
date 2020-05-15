package com.github.marcoshsc.orsApiTools.optimization.enums;

/**
 * Describe all the possible values that a step can have.
 *
 * @author Marcos Henrique
 */
public enum StepTypeEnum {

    START("start"),
    JOB("job"),
    PICKUP("pickup"),
    DELIVERY("delivery"),
    BREAK("break"),
    END("end");

    private String value;

    StepTypeEnum(String value) {
        this.value = value;
    }

    public static StepTypeEnum getByStr(String value) {
        for (StepTypeEnum element :
                StepTypeEnum.values()) {
            if(element.toString().equals(value))
                return element;
        }
        return null;
    }

    public String toString() {
        return value;
    }

}
