package com.prosper.clockgame.service.dao;

import java.util.ArrayList;
import java.util.List;

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

	public List<Game> getListByCreatorIds(List<Long> creatorList) {
		if (creatorList == null || creatorList.size() == 0) {
			return new ArrayList<Game>();
		}
		return gameMapper.getListByCreatorIds(creatorList);
	}

	public List<Game> getListByIds(List<Long> gameIdList) {
		if (gameIdList == null || gameIdList.size() == 0) {
			return new ArrayList<Game>();
		}
		return gameMapper.getListByIds(gameIdList);
	}
	
}
