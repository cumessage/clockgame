package com.prosper.clockgame.service.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GameMemberMapper {
	
	public void insertOne(
			@Param("gameId") long gameId, 
			@Param("userId") long userId, 
			@Param("createTime") long createTime);

	public List<Map<Long, Long>> getList(long gameId);

	public Map<Long, Long> getOne(
			@Param("gameId") long gameId, 
			@Param("userId") long userId);

	public Object deleteOne(
			@Param("gameId") long gameId, 
			@Param("userId") long userId);

}
