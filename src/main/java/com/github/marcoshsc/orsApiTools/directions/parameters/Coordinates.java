package com.github.marcoshsc.orsApiTools.directions.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.CoordinateListParameter;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * 
 * Class for definition of the coordinates query param, used in GET requests to the ORS API.
 * 
 * Stores a list of coordinates and returns its value, as defined in the ORS API Docs:
 * Pipe (|) separated List of longitude,latitude coordinates visited in order.
 * 
 * There is no default value for this parameter.
 * 
 * @author Marcos Henrique Santos Cunha
 *
 */
public class Coordinates extends CoordinateListParameter {
	
	private final String name = ORSEnum.COORDINATES_PARAM.toString();

	/**
	 * 
	 * @param value: the list of coordinates visited in order.
	 */
	public Coordinates(List<Coordinate> value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
