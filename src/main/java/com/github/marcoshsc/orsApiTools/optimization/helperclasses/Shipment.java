package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.github.marcoshsc.orsApiTools.interfaces.JSONRepresentation;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Describes a shipment object. A shipment has an amount of quantities to be picked up in a point, and to be delivered
 * in another point.
 *
 * @author Marcos Henrique
 */
public class Shipment implements JSONRepresentation {

    /**
     * Shipment step describing pickup.
     */
    private ShipmentStep pickup;
    /**
     * Shipment step describing the delivery.
     */
    private ShipmentStep delivery;
    /**
     * Array of quantities to be picked up and delivered.
     */
    private List<Integer> amount;
    /**
     * List of skills required.
     */
    private List<Integer> skills;
    /**
     * Priority of [0,10] of the shipment.
     */
    private Integer priority;

    public Shipment(ShipmentStep pickup, ShipmentStep delivery, List<Integer> amount, List<Integer> skills, Integer priority) {
        this.pickup = pickup;
        this.delivery = delivery;
        this.amount = amount;
        this.skills = skills;
        this.priority = priority;
    }

    /**
     *
     * @return the JSON representation of the shipment.
     * @throws JSONException if some JSON parsing error happened.
     */
    @Override
    public JSONObject getJSONRepresentation() throws JSONException {
        JSONObject obj = new JSONObject();
        if(amount != null)
            obj.put("amount", UtilityFunctions.getIntegerJSONArray(amount));
        if(pickup != null)
            obj.put("pickup", pickup.getJSONRepresentation());
        if(delivery != null)
            obj.put("delivery", delivery.getJSONRepresentation());
        if(skills != null)
            obj.put("skills", UtilityFunctions.getIntegerJSONArray(skills));
        if(priority != null)
            obj.put("priority", priority.intValue());
        return obj;
    }

    public ShipmentStep getPickup() {
        return pickup;
    }

    public ShipmentStep getDelivery() {
        return delivery;
    }

    public List<Integer> getAmount() {
        return amount;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public Integer getPriority() {
        return priority;
    }
}
