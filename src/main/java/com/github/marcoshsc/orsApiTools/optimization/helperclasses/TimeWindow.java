package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

/**
 * A time_window object is a pair of timestamps in the form [start, end];
 *
 * @author Marcos Henrique
 */
public class TimeWindow {

    /**
     * Start point in seconds.
     */
    int start;
    /**
     * End point in seconds.
     */
    int end;

    public TimeWindow(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
