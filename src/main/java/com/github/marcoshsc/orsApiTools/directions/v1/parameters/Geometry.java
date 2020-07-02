package com.github.marcoshsc.orsApiTools.directions.v1.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the "geometry" query parameter on the ORS API.
 * Parameter description: Specifies whether to return geometry.
 * Just accepts true or false.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public class Geometry extends BooleanParameter {
	
	private final String name = ORSEnum.GEOMETRY_PARAM.toString();

	public Geometry(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
