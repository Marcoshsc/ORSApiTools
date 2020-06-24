package com.github.marcoshsc.orsApiTools.matrix.v1.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.BooleanParameter;

/**
 * 
 * References the resolve_locations query parameter on the ORS API.
 * 
 * Parameter description: Specifies whether given locations are resolved or not. 
 * If the parameter value set to true, every element in destinations and sources will 
 * contain the name element that identifies the name of the closest street.
 * 
 * The default value is false.
 * 
 * @author Marcos Henrique Santos Cunha in 16-03-2020
 *
 */
public class ResolveLocations extends BooleanParameter {
	
	private final String name = ORSEnum.RESOLVE_LOCATIONS_PARAM.toString();

	public ResolveLocations(Boolean value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
