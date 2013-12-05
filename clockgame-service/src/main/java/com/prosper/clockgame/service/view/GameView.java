package com.prosper.clockgame.service.view;

import java.util.ArrayList;
import java.util.List;

import com.prosper.clockgame.service.bean.Game;
import com.prosper.clockgame.service.bean.User;

public class GameView extends View {
	
	private long id;
	
	private String CreatorName;
	
	private long playTime;
	
	private long createTime; 
	
	private int templateId;
	
	private List<UserView> memberList; 

	public GameView(Game game) {
		this.setCreatorName(game.getCreator().getName());
		this.setPlayTime(game.getPlayTime());
		this.setCreateTime(game.getCreateTime());
		this.setId(game.getId());
		this.setTemplateId(game.getTemplate().getId());
		
		setMemberList(new ArrayList<UserView>());
		for (User user: game.getMemberList()) {
			getMemberList().add(new UserView(user)); 
		}
	}
	
	public class UserView {

		private String name;
		
		public UserView(User user) {
			this.name = user.getName();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
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

	public List<UserView> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<UserView> memberList) {
		this.memberList = memberList;
	}
	
}
