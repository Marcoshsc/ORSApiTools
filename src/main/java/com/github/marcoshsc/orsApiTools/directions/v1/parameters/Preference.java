package com.github.marcoshsc.orsApiTools.directions.v1.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.PreferenceEnum;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.EnumParameter;

/**
 * 
 * References the "preference" query parameter, used on GET requests to the ORS API.
 * The parameter is described as in the ORS API Documentation below:
 * 	"Specifies the route preference."
 * 
 * Makes use of PreferenceEnum to map the possible values.
 * 
 * @see PreferenceEnum to see the possible values.
 * 
 * The default value is "fastest"
 * 
 * @author Marcos Henrique Santos Cunha in March 11th, 2020
 *
 */
public class Preference extends EnumParameter<PreferenceEnum> {
	
	private final String name = ORSEnum.PREFERENCE_PARAM.toString();

	public Preference(PreferenceEnum value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
