package com.github.marcoshsc.orsApiTools.optimization;

import com.github.marcoshsc.orsApiTools.general.interfaces.JSONProcessingStrategy;
import com.github.marcoshsc.orsApiTools.optimization.enums.StepTypeEnum;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.*;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.locationtech.jts.geom.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON processing strategy for optimization requests.
 *
 * @author Marcos Henrique
 */
public class OptimizationProcessingStrategy implements JSONProcessingStrategy<OptimizationResponse> {

    /**
     *
     * @param obj the JSON object to be processed.
     * @return a java object referent to the JSON received.
     * @throws JSONException if some JSON parsing exception happened.
     */
    @Override
    public OptimizationResponse processJSON(JSONObject obj) throws JSONException {
        int code = obj.getInt("code");
        if(code != 0) {
            String errorMessage = obj.getString("error");
            return new OptimizationResponse(code, errorMessage, null, null, null);
        }
        Summary summary = getSummary(obj.getJSONObject("summary"));
        List<Unassigned> unassigneds = getUnassigneds(obj.getJSONArray("unassigned"));
        List<Route> routes = getRoutes(obj.getJSONArray("routes"));
        return new OptimizationResponse(code, null, summary, unassigneds, routes);
    }

    private Summary getSummary(JSONObject obj) throws JSONException {
        int cost = obj.getInt("cost");
        int unassigned = obj.getInt("unassigned");
        int service = obj.getInt("service");
        int duration = obj.getInt("duration");
        int waitingTime = obj.getInt("waiting_time");
        ComputingTime computingTime = getComputingTime(obj.getJSONObject("computing_times"));
        List<Integer> pickup = getIntegerListIfExists(obj, "pickup");
        List<Integer> delivery = getIntegerListIfExists(obj, "delivery");
        Double distance = getDoubleIfExists(obj, "distance");
        return new Summary(cost, unassigned, service, duration, waitingTime, computingTime, pickup, delivery, distance);
    }

    private ComputingTime getComputingTime(JSONObject obj) throws JSONException {
        int loading = obj.getInt("loading");
        int solving = obj.getInt("solving");
        return new ComputingTime(loading, solving);
    }

    private List<Integer> getIntegerListFromJSONArray(JSONArray array) throws JSONException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            list.add(array.getInt(i));
        }
        return list;
    }

    private Double getDoubleIfExists(JSONObject obj, String key) throws JSONException {
        if(obj.has(key))
            return obj.getDouble(key);
        return null;
    }

    private List<Unassigned> getUnassigneds(JSONArray array) throws JSONException {
        List<Unassigned> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Unassigned unassigned = getUnassigned(array.getJSONObject(i));
            list.add(unassigned);
        }
        return list;
    }

    private Unassigned getUnassigned(JSONObject obj) throws JSONException {
        int id = obj.getInt("id");
        Coordinate location = getCoordinateIfNotNull(obj, "location");
        return new Unassigned(id, location);
    }

    private List<Route> getRoutes(JSONArray array) throws JSONException {
        List<Route> routes = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Route route = getRoute(array.getJSONObject(i));
            routes.add(route);
        }
        return routes;
    }

    private Route getRoute(JSONObject obj) throws JSONException {
        int vehicle = obj.getInt("vehicle");
        List<Step> steps = getSteps(obj.getJSONArray("steps"));
        int cost = obj.getInt("cost");
        int service = obj.getInt("service");
        int duration = obj.getInt("duration");
        int waitingTime = obj.getInt("waiting_time");
        List<Integer> pickup = getIntegerListIfExists(obj, "pickup");
        List<Integer> delivery = getIntegerListIfExists(obj, "delivery");
        String geometry = getStringIfExists(obj, "geometry");
        Double distance = getDoubleIfExists(obj, "distance");
        return new Route(vehicle, steps, cost, service, duration, waitingTime, pickup, delivery, geometry, distance);
    }

    private List<Step> getSteps(JSONArray array) throws JSONException {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            Step step = getStep(array.getJSONObject(i));
            steps.add(step);
        }
        return steps;
    }

    private Step getStep(JSONObject obj) throws JSONException {
        StepTypeEnum type = StepTypeEnum.getByStr(obj.getString("type"));
        int arrival = obj.getInt("arrival");
        int duration = obj.getInt("duration");
        Coordinate location = getCoordinateIfNotNull(obj, "location");
        Integer job = getIntegerIfExists(obj, "job");
        List<Integer> load = getIntegerListIfExists(obj, "load");
        Integer service = getIntegerIfExists(obj, "service");
        Integer waitingTime = getIntegerIfExists(obj, "waiting_time");
        Double distance = getDoubleIfExists(obj, "distance");
        return new Step(type, arrival, duration, location, job, load, service, waitingTime, distance);
    }

    private Coordinate getCoordinateIfNotNull(JSONObject obj, String key) throws JSONException {
        if(obj.has(key))
            return UtilityFunctions.getCoordinateFromJSONArray(obj.getJSONArray(key));
        return null;
    }

    private List<Integer> getIntegerListIfExists(JSONObject obj, String key) throws JSONException {
        if(obj.has(key))
            return getIntegerListFromJSONArray(obj.getJSONArray(key));
        return null;
    }

    private Integer getIntegerIfExists(JSONObject obj, String key) throws JSONException {
        if(obj.has(key))
            return obj.getInt(key);
        return null;
    }

    private String getStringIfExists(JSONObject obj, String key) throws JSONException {
        if(obj.has(key))
            return obj.getString(key);
        return null;
    }

}
