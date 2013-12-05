package com.prosper.clockgame.service.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GameMemberMapper {
	
	public List<Map<Long, Long>> getList(long gameId);

	public Map<Long, Long> getOne(
			@Param("gameId") long gameId, 
			@Param("userId") long userId);
	
	public List<Long> getListByMember(long userId);
	
	public void insertOne(
			@Param("gameId") long gameId, 
			@Param("userId") long userId, 
			@Param("createTime") long createTime);
	
	public Object deleteOne(
			@Param("gameId") long gameId, 
			@Param("userId") long userId);

}
