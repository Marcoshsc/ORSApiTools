package com.github.marcoshsc.orsApiTools.directions.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the "suppress_warnings" query parameter on the ORS API.
 * 
 * Parameter description: Tells the system to not return any warning messages and 
 * corresponding extra_info. For false the extra information can still be explicitly 
 * requested by adding it with the extra_info parameter.
 * 
 * The value can be either true or false.
 * The default value is false.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class SuppressWarnings extends BooleanParameter {
	
	private final String name = ORSEnum.SUPPRESS_WARNINGS_PARAM.toString();

	public SuppressWarnings(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
