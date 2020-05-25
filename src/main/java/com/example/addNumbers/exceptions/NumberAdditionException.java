package com.example.addNumbers.exceptions;

public class NumberAdditionException extends Exception {

	private String message;

	private int code;

	public NumberAdditionException(String errorMessage, int errorCode) {
		this.message = errorMessage;
		this.code = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
