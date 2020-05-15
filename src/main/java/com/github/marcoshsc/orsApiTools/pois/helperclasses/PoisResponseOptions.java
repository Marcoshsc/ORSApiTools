package com.github.marcoshsc.orsApiTools.pois.helperclasses;

import com.github.marcoshsc.orsApiTools.geocode.helperclasses.BoundingBox;
import com.github.marcoshsc.orsApiTools.pois.enums.FiltersEnum;
import com.github.marcoshsc.orsApiTools.pois.enums.PoisRequestEnum;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;
import java.util.Map;

/**
 * Represent the response options, which are the request values passed to make the response. Buffer will be 0 if not
 * encountered, and just the request field is guaranteed to be not null.
 *
 * @author Marcos Henrique
 */
public class PoisResponseOptions {

    /**
     * Type of the request passed.
     */
    private PoisRequestEnum request;
    /**
     * Filters used in the request, if available
     */
    private Map<FiltersEnum, List<String>> filters;
    /**
     * Bounding box of results, used in the request, if available.
     */
    private BoundingBox boundingBox;
    /**
     * Coordinate used in the request
     */
    private Coordinate coordinate;
    /**
     * Buffer size used in the request.
     */
    private int buffer;

    public PoisResponseOptions(PoisRequestEnum request, Map<FiltersEnum, List<String>> filters, BoundingBox boundingBox, Coordinate coordinate, int buffer) {
        this.request = request;
        this.filters = filters;
        this.boundingBox = boundingBox;
        this.coordinate = coordinate;
        this.buffer = buffer;
    }

    public PoisRequestEnum getRequest() {
        return request;
    }

    public Map<FiltersEnum, List<String>> getFilters() {
        return filters;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getBuffer() {
        return buffer;
    }

    @Override
    public String toString() {
        return "PoisResponseOptions{" +
                "request=" + request +
                ", filters=" + filters +
                ", boundingBox=" + boundingBox +
                ", coordinate=" + coordinate +
                ", buffer=" + buffer +
                "}\n";
    }
}
