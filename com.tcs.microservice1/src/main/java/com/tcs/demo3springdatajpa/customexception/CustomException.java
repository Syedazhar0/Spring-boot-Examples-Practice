package com.tcs.demo3springdatajpa.customexception;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomException() {
		super("Resource not found ");
	}
	
	public CustomException(String message) {
		super(message);
	
	}
}
