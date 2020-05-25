package com.example.addNumbers.exceptions;

public class NumberAdditionBadRequestException extends NumberAdditionException {

	public NumberAdditionBadRequestException(String errorMessage, int errorCode) {
		super(errorMessage, errorCode);
	}
}
