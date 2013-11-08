package com.prosper.clockgame.service.mapper;

import com.prosper.clockgame.service.bean.Game;

public interface GameMapper {
	
	public long insertOne(Game game);

	public Game getOne(long gameId);

}
