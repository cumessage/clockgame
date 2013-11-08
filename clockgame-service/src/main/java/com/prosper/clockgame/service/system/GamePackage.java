package com.prosper.clockgame.service.system;

import java.util.Map;

import com.prosper.clockgame.service.bean.GameTemplate;

public class GamePackage {
	
	private Map<Integer, GameTemplate> gameMap;
	
	public GamePackage() {
		gameMap.put(1, new GameTemplate(1, "1st game", ""));
		gameMap.put(2, new GameTemplate(2, "2nd game", ""));
		gameMap.put(3, new GameTemplate(3, "3rd game", ""));
		gameMap.put(4, new GameTemplate(4, "4th game", ""));
		gameMap.put(5, new GameTemplate(5, "5th game", ""));
		gameMap.put(6, new GameTemplate(6, "6th game", ""));
		gameMap.put(7, new GameTemplate(7, "7th game", ""));
		gameMap.put(8, new GameTemplate(8, "8th game", ""));
	}
	
}
