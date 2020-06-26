package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Describes a shipment object. A shipment has an amount of quantities to be picked up in a point, and to be delivered
 * in another point.
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Shipment {

    /**
     * Shipment step describing pickup.
     */
    @JsonProperty("pickup")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ShipmentStep pickup;

    /**
     * Shipment step describing the delivery.
     */
    @JsonProperty("delivery")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ShipmentStep delivery;

    /**
     * Array of quantities to be picked up and delivered.
     */
    @JsonProperty("amount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Integer> amount;

    /**
     * List of skills required.
     */
    @JsonProperty("skills")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Integer> skills;

    /**
     * Priority of [0,10] of the shipment.
     */
    @JsonProperty("priority")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer priority;

}
