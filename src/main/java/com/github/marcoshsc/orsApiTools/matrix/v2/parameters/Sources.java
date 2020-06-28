package com.github.marcoshsc.orsApiTools.matrix.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * A list of indices that refers to the list of locations (starting with 0). {index_1},{index_2}[,{index_N} ...]
 * or all (default). example [0,3] for the first and fourth locations
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Sources {

    @JsonValue
    private final List<Integer> sources;

}
