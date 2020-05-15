package com.github.marcoshsc.orsApiTools.general.exceptions;

/**
 * 
 * This exception must be thrown in every request fail/error. Additional information must be passed to 
 * constructor's parameter.
 * 
 * @author Marcos Henrique Santos Cunha in 23-03-2020
 *
 */
public class RequestException extends Exception {

	private static final String initialMessage = "There was an error with the request. Error log: ";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RequestException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return initialMessage +
				super.getMessage();
	}
	
}
