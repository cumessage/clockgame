package com.prosper.clockgame.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prosper.clockgame.service.bean.Game;
import com.prosper.clockgame.service.mapper.GameMapper;

@Repository
public class GameDao {
	
	@Autowired
	private GameMapper gameMapper;

	public void insertOne(Game game) {
		gameMapper.insertOne(game);
	}

	public Game getOne(long gameId) {
		return gameMapper.getOne(gameId);
	}

	
	
}
