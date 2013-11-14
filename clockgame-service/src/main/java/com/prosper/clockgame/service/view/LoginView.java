package com.prosper.clockgame.service.view;

public class LoginView extends View{
	
	private long userId;
	
	public LoginView(long userId) {
		setUserId(userId);
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}
