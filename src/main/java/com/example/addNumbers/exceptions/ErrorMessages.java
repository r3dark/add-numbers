package com.example.addNumbers.exceptions;

public enum ErrorMessages {

	INVALID_REQUEST_ERROR_MESSAGE ("Invalid request. Less than two numbers provided or one of the number is null."),
	REQUEST_BODY_MISSING ("Required request body is missing"),
	INTERNAL_SERVER_ERROR ("Internal server error.");

	private final String message;

	ErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
