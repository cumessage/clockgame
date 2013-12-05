package com.prosper.clockgame.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prosper.clockgame.service.bean.GameData;

public interface GameDataMapper {
	
	public List<GameData> getListByGameId(long gameId);

	public void insertOne(GameData gameData);

	public GameData getOneByGameIdAndUserIdAndStep(
			@Param("gameId")long gameId, @Param("userId")long userId, @Param("step")int step);

	public void updateOne(GameData gameData);


}
