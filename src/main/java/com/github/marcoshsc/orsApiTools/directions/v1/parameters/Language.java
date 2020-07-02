package com.github.marcoshsc.orsApiTools.directions.v1.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.LanguageEnum;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.EnumParameter;

/**
 * 
 * References the "language" query parameter on the ORS API.
 * Parameter description: Language for the route instructions.
 * Makes use of LanguageEnum to map all the possible values.
 * 
 * The default value is "en" (English).
 * 
 * @see LanguageEnum to understand all the possible values.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public class Language extends EnumParameter<LanguageEnum> {
	
	private final String name = ORSEnum.LANGUAGE_PARAM.toString();

	public Language(LanguageEnum value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
