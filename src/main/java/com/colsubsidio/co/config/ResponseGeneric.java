package com.colsubsidio.co.config;

public class ResponseGeneric {

	private boolean status;
	
	private String message;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseGeneric [status=" + status + ", message=" + message + "]";
	}
	
	
}
