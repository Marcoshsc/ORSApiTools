package com.github.marcoshsc.orsApiTools.optimization.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.optimization.helperclasses.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Array of job objects describing the places to visit. For a detailed object description visit the VROOM api description
 * https://github.com/VROOM-Project/vroom/blob/master/docs/API.md#jobs
 *
 * @author Marcos Henrique
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Jobs {

    /**
     * List of jobs to be made
     */
    @JsonValue
    private List<Job> jobs;

}
