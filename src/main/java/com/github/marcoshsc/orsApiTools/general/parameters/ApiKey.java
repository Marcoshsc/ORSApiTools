package com.github.marcoshsc.orsApiTools.general.parameters;

import com.github.marcoshsc.orsApiTools.general.enums.ORSEnum;
import com.github.marcoshsc.orsApiTools.general.superclasses.StringParameter;

/**
 * 
 * Class for definition of the API key query parameter, used for authentication of GET requests to the
 * Open Route Service API (ORS). To instanciate this class, there must be provided an API key value, since 
 * there is no default value.
 * 
 * @author Marcos Henrique Santos Cunha
 *
 */
public class ApiKey extends StringParameter {
	
	private final String name = ORSEnum.API_KEY_PARAM.toString();
	
	/**
	 * 
	 * @param value: the API key to be used
	 * 
	 */
	public ApiKey(String value) {
		super(value);
	}
	
	@Override
	public String getName() {
		return name;
	}

}
