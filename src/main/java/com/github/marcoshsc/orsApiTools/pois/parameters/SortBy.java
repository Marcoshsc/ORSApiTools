package com.github.marcoshsc.orsApiTools.pois.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.pois.enums.SortByEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Either you can sort by category or the distance to the geometry object provided in the request.
 * In this moment of time sorting by category was not working, so it is disabled.
 * Results are sorted from the smallest to the biggest distance, if it was the sorting value selected.
 *
 * @author Marcos Henrique
 */
@Getter
@ToString
@AllArgsConstructor
public class SortBy {

    /**
     * Sorting strategy.
     */
    @JsonValue
    private final SortByEnum value;

}
