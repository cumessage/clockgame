package com.prosper.clockgame.service.bean;

public class FriendPair {

	/**
	 * 0 为申请状态
	 */
	public static final short UNCHECKED = 0;
	/**
	 * 1 为通过状态
	 */
	public static final short CHECKED = 1;
	
	private long userid;
	
	private long friendId;
	
	private short status;
	
	public FriendPair(long userId, long friendId) {
		setUserid(userId);
		setFriendId(friendId);
		setStatus(UNCHECKED);
	}

	public void setChecked() {
		setStatus(CHECKED);
	}
	
	public void setUnChecked() {
		setStatus(UNCHECKED);
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getFriendId() {
		return friendId;
	}

	public void setFriendId(long friendId) {
		this.friendId = friendId;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}
	
}
