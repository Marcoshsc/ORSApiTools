package com.github.marcoshsc.orsApiTools.optimization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.marcoshsc.orsApiTools.optimization.parameters.Jobs;
import com.github.marcoshsc.orsApiTools.optimization.parameters.OptimizationMatrix;
import com.github.marcoshsc.orsApiTools.optimization.parameters.Shipments;
import com.github.marcoshsc.orsApiTools.optimization.parameters.Vehicles;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A set of parameters that compose a optimization request.
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
public class OptimizationParameters {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("jobs")
    private Jobs jobs;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("matrix")
    private OptimizationMatrix matrix;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("shipments")
    private Shipments shipments;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("vehicles")
    private Vehicles vehicles;

}
