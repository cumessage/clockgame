package com.prosper.clockgame.service.view;

import com.prosper.clockgame.service.bean.User;

public class UserView extends View {

	private User user;
	
	public UserView(User user) {
		super();
		setUser(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
