package com.github.marcoshsc.orsApiTools.matrix.v1;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.directions.enums.UnitsEnum;
import com.github.marcoshsc.orsApiTools.general.interfaces.JSONProcessingStrategy;
import com.github.marcoshsc.orsApiTools.matrix.v1.helperclasses.LocationDescription;
import com.github.marcoshsc.orsApiTools.matrix.helperclasses.MatrixRequestOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Matrix processing strategy, to JSON responses received from the ORS API.
 *
 * @author Marcos Henrique
 */
public class MatrixProcessingStrategy implements JSONProcessingStrategy<MatrixResponse> {

    /**
     * Parses the JSON and return a response.
     * @param obj the JSON to be parsed.
     * @return the matrix response parsed.
     * @throws JSONException if some JSON parsing exception happen.
     */
    @Override
    public MatrixResponse processJSON(JSONObject obj) throws JSONException {
        JSONArray distancesJSONArray = obj.has("distances") ?  obj.getJSONArray("distances") : null;
        List<List<Double>> distances = distancesJSONArray != null ? getMatrixFromJSONArray(distancesJSONArray) : null;
        JSONArray durationsJSONArray = obj.has("durations") ? obj.getJSONArray("durations") : null;
        List<List<Double>> durations = durationsJSONArray != null ? getMatrixFromJSONArray(durationsJSONArray) : null;
        JSONArray sourcesJSONArray = obj.getJSONArray("sources");
        List<LocationDescription> sources = getLocationDescriptions(sourcesJSONArray);
        JSONArray destinationsJSONArray = obj.getJSONArray("destinations");
        List<LocationDescription> destinations = getLocationDescriptions(destinationsJSONArray);
        JSONObject queryInfo = obj.getJSONObject("info").getJSONObject("query");
        MatrixRequestOptions options = getOptions(queryInfo);
        return new MatrixResponse(distances, durations, sources, destinations, options);
    }

    /**
     * Get the matrix contained in the array.
     * @param array the JSONArray containing the matrix.
     * @return a complete matrix, parsed from the JSON
     * @throws JSONException if some JSON parsing exception happen.
     */
    private List<List<Double>> getMatrixFromJSONArray(JSONArray array) throws JSONException {
        List<List<Double>> matrix = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            List<Double> line = getListFromJSONArray(array.getJSONArray(i));
            matrix.add(line);
        }
        return matrix;
    }

    /**
     * Get the list contained in the array.
     * @param array the JSONArray containing the list.
     * @return a complete list, parsed from the JSON
     * @throws JSONException if some JSON parsing exception happen.
     */
    private List<Double> getListFromJSONArray(JSONArray array) throws JSONException {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            list.add(array.getDouble(i));
        }
        return list;
    }

    /**
     * Get location descriptions contained in the received array. Location descriptions refers to sources and destinations.
     * @param array JSONArray containing the lists.
     * @return a list parsed from the JSON
     * @throws JSONException if some JSON parsing exception happen.
     */
    private List<LocationDescription> getLocationDescriptions(JSONArray array) throws JSONException {
        List<LocationDescription> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            LocationDescription desc = getLocationDescription(array.getJSONObject(i));
            list.add(desc);
        }
        return list;
    }

    /**
     * Parse a JSON object and return a location description (sources/destinations)
     * @param obj the object to be parsed.
     * @return the parsed object.
     * @throws JSONException if some JSON parsing exception happen.
     */
    private LocationDescription getLocationDescription(JSONObject obj) throws JSONException {
        JSONArray coords = obj.getJSONArray("location");
        Coordinate location = new Coordinate(coords.getDouble(0), coords.getDouble(1));
        String name = obj.has("name") ? obj.getString("name") : null;
        double snappedDistance = obj.getDouble("snapped_distance");
        return new LocationDescription(location, name, snappedDistance);
    }

    /**
     * Parse a JSON that contains the response options information.
     * @param obj the JSON to be parsed
     * @return the response options, totally parsed from the JSON.
     * @throws JSONException if some JSON parsing exception happen.
     */
    private MatrixRequestOptions getOptions(JSONObject obj) throws JSONException {
        String profileStr = obj.getString("profile");
        EnumProfile profile = EnumProfile.getByStr(profileStr);
        String unitsStr = obj.getString("units");
        UnitsEnum units = UnitsEnum.getByStr(unitsStr);
        return new MatrixRequestOptions(profile, units);
    }

}
