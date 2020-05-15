package com.github.marcoshsc.orsApiTools.interfaces;

import java.util.List;

/**
 * 
 * Contract that must be implemented by all "parameter set" classes.
 * 
 * @author Marcos Henrique Santos Cunha in 21-03-2020
 *
 */
public interface ParameterList {
	
	/**
	 * 
	 * @return a list of all not-null fields on the object.
	 */
	List<QueryParameter<?>> getUsedParameters();
	
}
