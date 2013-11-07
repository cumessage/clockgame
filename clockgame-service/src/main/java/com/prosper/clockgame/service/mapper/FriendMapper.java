package com.prosper.clockgame.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prosper.clockgame.service.bean.FriendPair;

public interface FriendMapper {
	
	public FriendPair getOne(
			@Param("userId") long userId, 
			@Param("friendId") long friendId);

	public void insertOne(FriendPair friendPair);

	public void updateOne(FriendPair friendPair);

	public List<Long> getListByUserId(long userId);
	
}
