package com.github.marcoshsc.orsApiTools.directions.v1.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the "maneuvers" query parameter on the ORS API.
 * Parameter description: Specifies whether the maneuver object is included 
 * into the step object or not.
 * 
 * The value can be either true or false.
 * The default value is false.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class Maneuvers extends BooleanParameter {
	
	private final String name = ORSEnum.MANEUVERS_PARAM.toString();

	public Maneuvers(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
