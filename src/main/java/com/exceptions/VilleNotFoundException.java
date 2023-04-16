package com.exceptions;

public class VilleNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public VilleNotFoundException(String message) {
        super(message);
    }
}
