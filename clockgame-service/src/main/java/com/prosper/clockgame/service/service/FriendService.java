package com.prosper.clockgame.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosper.clockgame.service.bean.FriendPair;
import com.prosper.clockgame.service.dao.FriendDao;
import com.prosper.clockgame.service.exception.DataExistException;
import com.prosper.clockgame.service.exception.DataNotExistException;

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
				long now = System.currentTimeMillis();
				friendPair.setChecked();
				friendPair.setVarifyTime(now);
				friendDao.updateOne(friendPair);
				
				FriendPair friendPairMirror = new FriendPair(userId, friendId);
				friendPairMirror.setVarifyTime(now);
				friendPairMirror.setChecked();
				friendDao.insertOne(friendPairMirror);
			} else {
				throw new DataExistException();
			}
		} else {
			throw new DataNotExistException();
		}
	}

	/**
	 * 获得朋友列表
	 */
	public List<Long> getFriendIdList(long userId) {
		List<FriendPair> requestList = friendDao.getListByUserIdAndStatus(userId, (short)1);
		List<Long> friendIdList = new ArrayList<Long>();
		for (FriendPair friendPair: requestList) {
			friendIdList.add(friendPair.getFriendId());
		}
		return friendIdList;
	}

	/**
	 * 获得朋友申请列表
	 */
	public List<Long> getFriendRequestIdList(long userId) {
		List<FriendPair> requestList = friendDao.getListByFriendIdAndStatus(userId, (short)0);
		List<Long> requestIdList = new ArrayList<Long>();
		for (FriendPair friendPair: requestList) {
			requestIdList.add(friendPair.getUserId());
		}
		return requestIdList;
	}

}
