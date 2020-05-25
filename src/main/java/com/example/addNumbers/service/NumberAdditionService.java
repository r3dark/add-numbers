package com.example.addNumbers.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import com.example.addNumbers.exceptions.ErrorMessages;
import com.example.addNumbers.exceptions.NumberAdditionBadRequestException;
import com.example.addNumbers.model.NumberAdditionRequest;
import com.example.addNumbers.model.NumberAdditionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NumberAdditionService {

	@Autowired
	NumberAdditionRequest numberAdditionRequest;

	@Autowired
	NumberAdditionResponse numberAdditionResponse;

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public String addNumbers (String requestBody) throws Exception {

		try {
			numberAdditionRequest = objectMapper.readValue(requestBody, NumberAdditionRequest.class);

			if (numberAdditionRequest.getNumber1() == null || numberAdditionRequest.getNumber2() == null) {
				throw new NumberAdditionBadRequestException(ErrorMessages.INVALID_REQUEST_ERROR_MESSAGE.getMessage(), 400);
			}

			Long sum = numberAdditionRequest.getNumber1() + numberAdditionRequest.getNumber2();
			numberAdditionResponse.setSum(sum);
		} catch (Exception e) {
			log.error("Error occurred while adding two numbers.", e);
			throw e;
		}

		return objectMapper.writeValueAsString(numberAdditionResponse);
	}
}
