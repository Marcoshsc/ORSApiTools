package com.github.marcoshsc.orsApiTools.directions.v1.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the "elevation" query parameter on the ORS API.
 * 
 * Parameter description: Specifies whether to return elevation values for 
 * points. Please note that elevation also gets encoded for geometry_format=encodedpolyline.
 * 
 * The value can be either true or false.
 * The default value is false.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class Elevation extends BooleanParameter {
	
	private final String name = ORSEnum.ELEVATION_PARAM.toString();

	public Elevation(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
