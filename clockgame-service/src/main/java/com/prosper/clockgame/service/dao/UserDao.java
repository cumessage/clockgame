package com.prosper.clockgame.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prosper.clockgame.service.bean.User;
import com.prosper.clockgame.service.mapper.UserMapper;

@Repository
public class UserDao {
	
	@Autowired
	private UserMapper userMapper;

	public void insert(User user) {
		userMapper.insertOne(user);
	}

	public User getByEmail(String email) {
		return userMapper.getByEmail(email);
	}

	public User getByEmailAndPass(String email, String password) {
		return userMapper.getByEmailAndPass(email, password);
	}

	public User getById(long userId) {
		return userMapper.getById(userId);
	}
	
	public List<User> getListByIds(List<Long> userIds) {
		return userMapper.getByIds(userIds);
	}

	public void updateOne(User user) {
		userMapper.updateOne(user);
	}
	
}
