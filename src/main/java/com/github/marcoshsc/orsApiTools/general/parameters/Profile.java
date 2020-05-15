package com.github.marcoshsc.orsApiTools.general.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.EnumParameter;

/**
 * 
 * Reference to the "profile" query parameter in the ORS API. Makes use of EnumProfile to map the values.
 * @see EnumProfile to see value mappings there are all the possible values.
 * 
 * There is no default value, hence there is only parameterized constructors.
 * 
 * @author Marcos Henrique Santos Cunha in March 11th, 2020
 *
 */
public class Profile extends EnumParameter<EnumProfile> {

	private final String name = ORSEnum.PROFILE_PARAM.toString();
	
	public Profile(EnumProfile value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
