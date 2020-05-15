package com.github.marcoshsc.orsApiTools.pois.enums;

/**
 * Represents all the possible values to the "smoking" parameter.
 *
 * @author Marcos Henrique
 */
public enum SmokingEnum {

    /**
     * The complete restaurant (pub, etc.) is dedicated to smokers; E.g., as a smoker's club, Fumoir, or Raucherclub.
     */
    DEDICATED("dedicated"),

    /**
     * Smoking is permitted in the entire hotel/bar/restaurant.
     */
    YES("yes"),

    /**
     * 	Smoking is prohibited in the entire hotel/bar/restaurant, without exceptions.
     */
    NO("no"),

    /**
     * Smoking is permitted in a separated room or area, either two different areas of the same room, or in different
     * rooms without having an effective separation to each other; e.g., there is a door which is not being closed
     * immediately after a person has passed.
     */
    SEPARATED("separated"),

    /**
     * smoking is prohibited and allowed in two different rooms which are separated effectively
     * (e.g., walls and a door which is opened only as long as it is necessary to pass through)
     */
    ISOLATED("isolated"),

    /**
     * Smoking is allowed on the property but only in outside areas.
     */
    OUTSIDE("outside");

    private String value;

    SmokingEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
