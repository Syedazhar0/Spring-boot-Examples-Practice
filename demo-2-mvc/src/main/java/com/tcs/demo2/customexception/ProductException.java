package com.tcs.demo2.customexception;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductException(String message) {
        super(message);
    }
}
