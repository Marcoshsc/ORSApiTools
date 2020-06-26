package com.github.marcoshsc.orsApiTools.optimization.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Optional two-dimensional array describing a custom matrix
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class OptimizationMatrix {

    /**
     * Quadratic matrix of durations
     */
    @JsonValue
    List<List<Integer>> durations;

}
