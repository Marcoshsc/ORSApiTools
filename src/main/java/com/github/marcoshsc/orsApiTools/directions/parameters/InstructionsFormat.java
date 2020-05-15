package com.github.marcoshsc.orsApiTools.directions.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.InstructionsFormatEnum;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.EnumParameter;

/**
 * 
 * References the "instructions_format" query parameter on the ORS API.
 * Makes use of InstructionsFormatEnum to map all the possible values.
 * 
 * The default value is "text".
 * 
 * @see InstructionsFormatEnum to understand all the possible values.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public class InstructionsFormat extends EnumParameter<InstructionsFormatEnum> {
	
	private final String name = ORSEnum.INSTRUCTIONS_FORMAT_PARAM.toString();

	public InstructionsFormat(InstructionsFormatEnum value) {
		super(value);
	}

	@Override
	public String getName() {
		return name;
	}


}
