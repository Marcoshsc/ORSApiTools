package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.github.marcoshsc.orsApiTools.interfaces.JSONRepresentation;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describes a job object. The fields are described as follows:
 *
 * @author Marcos Henrique
 */
public class Job implements JSONRepresentation {

    /**
     * unique identifier, must not be null.
     */
    private int id;
    /**
     * location of the job.
     */
    private Coordinate location;
    /**
     * the index of the location in the matrix passed. it's only allowed when an matrix is present in the request.
     */
    private Integer locationIndex;
    /**
     * Total time spent in the job.
     */
    private int service;
    /**
     * Array of delivery quantities.
     */
    private List<Integer> delivery;
    /**
     * Array of pickup quantities.
     */
    private List<Integer> pickup;
    /**
     * Array of skills needed to do the job.
     */
    private List<Integer> skills;
    /**
     * Priority of the job, [0,100].
     */
    private Integer priority;
    /**
     * List of time windows, which are the periods of time that the job can be started.
     */
    private List<TimeWindow> timeWindows;

    public Job(int id, Coordinate location, Integer locationIndex, int service, List<Integer> delivery,
               List<Integer> pickup, List<Integer> skills, Integer priority, List<TimeWindow> timeWindows) {
        this.id = id;
        this.location = location;
        this.locationIndex = locationIndex;
        this.service = service;
        this.delivery = delivery;
        this.pickup = pickup;
        this.skills = skills;
        this.priority = priority;
        this.timeWindows = timeWindows;
    }

    /**
     *
     * @return an JSON representation of the job class.
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
        if(delivery != null)
            obj.put("delivery", UtilityFunctions.getIntegerJSONArray(delivery));
        if(pickup != null)
            obj.put("pickup", UtilityFunctions.getIntegerJSONArray(pickup));
        if(skills != null)
            obj.put("skills", UtilityFunctions.getIntegerJSONArray(skills));
        if(priority != null)
            obj.put("priority", priority.intValue());
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

    public List<Integer> getDelivery() {
        return delivery;
    }

    public List<Integer> getPickup() {
        return pickup;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public Integer getPriority() {
        return priority;
    }

    public List<TimeWindow> getTimeWindows() {
        return timeWindows;
    }
}
