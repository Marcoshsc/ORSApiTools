package com.github.marcoshsc.orsApiTools.directions.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the "continue_straight" query parameter on the ORS API.
 * 
 * Parameter description: Forces the route to keep going straight at 
 * waypoints restricting uturns there even if it would be faster. This 
 * setting will work for all profiles except for driving-*. In this case 
 * you will have to set optimized=false for it to work.
 * 
 * The value can be either true or false.
 * The default value is false.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class ContinueStraight extends BooleanParameter {
	
	private final String name = ORSEnum.CONTINUE_STRAIGHT_PARAM.toString();

	public ContinueStraight(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
