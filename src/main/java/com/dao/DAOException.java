package com.dao;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Exception e) {
		super(message, e);
	}
}