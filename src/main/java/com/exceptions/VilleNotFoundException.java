package com.exceptions;

public class VilleNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public VilleNotFoundException(String message) {
        super(message);
    }
}
