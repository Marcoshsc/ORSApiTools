package com.github.marcoshsc.orsApiTools.optimization;

import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Route;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Summary;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Unassigned;

import java.util.List;

/**
 * Describes a response of the optimization endpoint in the ORS api.
 * https://github.com/VROOM-Project/vroom/blob/master/docs/API.md for more information.
 *
 * @author Marcos Henrique
 */
public class OptimizationResponse {

    /**
     * Code of the request, to be used in error handling.
     */
    private int code;
    /**
     * Error message (present iff code is different from 0).
     */
    private String errorMessage;
    /**
     * Object summarizing solution indicators.
     */
    private Summary summary;
    /**
     * Array of objects describing unassigned jobs with their id and location (if provided).
     */
    private List<Unassigned> unassigned;
    /**
     * Array of route objects.
     */
    private List<Route> routes;

    public OptimizationResponse(int code, String errorMessage, Summary summary, List<Unassigned> unassigned,
                                List<Route> routes) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.summary = summary;
        this.unassigned = unassigned;
        this.routes = routes;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Summary getSummary() {
        return summary;
    }

    public List<Unassigned> getUnassigned() {
        return unassigned;
    }

    public List<Route> getRoutes() {
        return routes;
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
