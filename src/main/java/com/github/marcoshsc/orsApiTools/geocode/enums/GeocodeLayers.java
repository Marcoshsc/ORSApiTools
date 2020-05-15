package com.github.marcoshsc.orsApiTools.geocode.enums;

/**
 * Description of all possible values to the "layers" query parameters on the ORS API.
 *
 * @author Marcos Henrique in 27-04-2020
 */
public enum GeocodeLayers {

    /**
     * points of interest, businesses, things with walls
     */
    VENUE("venue"),

    /**
     * places with a street address
     */
    ADDRESS("address"),

    /**
     * streets,roads,highways
     */
    STREET("street"),

    /**
     * social communities, neighbourhoods
     */
    NEIGHBOURHOOD("neighbourhood"),

    /**
     * a local administrative boundary, currently only used for New York City
     */
    BOROUGH("borough"),

    /**
     * local administrative boundaries
     */
    LOCAL_ADMIN("localadmin"),

    /**
     * towns, hamlets, cities
     */
    LOCALITY("locality"),

    /**
     * official governmental area; usually bigger than a locality,
     * almost always smaller than a region
     */
    COUNTY("county"),

    /**
     * a related group of counties. Mostly in Europe.
     */
    MACRO_COUNTY("macrocounty"),

    /**
     * states and provinces
     */
    REGION("region"),

    /**
     * 	a related group of regions. Mostly in Europe
     */
    MACRO_REGION("macroregion"),

    /**
     * places that issue passports, nations, nation-states
     */
    COUNTRY("country"),

    /**
     * alias for simultaneously using all administrative layers
     * (everything except venue and address)
     */
    COARSE("coarse");

    private String value;

    GeocodeLayers(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
