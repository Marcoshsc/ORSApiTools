package com.github.marcoshsc.orsApiTools.geocode;

import com.github.marcoshsc.orsApiTools.geocode.helperclasses.Location;
import org.json.JSONObject;

import java.util.List;

/**
 * Response representation of geocode/search endpoint. JSON raw data is accessible for deeper search.
 *
 * @author Marcos Henrique in 28-04-2020
 */
public class GeocodeSearchResponse {

    /**
     * JSON format of response without any processing.
     */
    private JSONObject jsonData;
    /**
     * List of found locations.
     */
    private List<Location> foundLocations;

    public GeocodeSearchResponse(JSONObject jsonData, List<Location> foundLocations) {
        this.jsonData = jsonData;
        this.foundLocations = foundLocations;
    }

    public JSONObject getJsonData() {
        return jsonData;
    }

    public List<Location> getFoundLocations() {
        return foundLocations;
    }
}
