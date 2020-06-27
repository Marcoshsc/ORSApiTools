package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * Tags that can show up in the feature list. They are not guaranteed to be not null, so you must check it before using
 * the values.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OSMTags {

    /**
     * Name of the location.
     */
    private final String name;

    /**
     * Location address.
     */
    private final String address;

    /**
     * URL of location's website.
     */
    private final String webSite;

    /**
     * Schedule of the location.
     */
    private final String openingHours;

    /**
     * Wheelchair accessibility.
     */
    private final String wheelchair;

    /**
     * Distance
     */
    private final String distance;

    /**
     * Fee rules of the location.
     */
    private final String fee;

    /**
     * Location's smoking rules
     */
    private final String smoking;

    /**
     * Location's phone number.
     */
    private final String phone;

    @JsonCreator
    public OSMTags(@JsonProperty("name") String name,
                   @JsonProperty("address") String address,
                   @JsonProperty("website") String webSite,
                   @JsonProperty("opening_hours") String openingHours,
                   @JsonProperty("wheelchair") String wheelchair,
                   @JsonProperty("distance") String distance,
                   @JsonProperty("fee") String fee,
                   @JsonProperty("smoking") String smoking,
                   @JsonProperty("phone") String phone) {
        this.name = name;
        this.address = address;
        this.webSite = webSite;
        this.openingHours = openingHours;
        this.wheelchair = wheelchair;
        this.distance = distance;
        this.fee = fee;
        this.smoking = smoking;
        this.phone = phone;
    }

}
