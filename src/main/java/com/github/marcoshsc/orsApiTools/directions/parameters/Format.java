package com.github.marcoshsc.orsApiTools.directions.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.FormatEnum;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.EnumParameter;

/**
 * 
 * References the "format" query param, from the ORS API.
 * This parameter specifies the response format.
 * The class makes use of FormatEnum to map the possible values.
 * 
 * The default value is "json".
 * 
 * @see FormatEnum to have more knowledge about the possible values.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public class Format extends EnumParameter<FormatEnum> {
	
	private final String name = ORSEnum.FORMAT_PARAM.toString();

	public Format(FormatEnum value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}

}
