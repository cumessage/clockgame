package com.prosper.clockgame.service.bean;

import java.util.List;
import java.util.Map;

public class Game {
	
	/**
	 * 标示id 
	 */
	private long id;
	
	/**
	 * 开始时间
	 */
	private long playTime;
	
	/**
	 * 创建者
	 */
	private User creator;
	
	/**
	 * 创建时间
	 */
	private long createTime;
	
	/**
	 * 游戏模板
	 */
	private GameTemplate template;
	
	/**
	 * 参与者
	 */
	private List<User> memberList;
	
	public boolean joinable() {
		if (getMemberList().size() < template.getLimit()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isJoined(long userId) {
		for (User user: getMemberList()) {
			if (user.getId() == userId) {
				return true;
			}
		}
		return false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public GameTemplate getTemplate() {
		return template;
	}

	public void setTemplate(GameTemplate template) {
		this.template = template;
	}

	public long getPlayTime() {
		return playTime;
	}

	public void setPlayTime(long playTime) {
		this.playTime = playTime;
	}

	public List<User> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<User> memberList) {
		this.memberList = memberList;
	}

	
	
}
