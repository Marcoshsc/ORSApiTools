package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import org.json.JSONObject;

/**
 * Tags that can show up in the feature list. They are not guaranteed to be not null, so you must check it before using
 * the values.
 *
 * @author Marcos Henrique
 */
public class OSMTags {

    /**
     * JSON object representing the tags but with no processing.
     */
    private JSONObject jsonFormat;
    /**
     * Name of the location.
     */
    private String name;
    /**
     * Location address.
     */
    private String address;
    /**
     * URL of location's website.
     */
    private String webSite;
    /**
     * Schedule of the location.
     */
    private String openingHours;
    /**
     * Wheelchair accessibility.
     */
    private String wheelchair;
    /**
     * Distance
     */
    private String distance;
    /**
     * Fee rules of the location.
     */
    private String fee;
    /**
     * Location's smoking rules
     */
    private String smoking;
    /**
     * Location's phone number.
     */
    private String phone;

    public OSMTags(JSONObject jsonFormat, String name, String address, String webSite, String openingHours,
                   String wheelchair, String distance, String fee, String smoking, String phone) {
        this.jsonFormat = jsonFormat;
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

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getWheelchair() {
        return wheelchair;
    }

    public String getDistance() {
        return distance;
    }

    public String getFee() {
        return fee;
    }

    public String getSmoking() {
        return smoking;
    }

    public String getPhone() {
        return phone;
    }

    public JSONObject getJsonFormat() {
        return jsonFormat;
    }

    @Override
    public String toString() {
        return "OSMTags{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", webSite='" + webSite + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", wheelchair='" + wheelchair + '\'' +
                ", distance='" + distance + '\'' +
                ", fee='" + fee + '\'' +
                ", smoking='" + smoking + '\'' +
                ", phone='" + phone + '\'' +
                "}\n";
    }
}
