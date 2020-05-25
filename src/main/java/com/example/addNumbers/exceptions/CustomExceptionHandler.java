package com.example.addNumbers.exceptions;

import com.example.addNumbers.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler (NumberAdditionBadRequestException.class)
	public ResponseEntity<ErrorResponse> handleInvalidRequestException(NumberAdditionBadRequestException e) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler (Exception.class)
	public ResponseEntity<ErrorResponse> handleEmptyRequestException(Exception e) {

		ErrorResponse errorResponse = new ErrorResponse();
		if (e.getMessage().contains(ErrorMessages.REQUEST_BODY_MISSING.getMessage())) {
			errorResponse.setMessage(ErrorMessages.REQUEST_BODY_MISSING.getMessage());
		} else {
			errorResponse.setMessage(ErrorMessages.INTERNAL_SERVER_ERROR.getMessage());
		}
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
