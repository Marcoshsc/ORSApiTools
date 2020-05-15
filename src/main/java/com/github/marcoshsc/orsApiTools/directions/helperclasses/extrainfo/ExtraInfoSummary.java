package com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo;

/**
 * The summary of an {@link ExtraInfoField}. A summary object describes the values showed in the "values" array.
 *
 * @author Marcos Henrique
 */
public class ExtraInfoSummary {
    /**
     * Value of a info category.
     */
    private double value;
    /**
     * Cumulative distance of this value.
     */
    private double distance;
    /**
     * Category percentage of the entire route.
     */
    private double amount;

    public ExtraInfoSummary(double value, double distance, double amount) {
        this.value = value;
        this.distance = distance;
        this.amount = amount;
    }

    public double getValue() {
        return value;
    }

    public double getDistance() {
        return distance;
    }

    public double getAmount() {
        return amount;
    }
}
