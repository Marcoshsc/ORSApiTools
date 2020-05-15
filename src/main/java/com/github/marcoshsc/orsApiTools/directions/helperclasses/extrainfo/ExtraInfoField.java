package com.github.marcoshsc.orsApiTools.directions.helperclasses.extrainfo;

import java.util.List;

/**
 * Every fields contained in a extra_info field.
 *
 * @author Marcos Henrique
 */
public class ExtraInfoField {
    /**
     * Broken down by way_points.
     */
    private List<ExtraInfoValues> values;
    /**
     * Broken down by information category values.
     */
    private List<ExtraInfoSummary> summary;

    public ExtraInfoField(List<ExtraInfoValues> values, List<ExtraInfoSummary> summary) {
        this.values = values;
        this.summary = summary;
    }

    public List<ExtraInfoValues> getValues() {
        return values;
    }

    public List<ExtraInfoSummary> getSummary() {
        return summary;
    }
}
