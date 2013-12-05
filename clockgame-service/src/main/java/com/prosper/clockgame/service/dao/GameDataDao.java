package com.prosper.clockgame.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prosper.clockgame.service.bean.GameData;
import com.prosper.clockgame.service.mapper.GameDataMapper;

@Repository
public class GameDataDao {
	
	@Autowired
	private GameDataMapper gameDataMapper;

	public List<GameData> getListByGameId(long gameId) {
		return gameDataMapper.getListByGameId(gameId);
	}
	
	public GameData getOneByGameIdAndUserIdAndStep(long gameId, long userId, int step) {
		return gameDataMapper.getOneByGameIdAndUserIdAndStep(gameId, userId, step);
	}
	
	public void addOne(GameData gameData) {
		gameDataMapper.insertOne(gameData);
	}
	
	public void updateOne(GameData gameData) {
		gameDataMapper.updateOne(gameData);
	}
	
	public void upsertOne(GameData gameData) {
		GameData gameDataExist = getOneByGameIdAndUserIdAndStep(
				gameData.getGameId(), gameData.getUserId(), gameData.getStep());
		if (gameDataExist != null) {
			gameData.setId(gameDataExist.getId());
			updateOne(gameData);
		} else {
			addOne(gameData);
		}
	}
	
}
