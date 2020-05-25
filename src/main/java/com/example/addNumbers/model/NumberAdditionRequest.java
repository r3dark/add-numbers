package com.example.addNumbers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class NumberAdditionRequest {

	@JsonProperty("number1")
	private Long number1;

	@JsonProperty("number2")
	private Long number2;

	public Long getNumber1() {
		return number1;
	}

	public void setNumber1(Long number1) {
		this.number1 = number1;
	}

	public Long getNumber2() {
		return number2;
	}

	public void setNumber2(Long number2) {
		this.number2 = number2;
	}

	@Override
	public String toString() {
		return "NumberAdditionRequest{" +
				"number1='" + number1 + '\'' +
				", number2='" + number2 + '\'' +
				'}';
	}
}
