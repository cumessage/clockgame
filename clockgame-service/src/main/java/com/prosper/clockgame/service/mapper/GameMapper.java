package com.prosper.clockgame.service.mapper;

import java.util.List;

import com.prosper.clockgame.service.bean.Game;

public interface GameMapper {
	
	public void insertOne(Game game);

	public Game getOne(long gameId);

	public List<Game> getListByIds(List<Long> gameIdList);

	public List<Game> getListByCreatorIds(List<Long> creatorList);

}
