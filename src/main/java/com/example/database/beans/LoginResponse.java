package com.example.database.beans;

public class LoginResponse {
	private int userId;
	private boolean result;
	
	public LoginResponse() {
	}
	
	public LoginResponse(int userId, boolean result) {
		super();
		this.userId = userId;
		this.result = result;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
