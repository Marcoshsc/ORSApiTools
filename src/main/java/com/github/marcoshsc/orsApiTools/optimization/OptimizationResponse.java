package com.github.marcoshsc.orsApiTools.optimization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Route;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Summary;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Unassigned;
import lombok.Getter;

import java.util.List;

/**
 * Describes a response of the optimization endpoint in the ORS api.
 * https://github.com/VROOM-Project/vroom/blob/master/docs/API.md for more information.
 *
 * @author Marcos Henrique
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptimizationResponse {

    /**
     * Code of the request, to be used in error handling.
     */
    private final Integer code;

    /**
     * Error message (present iff code is different from 0).
     */
    private final String errorMessage;

    /**
     * Object summarizing solution indicators.
     */
    private final Summary summary;

    /**
     * Array of objects describing unassigned jobs with their id and location (if provided).
     */
    private final List<Unassigned> unassigned;

    /**
     * Array of route objects.
     */
    private final List<Route> routes;

    @JsonCreator
    public OptimizationResponse(@JsonProperty(value = "code", required = true) Integer code,
                                @JsonProperty("error") String errorMessage,
                                @JsonProperty("summary") Summary summary,
                                @JsonProperty(value = "unassigned", required = true) List<Unassigned> unassigned,
                                @JsonProperty(value = "routes", required = true) List<Route> routes) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.summary = summary;
        this.unassigned = unassigned;
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "OptimizationResponse{" +
                "code=" + code +
                ", errorMessage='" + errorMessage + '\'' +
                "\n, summary=" + summary +
                "\n, unassigned=" + unassigned +
                "\n, routes=" + routes +
                '}';
    }
}
