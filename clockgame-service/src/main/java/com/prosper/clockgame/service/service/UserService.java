package com.prosper.clockgame.service.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosper.clockgame.service.bean.User;
import com.prosper.clockgame.service.dao.UserDao;
import com.prosper.clockgame.service.exception.DataExistException;
import com.prosper.clockgame.service.exception.DataNotExistException;
import com.prosper.clockgame.service.exception.InvalidParamException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FriendService friendService;
	
	private HashSet<Long> loginSet = new HashSet<Long>();
	
	/**
	 * 注册
	 */
	public void register(String email, String password) {
		if (!isUserExist(email)) {
			long now = System.currentTimeMillis();
			User user = new User(email, password);
			user.setName("");
			user.setIsClosed(0);
			user.setCreateTime(now);
			user.setLastUpdate(now);
			user.setLastLogin(0);
			userDao.insert(user);
		} else {
			throw new DataExistException();
		}
	}
	
	/**
	 * 使用邮箱判断用户是否存在
	 */
	public boolean isUserExist(String email) {
		User user = userDao.getByEmail(email);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 使用id判断用户是否存在
	 */
	public boolean isUserExist(long id) {
		User user = userDao.getById(id);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 用户登陆
	 */
	public long login(String email, String password) {
		User user = userDao.getByEmailAndPass(email, password);
		if (user == null) {
			throw new DataNotExistException();
		}
		user.setLastLogin(System.currentTimeMillis());
		userDao.updateOne(user);
		loginSet.add(user.getId());
		return user.getId();
	}
	
	/**
	 * 用户注销
	 */
	public void logout(String userId) {
		loginSet.remove(userId);
	}
	
	/**
	 * 获取用户基本信息
	 */
	public User getUserInfo(long id) {
		User user = userDao.getById(id);
		if (user == null) {
			throw new DataNotExistException();
		}
		return user;
	}
	
	/**
	 * 获取用户列表
	 */
	public List<User> getUserInfoList(List<Long> userIds) {
		return userDao.getListByIds(userIds);
	}
	
	/**
	 * 更新用户基本信息
	 */
	public void updateUserInfo(long userId, String name) {
		User user = userDao.getById(userId);
		if (user == null) {
			throw new DataNotExistException();
		}
		user.setName(name);
		updateUser(user);
	}
	
	/**
	 * 更新用户
	 */
	private void updateUser(User user) {
		user.setLastUpdate(System.currentTimeMillis());
		userDao.updateOne(user);
	}
	
	/**
	 * 添加朋友
	 */
	public void addFriend(long userId, long friendId) {
		if (isUserExist(userId) && isUserExist(friendId)) {
			friendService.addFriend(userId, friendId);
		} else {
			throw new InvalidParamException();
		}
	}
	
	/**
	 * 获得朋友申请列表
	 */
	public List<User> getFriendsRequest(long userId) {
		List<Long> userIds = friendService.getFriendRequestIdList(userId);
		return getUserInfoList(userIds);
	}
	
	/**
	 * 获取朋友列表
	 */
	public List<User> getFriends(long userId) {
		List<Long> userIds = friendService.getFriendIdList(userId);
		return getUserInfoList(userIds);
	}

	

}
