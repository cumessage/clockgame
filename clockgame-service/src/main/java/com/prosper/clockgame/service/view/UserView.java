package com.prosper.clockgame.service.view;

import com.prosper.clockgame.service.bean.User;

public class UserView extends View {
	
	private String email;
	
	private String name;
	
	private long createTime;
	
	private long lastLogin;

	public UserView(User user) {
		this.setEmail(user.getEmail());
		this.setName(user.getName());
		this.setCreateTime(user.getCreateTime());
		this.setLastLogin(user.getLastLogin());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}
}
