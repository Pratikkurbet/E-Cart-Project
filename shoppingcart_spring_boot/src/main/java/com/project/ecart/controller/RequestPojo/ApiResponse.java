package com.project.ecart.controller.RequestPojo;

import java.util.Arrays;
import java.util.List;

public class ApiResponse {
	private String message;
	private List<String> errors;

	public ApiResponse(String message, List<String> errors) {
		super();
		this.message = message;
		this.errors = errors;
	}

	public ApiResponse(String message, String error) {
		super();
		this.message = message;
		errors = Arrays.asList(error);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
