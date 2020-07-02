package com.github.marcoshsc.orsApiTools.directions.v1.parameters;

import com.github.marcoshsc.orsApiTools.directions.enums.ExtraInfoEnum;
import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.interfaces.QueryParameter;
import com.github.marcoshsc.orsApiTools.utils.UtilityFunctions;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * References the "extra_info" query parameter on the ORS API.
 * Parameter description: Pipe (|) separated List of additional information.
 * To this class, is only needed to pass an array of attributes to the constructor.
 * Makes use of ExtraInfoEnum to map all the possible values.
 * 
 * There is no default value, hence there are only parameterized constructors.
 * 
 * @see ExtraInfoEnum to see all the possible values.
 * 
 * @author Marcos Henrique Santos Cunha in 11-03-2020
 *
 */
public class ExtraInfo implements QueryParameter<List<ExtraInfoEnum>> {
	
	private final String name = ORSEnum.EXTRAINFO_PARAM.toString();
	
	private List<ExtraInfoEnum> value;

	public ExtraInfo(ExtraInfoEnum value) {
		this.value = new ArrayList<>();
		this.value.add(value);
	}
	
	public ExtraInfo(List<ExtraInfoEnum> value) {
		super();
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return UtilityFunctions.groupByPipe(value);
	}

	@Override
	public List<ExtraInfoEnum> getTypedValue() {
		return value;
	}

}
