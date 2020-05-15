package com.github.marcoshsc.orsApiTools.interfaces;

/**
 * 
 * Contract that must be implemented by every query parameter representation class.
 * 
 * @author Marcos Henrique Santos Cunha in 21-03-2020
 *
 */
public interface QueryParameter<T> {
	
	/**
	 * 
	 * @return the name of the parameter.
	 */
	String getName();
	
	/**
	 * 
	 * @return the value of the parameter.
	 */
	String getValue();

	/**
	 *
	 * @return the Typed value stored in the class.
	 */
	T getTypedValue();
	
}
