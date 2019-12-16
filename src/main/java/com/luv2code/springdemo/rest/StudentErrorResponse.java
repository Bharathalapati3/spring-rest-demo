package com.luv2code.springdemo.rest;

public class StudentErrorResponse {
	
	private int status;
	private String message;
	private long timeStsmp;
	
	
	public StudentErrorResponse() {
		
	}
	
     public StudentErrorResponse(int status, String message, long timeStsmp) {
		this.status = status;
		this.message = message;
		this.timeStsmp = timeStsmp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStsmp() {
		return timeStsmp;
	}

	public void setTimeStsmp(long timeStsmp) {
		this.timeStsmp = timeStsmp;
	}
     
     
	
	
}
