package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Describes an computing time object, present in a summary of a optimization request.
 *
 * @author Marcos Henrique
 */
@Getter
public class ComputingTime {

    /**
     * Time spent to load the data.
     */
    private final int loading;

    /**
     * Time spent making the solution.
     */
    private final int solving;

    @JsonCreator
    public ComputingTime(@JsonProperty("loading") int loading,
                         @JsonProperty("solving") int solving) {
        this.loading = loading;
        this.solving = solving;
    }

    @Override
    public String toString() {
        return "ComputingTime{" +
                "loading=" + loading +
                ", solving=" + solving +
                '}';
    }

}
