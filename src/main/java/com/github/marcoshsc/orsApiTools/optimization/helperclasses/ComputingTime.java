package com.github.marcoshsc.orsApiTools.optimization.helperclasses;

/**
 * Describes an computing time object, present in a summary of a optimization request.
 *
 * @author Marcos Henrique
 */
public class ComputingTime {
    /**
     * Time spent to load the data.
     */
    private int loading;
    /**
     * Time spent making the solution.
     */
    private int solving;

    public ComputingTime(int loading, int solving) {
        this.loading = loading;
        this.solving = solving;
    }

    public int getLoading() {
        return loading;
    }

    public int getSolving() {
        return solving;
    }

    @Override
    public String toString() {
        return "ComputingTime{" +
                "loading=" + loading +
                ", solving=" + solving +
                '}';
    }
}
