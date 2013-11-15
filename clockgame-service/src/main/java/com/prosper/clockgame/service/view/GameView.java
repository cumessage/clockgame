package com.prosper.clockgame.service.view;

import com.prosper.clockgame.service.bean.Game;

public class GameView extends View {
	
	private long id;
	
	private String CreatorName;
	
	private long playTime;
	
	private long createTime; 
	
	private int templateId;

	public GameView(Game game) {
		this.setCreatorName(game.getCreator().getName());
		this.setPlayTime(game.getPlayTime());
		this.setCreateTime(game.getCreateTime());
		this.setId(game.getId());
		this.setTemplateId(game.getTemplate().getId());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPlayTime() {
		return playTime;
	}

	public void setPlayTime(long playTime) {
		this.playTime = playTime;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public int getTemplateId() {
		return templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

	public String getCreatorName() {
		return CreatorName;
	}

	public void setCreatorName(String creatorName) {
		CreatorName = creatorName;
	}
	
}
