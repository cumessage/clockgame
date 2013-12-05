package com.prosper.clockgame.service.view;

import java.util.ArrayList;
import java.util.List;

import com.prosper.clockgame.service.bean.Game;

public class GameListView extends View {
	
	private List<GameView> gameList;
	
	public GameListView(List<Game> list) {
		gameList = new ArrayList<GameView>();
		for (Game game: list) {
			GameView gameView = new GameView(game);
			gameList.add(gameView);
		}
	}

	public List<GameView> getGameList() {
		return gameList;
	}

	public void setGameList(List<GameView> gameList) {
		this.gameList = gameList;
	}

	public class GameView {
		
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
}
