package com.prosper.clockgame.service.bean;

public class gameMember {
	
	private User member;
	
	private long createtime;

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}

	public long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}
	
}
