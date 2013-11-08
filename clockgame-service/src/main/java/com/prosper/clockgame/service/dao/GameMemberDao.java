package com.prosper.clockgame.service.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prosper.clockgame.service.mapper.GameMemberMapper;

@Repository
public class GameMemberDao {
	
	@Autowired
	private GameMemberMapper gameMemberMapper;

	public void insertOne(long gameId, long userId) {
		gameMemberMapper.insertOne(gameId, userId);
	}
	
	public Map<String, String> getOne(long gameId, long userId) {
		return gameMemberMapper.getOne(gameId);
	}

	public List<Long> getList(long gameId) {
		return gameMemberMapper.getList(gameId);
	}

	public void deleteOne(long gameId, long userId) {
		gameMemberMapper.deleteOne(gameId, userId);
	}

	
	
}
