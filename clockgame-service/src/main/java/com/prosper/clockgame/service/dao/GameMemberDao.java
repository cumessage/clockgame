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
	
	public Map<Long, Long> getOne(long gameId, long userId) {
		return gameMemberMapper.getOne(gameId, userId);
	}

	public List<Map<Long, Long>> getList(long gameId) {
		return gameMemberMapper.getList(gameId);
	}
	
	public List<Long> getListByMember(long userId) {
		return gameMemberMapper.getListByMember(userId);
	}
	
	public void insertOne(long gameId, long userId, long createTime) {
		gameMemberMapper.insertOne(gameId, userId, createTime);
	}	

	public void deleteOne(long gameId, long userId) {
		gameMemberMapper.deleteOne(gameId, userId);
	}
	
}
