package com.github.marcoshsc.orsApiTools.directions.v1.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the "geometry_simplify" query parameter on the ORS API.
 * Parameter description: Specifies whether to simplify the geometry.
 * This cannot be set to true when ExtraInfo has been requested, 
 * or on routes with more than one segment (more than two coordinates)
 * 
 * The value can be either true or false.
 * The default value is false.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class GeometrySimplify extends BooleanParameter {
	
	private final String name = ORSEnum.GEOMETRY_SIMPLIFY_PARAM.toString();

	public GeometrySimplify(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
