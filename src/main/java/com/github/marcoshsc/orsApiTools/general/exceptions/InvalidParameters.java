package com.github.marcoshsc.orsApiTools.general.exceptions;

/**
 * Used when there is a error with the parameters of a request.
 *
 * Created By Marcos Henrique in 28-04-2020
 */
public class InvalidParameters extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

    public InvalidParameters(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Error: Invalid Parameters passed. Message: " + message;
    }
}
