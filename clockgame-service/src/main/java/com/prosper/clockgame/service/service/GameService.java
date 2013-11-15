package com.prosper.clockgame.service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosper.clockgame.service.bean.Game;
import com.prosper.clockgame.service.bean.GameTemplate;
import com.prosper.clockgame.service.bean.User;
import com.prosper.clockgame.service.dao.GameDao;
import com.prosper.clockgame.service.dao.GameMemberDao;
import com.prosper.clockgame.service.exception.DataExistException;
import com.prosper.clockgame.service.exception.DataNotExistException;
import com.prosper.clockgame.service.exception.OutOfLimitException;

@Service
public class GameService {
	
	/**
	 * 默认创建延时时间
	 */
	private static final int CREATE_DELAY = 5 * 60 * 1000;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private GameMemberDao gameMemberDao;
	
	public void create(long time, long userId, int templateId) {
		long now = System.currentTimeMillis();
		if (time < now + CREATE_DELAY) {
			throw new OutOfLimitException();
		}
		
		Game game = new Game();
		game.setCreateTime(now);
		game.setPlayTime(time);
		game.setTemplate(new GameTemplate(templateId));
		game.setCreator(new User(userId));
		
		gameDao.insertOne(game);
		gameMemberDao.insertOne(game.getId(), userId, System.currentTimeMillis());
	}
	
	public Game get(long gameId) {
		Game game = gameDao.getOne(gameId);
		if (game == null) {
			throw new DataNotExistException();
		}
		List<Map<Long, Long>> memberList = gameMemberDao.getList(gameId);
		Map<User, Long> memberMap = new HashMap<User, Long>();
		for (Map<Long, Long> member: memberList) {
			memberMap.put(new User(member.get("userId")), member.get("createtime"));
		}
		game.setMember(memberMap);
		return game;
	}

	public void join(long gameId, long userId) {
		Game game = get(gameId);
		if (game.joinable()) {
			if (!game.isJoined(userId)) {
				gameMemberDao.insertOne(gameId, userId, System.currentTimeMillis());
				return;
			} else {
				throw new DataExistException();
			}
		} else {
			throw new OutOfLimitException();
		}
	}

	public void quit(long gameId, long userId) {
		if (gameMemberDao.getOne(gameId, userId).size() != 0) {
			gameMemberDao.deleteOne(gameId, userId);
		} else {
			throw new DataNotExistException();
		}
	}

	public Game getInfo(long gameId) {
		Game game = get(gameId);
		
		User creator = userService.getUserInfo(game.getCreator().getId());
		game.setCreator(creator);
		
		// TODO get members
		Set<User> userList = game.getMember().keySet();
		List<Long> userIdList = new ArrayList<Long>();
		for (User user: userList) {
			userIdList.add(user.getId());
		}
		
		List<User> memberList = userService.getUserInfoList(userIdList);
		return game;
	}

}









