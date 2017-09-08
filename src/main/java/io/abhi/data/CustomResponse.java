package io.abhi.data;

public class CustomResponse {

	private String message;

	public CustomResponse() {

	}

	public CustomResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
