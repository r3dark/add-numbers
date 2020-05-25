package com.example.addNumbers.model;

import org.springframework.stereotype.Component;

@Component
public class NumberAdditionResponse {

	private Long sum;

	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "NumberAdditionResponse{" +
				"sum=" + sum +
				'}';
	}
}
