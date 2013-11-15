package com.prosper.clockgame.service.bean;

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
	 * 参与者及对应参与时间表
	 */
	private Map<User, Long> member;
	
	public boolean joinable() {
		if (member.size() < template.getLimit()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isJoined(long userId) {
		for (User user: member.keySet()) {
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

	public Map<User, Long> getMember() {
		return member;
	}

	public void setMember(Map<User, Long> member) {
		this.member = member;
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

	
	
}
