package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.github.marcoshsc.orsApiTools.interfaces.JSONRepresentation;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Describes a break of a vehicle.
 *
 * @author Marcos Henrique
 */
public class Break implements JSONRepresentation {

    /**
     * Unique identifier
     */
    private int id;
    /**
     * Periods of time that the break can be started.
     */
    private List<TimeWindow> timeWindows;
    /**
     * Total time spent in the break.
     */
    private int service;

    public Break(int id, List<TimeWindow> timeWindows, int service) {
        this.id = id;
        this.timeWindows = timeWindows;
        this.service = service;
    }

    /**
     *
     * @return an JSON representation of the break object.
     * @throws JSONException if some JSON parsing error happened.
     */
    @Override
    public JSONObject getJSONRepresentation() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        if(timeWindows != null)
            obj.put("time_windows", UtilityFunctions.getJSONArrayFromTimeWindowList(timeWindows));
        if(service != 0)
            obj.put("service", service);
        return obj;
    }

    public int getId() {
        return id;
    }

    public List<TimeWindow> getTimeWindows() {
        return timeWindows;
    }

    public int getService() {
        return service;
    }
}
