package com.github.marcoshsc.orsApiTools.geocode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.geocode.helperclasses.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.json.JSONObject;

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

//    /**
//     * JSON format of response without any processing.
//     */
//    private final JSONObject jsonData;
    /**
     * List of found locations.
     */
    private final List<Location> foundLocations;

    public GeocodeSearchResponse(@JsonProperty("features")
                                         List<Location> foundLocations) {
        this.foundLocations = foundLocations;
    }
//
//    public JSONObject getJsonData() {
//        return jsonData;
//    }
//
//    public List<Location> getFoundLocations() {
//        return foundLocations;
//    }
}
