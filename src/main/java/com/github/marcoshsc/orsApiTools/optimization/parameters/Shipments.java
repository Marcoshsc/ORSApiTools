package com.github.marcoshsc.orsApiTools.optimization.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.JSONBodyParameter;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Shipment;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;

/**
 * Array of shipment objects describing pickup and delivery tasks
 * https://github.com/VROOM-Project/vroom/blob/master/docs/API.md#shipments
 *
 * @author Marcos Henrique
 */
public class Shipments implements JSONBodyParameter<JSONArray> {

    private static final String name = ORSEnum.SHIPMENTS_BODY_PARAM.toString();
    /**
     * List of shipments to be made.
     */
    private List<Shipment> shipments;

    public Shipments(List<Shipment> shipments) {
        this.shipments = shipments;
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
     * @return an array of shipment objects.
     * @throws JSONException if some JSON parsing exception happened.
     */
    @Override
    public JSONArray getValue() throws JSONException {
        return getShipmentJSONArray(shipments);
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    private JSONArray getShipmentJSONArray(List<Shipment> shipments) throws JSONException {
        JSONArray array = new JSONArray();
        for(Shipment shipment : shipments)
            array.put(shipment.getJSONRepresentation());
        return array;
    }

}
