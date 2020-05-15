package com.github.marcoshsc.orsApiTools.general.superclasses;

import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

public abstract class CoordinateListParameter implements QueryParameter<List<Coordinate>> {

    private List<Coordinate> value;

    public CoordinateListParameter(List<Coordinate> value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return UtilityFunctions.groupCoordinateListORSStyle(value);
    }

    @Override
    public List<Coordinate> getTypedValue() {
        return value;
    }
}
