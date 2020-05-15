package com.github.marcoshsc.orsApiTools.optimization;

import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.interfaces.JSONRequestBody;
import com.github.marcoshsc.orsApiTools.optimization.parameters.Jobs;
import com.github.marcoshsc.orsApiTools.optimization.parameters.OptimizationMatrix;
import com.github.marcoshsc.orsApiTools.optimization.parameters.Shipments;
import com.github.marcoshsc.orsApiTools.optimization.parameters.Vehicles;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;

/**
 * A set of parameters that compose a optimization request.
 *
 * @author Marcos Henrique
 */
public class OptimizationParameters implements JSONRequestBody {

    private Jobs jobs;
    private OptimizationMatrix matrix;
    private Shipments shipments;
    private Vehicles vehicles;

    /**
     *
     * @return a JSON representation to be used as body of a POST request.
     * @throws JSONException if some JSON parsing exception happened.
     */
    @Override
    public JSONObject getBody() throws JSONException {
        JSONObject obj = new JSONObject();
        try {
            for(Field f : this.getClass().getDeclaredFields()) {
                Object o;
                o = f.get(this);
                if(o != null) {
                    JSONBodyParameter<?> parameter = (JSONBodyParameter<?>)o;
                    obj.put(parameter.getKey(), parameter.getValue());
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            System.out.println("Something wrong happened with the parameters");
        }
        return obj;
    }

    public Jobs getJobs() {
        return jobs;
    }

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }

    public OptimizationMatrix getMatrix() {
        return matrix;
    }

    public void setMatrix(OptimizationMatrix matrix) {
        this.matrix = matrix;
    }

    public Shipments getShipments() {
        return shipments;
    }

    public void setShipments(Shipments shipments) {
        this.shipments = shipments;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }
}
