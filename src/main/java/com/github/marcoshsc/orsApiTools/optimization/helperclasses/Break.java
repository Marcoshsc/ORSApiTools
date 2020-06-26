package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Describes a break of a vehicle.
 *
 * @author Marcos Henrique
 */
@Getter
@AllArgsConstructor
public class Break {

    /**
     * Unique identifier
     */
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer id;

    /**
     * Periods of time that the break can be started.
     */
    @JsonProperty("time_windows")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<TimeWindow> timeWindows;

    /**
     * Total time spent in the break.
     */
    @JsonProperty("service")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer service;

}
