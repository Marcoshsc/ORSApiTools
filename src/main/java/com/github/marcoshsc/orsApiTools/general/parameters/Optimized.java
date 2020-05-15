package com.github.marcoshsc.orsApiTools.general.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the "optimized" query parameter on the ORS API.
 * Parameter description: Uses contraction hierarchies if available.
 * 
 * The value can be either true or false.
 * The default value is true.
 * 
 * @author Marcos Henrique Santos Cunha in 12-03-2020
 *
 */
public class Optimized extends BooleanParameter {
	
	private final String name = ORSEnum.OPTIMIZED_PARAM.toString();

	public Optimized(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
