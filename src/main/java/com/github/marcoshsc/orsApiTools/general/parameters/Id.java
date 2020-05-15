package com.github.marcoshsc.orsApiTools.general.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.StringParameter;

/**
 * 
 * Defines the "id" query param on the ORS API.
 * Parameter definition: Arbitrary identification string of the request reflected in the meta information.
 * 
 * There is no default value, the string must be passed to the constructor.
 * 
 * @author Marcos Henrique Santos Cunha in 13-03-2020
 *
 */
public class Id extends StringParameter {
	
	private final String name = ORSEnum.ID_PARAM.toString();

	public Id(String value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
