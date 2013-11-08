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
	private long playtime;
	
	/**
	 * 参与时间
	 */
	private Long createTime;
	
	/**
	 * 游戏模板
	 */
	private GameTemplate template;
	
	/**
	 * 创建者id
	 */
	private User creator;
	
	/**
	 * 参与者及对应参与时间表
	 */
	private Map<User, Long> member;

	/**
	 * 检查当前游戏是否能再加入成员
	 */
	public boolean joinable() {
		if (getTemplate().getLimit() > member.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPlaytime() {
		return playtime;
	}

	public void setPlaytime(long playtime) {
		this.playtime = playtime;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Map<User, Long> getMember() {
		return member;
	}

	public void setMember(Map<User, Long> member) {
		this.member = member;
	}

	public GameTemplate getTemplate() {
		return template;
	}

	public void setTemplate(GameTemplate template) {
		this.template = template;
	}
	
}
