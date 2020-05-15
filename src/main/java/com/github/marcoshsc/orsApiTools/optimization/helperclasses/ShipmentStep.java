package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.github.marcoshsc.orsApiTools.interfaces.JSONRepresentation;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describes a shipment step. A shipment step is either delivery or shipment, and describe how it is going to be made.
 *
 * @author Marcos Henrique
 */
public class ShipmentStep implements JSONRepresentation {

    /**
     * Unique identifier
     */
    private int id;
    /**
     * Location where the shipment step will be made.
     */
    private Coordinate location;
    /**
     * Index of the location in the matrix. Just works if a durations matrix was passed in the parameters.
     */
    private Integer locationIndex;
    /**
     * Total time spent in the step.
     */
    private int service;
    /**
     * List of periods of time that the step can be started.
     */
    private List<TimeWindow> timeWindows;

    public ShipmentStep(int id, Coordinate location, Integer locationIndex, int service, List<TimeWindow> timeWindows) {
        this.id = id;
        this.location = location;
        this.locationIndex = locationIndex;
        this.service = service;
        this.timeWindows = timeWindows;
    }

    /**
     *
     * @return a JSON representation of a step.
     * @throws JSONException if some JSON parsing error happened.
     */
    @Override
    public JSONObject getJSONRepresentation() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        if(location != null)
            obj.put("location", UtilityFunctions.getCoordinateJSONArray(location));
        if(locationIndex != null)
            obj.put("location_index", locationIndex.intValue());
        if(service != 0)
            obj.put("service", service);
        if(timeWindows != null)
            obj.put("time_windows", UtilityFunctions.getJSONArrayFromTimeWindowList(timeWindows));
        return obj;
    }

    public int getId() {
        return id;
    }

    public Coordinate getLocation() {
        return location;
    }

    public Integer getLocationIndex() {
        return locationIndex;
    }

    public int getService() {
        return service;
    }

    public List<TimeWindow> getTimeWindows() {
        return timeWindows;
    }
}
