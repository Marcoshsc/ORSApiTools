package com.github.marcoshsc.orsApiTools.geocode;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.Location;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Response representation of geocode/search endpoint. JSON raw data is accessible for deeper search.
 *
 * @author Marcos Henrique in 28-04-2020
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeSearchResponse {

    /**
     * List of found locations.
     */
    private final List<Location> foundLocations;

    @JsonCreator
    public GeocodeSearchResponse(@JsonProperty("features")
                                         List<Location> foundLocations) {
        this.foundLocations = foundLocations;
    }

}
