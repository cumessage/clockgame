package com.prosper.clockgame.service.view;

import java.util.ArrayList;
import java.util.List;

import com.prosper.clockgame.service.bean.Game;
import com.prosper.clockgame.service.bean.GameData;
import com.prosper.clockgame.service.bean.User;

public class GameDataView extends View {
	
	private List<GameData> gameDataList;
	
	public GameDataView(List<GameData> gameDataList) {
		this.gameDataList = gameDataList;
	}

	public List<GameData> getGameDataList() {
		return gameDataList;
	}

	public void setGameDataList(List<GameData> gameDataList) {
		this.gameDataList = gameDataList;
	}
	
}
