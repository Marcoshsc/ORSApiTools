package com.github.marcoshsc.orsApiTools.directions.v1.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the "instructions" query parameter on the ORS API.
 * Parameter description: Specifies whether to return instructions.
 * 
 * The value can be either true or false.
 * The default value is true.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class Instructions extends BooleanParameter {
	
	private final String name = ORSEnum.INSTRUCTIONS_PARAM.toString();

	public Instructions(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
