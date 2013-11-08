package com.prosper.clockgame.service.mapper;

import java.util.List;
import java.util.Map;

public interface GameMemberMapper {
	
	public void insertOne(long gameId, long userId);

	public List<Long> getList(long gameId);

	public Map<String, String> getOne(long gameId);

	public Object deleteOne(long gameId, long userId);

}
