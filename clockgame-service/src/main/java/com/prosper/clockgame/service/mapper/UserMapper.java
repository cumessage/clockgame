package com.prosper.clockgame.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prosper.clockgame.service.bean.User;

public interface UserMapper {

	public User getByEmail(String email);

	public User getByEmailAndPass(
		@Param("email")String email, @Param("password")String password
	);

	public User getById(long userId);
	
	public List<User> getByIds(List<Long> userIds);

	public void insertOne(User user);

	public Object updateOne(User user);
	
	
}
