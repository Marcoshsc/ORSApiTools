package com.github.marcoshsc.orsApiTools.optimization.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Array of vehicle objects describing the available vehicles. For a detailed object description visit the VROOM API description.
 * https://github.com/VROOM-Project/vroom/blob/master/docs/API.md#vehicles
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Vehicles {

    /**
     * List of vehicles available.
     */
    @JsonValue
    private List<Vehicle> vehicles;

}
