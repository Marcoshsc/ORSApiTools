package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoshsc.orsApiTools.json.serializers.TimeWindowSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A time_window object is a pair of timestamps in the form [start, end];
 *
 * @author Marcos Henrique
 */
@Getter
@AllArgsConstructor
@JsonSerialize(using = TimeWindowSerializer.class)
public class TimeWindow {

    /**
     * Start point in seconds.
     */
    private final int start;

    /**
     * End point in seconds.
     */
    private final int end;

}
