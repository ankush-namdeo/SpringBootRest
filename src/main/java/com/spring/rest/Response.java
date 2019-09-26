package com.spring.rest;

public class Response {
	
	public String message;
	public String error;
	
	
	public Response() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}
