package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.interfaces.JSONRepresentation;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describe a vehicle for optimization requests.
 *
 * @author Marcos Henrique
 */
public class Vehicle implements JSONRepresentation {

    /**
     * Unique Identifier.
     */
    private int id;
    /**
     * Routing profile (defaults to car)
     */
    private EnumProfile profile;
    /**
     * Coordinates array
     */
    private Coordinate start;
    /**
     * Index of relevant row and column in custom matrix
     */
    private Integer startIndex;
    /**
     * Coordinates array
     */
    private Coordinate end;
    /**
     * Index of relevant row and column in custom matrix
     */
    private Integer endIndex;
    /**
     * An array of integers describing multidimensional quantities
     */
    private List<Integer> capacity;
    /**
     * An array of integers defining skills
     */
    private List<Integer> skills;
    /**
     * A time_window object describing working hours
     */
    private TimeWindow timeWindow;
    /**
     * An array of break objects
     */
    private List<Break> breaks;

    public Vehicle(int id, EnumProfile profile, Coordinate start, Integer startIndex, Coordinate end, Integer endIndex,
                   List<Integer> capacity, List<Integer> skills, TimeWindow timeWindow, List<Break> breaks) {
        this.id = id;
        this.profile = profile;
        this.start = start;
        this.startIndex = startIndex;
        this.end = end;
        this.endIndex = endIndex;
        this.capacity = capacity;
        this.skills = skills;
        this.timeWindow = timeWindow;
        this.breaks = breaks;
    }

    /**
     *
     * @return a JSON representation of a vehicle
     * @throws JSONException if some JSON parsing exception happened.
     */
    @Override
    public JSONObject getJSONRepresentation() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("profile", profile.toString());
        if(start != null)
            obj.put("start", UtilityFunctions.getCoordinateJSONArray(start));
        if(startIndex != null)
            obj.put("start_index", startIndex.intValue());
        if(end != null)
            obj.put("end", UtilityFunctions.getCoordinateJSONArray(end));
        if(endIndex != null)
            obj.put("end_index", endIndex.intValue());
        if(capacity != null)
            obj.put("capacity", UtilityFunctions.getIntegerJSONArray(capacity));
        if(skills != null)
            obj.put("skills", UtilityFunctions.getIntegerJSONArray(skills));
        if(timeWindow != null)
            obj.put("time_window", UtilityFunctions.getJSONArrayFromTimeWindow(timeWindow));
        if(breaks != null)
            obj.put("breaks", getJSONArrayFromBreakList(breaks));
        return obj;
    }

    private JSONArray getJSONArrayFromBreakList(List<Break> list) throws JSONException {
        JSONArray array = new JSONArray();
        for(Break b : list)
            array.put(b.getJSONRepresentation());
        return array;
    }

    public int getId() {
        return id;
    }

    public EnumProfile getProfile() {
        return profile;
    }

    public Coordinate getStart() {
        return start;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Coordinate getEnd() {
        return end;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public List<Integer> getCapacity() {
        return capacity;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public TimeWindow getTimeWindow() {
        return timeWindow;
    }

    public List<Break> getBreaks() {
        return breaks;
    }
}
