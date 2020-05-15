package com.github.marcoshsc.orsApiTools.optimization.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Vehicle;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

/**
 * Array of vehicle objects describing the available vehicles. For a detailed object description visit the VROOM API description.
 * https://github.com/VROOM-Project/vroom/blob/master/docs/API.md#vehicles
 *
 * @author Marcos Henrique
 */
public class Vehicles implements JSONBodyParameter<JSONArray> {

    private static final String name = ORSEnum.VEHICLES_BODY_PARAM.toString();
    /**
     * List of vehicles available.
     */
    private List<Vehicle> vehicles;

    public Vehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     *
     * @return the name of the parameter.
     */
    @Override
    public String getKey() {
        return name;
    }

    /**
     *
     * @return an array of vehicle objects.
     * @throws JSONException if some JSON parsing exception happened.
     */
    @Override
    public JSONArray getValue() throws JSONException {
        return getVehicleJSONArray(vehicles);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    private JSONArray getVehicleJSONArray(List<Vehicle> vehicles) throws JSONException {
        JSONArray array = new JSONArray();
        for(Vehicle v : vehicles)
            array.put(v.getJSONRepresentation());
        return array;
    }
}
