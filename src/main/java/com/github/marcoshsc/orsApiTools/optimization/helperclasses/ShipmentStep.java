package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoshsc.orsApiTools.json.serializers.CoordinateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * Describes a shipment step. A shipment step is either delivery or shipment, and describe how it is going to be made.
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ShipmentStep {

    /**
     * Unique identifier
     */
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    /**
     * Location where the shipment step will be made.
     */
    @JsonProperty("location")
    @JsonSerialize(using = CoordinateSerializer.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Coordinate location;

    /**
     * Index of the location in the matrix. Just works if a durations matrix was passed in the parameters.
     */
    @JsonProperty("location_index")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer locationIndex;

    /**
     * Total time spent in the step.
     */
    @JsonProperty("service")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer service;

    /**
     * List of periods of time that the step can be started.
     */
    @JsonProperty("time_windows")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TimeWindow> timeWindows;

}
