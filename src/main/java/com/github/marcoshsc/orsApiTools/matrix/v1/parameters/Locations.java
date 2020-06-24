package com.github.marcoshsc.orsApiTools.matrix.v1.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.CoordinateListParameter;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;

/**
 * 
 * Class for definition of the locations query param, used in GET requests to the ORS API.
 * 
 * Stores a list of coordinates and returns its value, as defined in the ORS API Docs:
 * Pipe (|) separated List of longitude,latitude coordinates.
 * 
 * There is no default value for this parameter.
 * 
 * @author Marcos Henrique Santos Cunha in 15-03-2020
 *
 */
public class Locations extends CoordinateListParameter {
	
	private final String name = ORSEnum.LOCATIONS_PARAM.toString();

	public Locations(List<Coordinate> value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
