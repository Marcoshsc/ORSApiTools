package com.github.marcoshsc.orsApiTools.pois;

import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.PoisLocation;
import com.github.marcoshsc.orsApiTools.pois.helperclasses.PoisResponseOptions;
import org.json.JSONObject;

import java.util.List;

/**
 * Abstraction of a POIS response from the ORS API.
 * https://github.com/GIScience/openpoiservice for more information
 *
 * @author Marcos Henrique
 */
public class PoisResponse {

    /**
     * JSON object representing the response
     */
    private JSONObject jsonResponse;
    /**
     * Array of coordinates representing the bounding box where the points of interest is contained.
     */
    private BoundingBox boundingBox;
    /**
     * Array of found locations
     */
    private List<PoisLocation> features;
    /**
     * Some of the request values passed when making this response.
     */
    private PoisResponseOptions options;

    public PoisResponse(JSONObject jsonResponse, BoundingBox boundingBox, List<PoisLocation> features, PoisResponseOptions options) {
        this.jsonResponse = jsonResponse;
        this.boundingBox = boundingBox;
        this.features = features;
        this.options = options;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public List<PoisLocation> getFeatures() {
        return features;
    }

    public PoisResponseOptions getOptions() {
        return options;
    }

    public JSONObject getJsonResponse() {
        return jsonResponse;
    }

    @Override
    public String toString() {
        return "PoisResponse{" +
                "boundingBox=" + boundingBox +
                ", features=" + features +
                ", options=" + options +
                "}\n";
    }
}
