package com.prosper.clockgame.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosper.clockgame.service.bean.FriendPair;
import com.prosper.clockgame.service.dao.FriendDao;
import com.prosper.clockgame.service.exception.DataExistException;

@Service
public class FriendService {
	
	@Autowired
	private FriendDao friendDao;
	
	/**
	 * 添加好友
	 */
	public void addFriend(long userId, long friendId) {
		if (friendDao.getOne(userId, friendId) == null) {
			FriendPair friendPair = new FriendPair(userId, friendId);
			friendDao.insertOne(friendPair);
		} else {
			throw new DataExistException();
		}
	}

	/**
	 * 通过好友验证
	 */
	public void varifyFriend(long userId, long friendId) {
		FriendPair friendPair = friendDao.getOne(friendId, userId);
		if (friendPair != null) {
			if (friendPair.getStatus() == FriendPair.UNCHECKED) {
				friendPair.setChecked();
				friendDao.updateOne(friendPair);
				
				FriendPair friendPairMirror = new FriendPair(userId, friendId);
				friendPairMirror.setChecked();
				friendDao.insertOne(friendPairMirror);
			} else {
				throw new DataExistException();
			}
		} else {
			throw new DataExistException();
		}
	}

	public List<Long> getFriendIdList(long userId) {
		return friendDao.getListByUserId(userId);
	}

}
