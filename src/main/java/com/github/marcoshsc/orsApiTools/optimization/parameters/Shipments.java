package com.github.marcoshsc.orsApiTools.optimization.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Shipment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Array of shipment objects describing pickup and delivery tasks
 * https://github.com/VROOM-Project/vroom/blob/master/docs/API.md#shipments
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Shipments {

    /**
     * List of shipments to be made.
     */
    @JsonValue
    private List<Shipment> shipments;

}
