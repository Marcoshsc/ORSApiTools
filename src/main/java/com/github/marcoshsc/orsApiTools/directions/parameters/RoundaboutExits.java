package com.github.marcoshsc.orsApiTools.directions.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the "roundabout_exits" query parameter on the ORS API.
 * Parameter description: Provides bearings of the entrance and all passed roundabout exits. 
 * Adds the exit_bearings array to the step object in the response.
 * 
 * The value can be either true or false.
 * The default value is false.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class RoundaboutExits extends BooleanParameter {
	
	private final String name = ORSEnum.ROUNDABOUT_EXISTS_PARAM.toString();

	public RoundaboutExits(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
