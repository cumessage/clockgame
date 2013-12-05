package com.prosper.clockgame.service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosper.clockgame.service.bean.Game;
import com.prosper.clockgame.service.bean.GameData;
import com.prosper.clockgame.service.bean.GameTemplate;
import com.prosper.clockgame.service.bean.GameTemplate.Step;
import com.prosper.clockgame.service.bean.User;
import com.prosper.clockgame.service.dao.GameDao;
import com.prosper.clockgame.service.dao.GameDataDao;
import com.prosper.clockgame.service.dao.GameMemberDao;
import com.prosper.clockgame.service.exception.DataExistException;
import com.prosper.clockgame.service.exception.DataNotExistException;
import com.prosper.clockgame.service.exception.OutOfLimitException;

@Service
public class GameService {
	
	/**
	 * 默认创建延时时间
	 */
	private static final int CREATE_DELAY = 5 * 1 * 1000;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GameDao gameDao;
	
	@Autowired
	private GameMemberDao gameMemberDao;
	
	@Autowired
	private GameDataDao gameDataDao;
	
	public void create(long time, long userId, int templateId) {
		long now = System.currentTimeMillis();
		if (time < now + CREATE_DELAY) {
			throw new OutOfLimitException();
		}
		
		Game game = new Game();
		game.setCreateTime(now);
		game.setPlayTime(time);
		game.setTemplate(new GameTemplate(templateId));
		game.setCreator(userService.getUserInfo(userId));
		
		gameDao.insertOne(game);
		gameMemberDao.insertOne(game.getId(), userId, System.currentTimeMillis());
	}
	
	public Game get(long gameId) {
		Game game = gameDao.getOne(gameId);
		if (game == null) {
			throw new DataNotExistException();
		}
		List<Map<Long, Long>> memberIdList = gameMemberDao.getList(gameId);
		List<User> memberList = new ArrayList<User>();
		for (Map<Long, Long> pair: memberIdList) {
			memberList.add(new User(pair.get("userId")));
		}
		game.setMemberList(memberList);
		return game;
	}
	
	public List<Game> getListByCreatorIds(List<Long> creatorList) {
		return gameDao.getListByCreatorIds(creatorList);
	}
	
	public List<Long> getIdListByMember(long userId) {
		return gameMemberDao.getListByMember(userId);
	}
	
	public List<Game> getListByMember(long userId) {
		return gameDao.getListByIds(getIdListByMember(userId));
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
		
		// TODO get members
		List<User> userList = game.getMemberList();
		List<Long> userIdList = new ArrayList<Long>();
		for (User user: userList) {
			userIdList.add(user.getId());
		}
		
		List<User> memberList = userService.getUserInfoList(userIdList);
		game.setMemberList(memberList);
		return game;
	}

	public List<GameData> getDate(long gameId) {
		return gameDataDao.getListByGameId(gameId);
	}

	public void addDate(long gameId, long userId, int step, String value) {
		Game game = gameDao.getOne(gameId);
		int templateId = game.getTemplate().getId();
		GameTemplate gameTemplate = GameTemplate.getMap().get(templateId);
		Step stepTemplate = gameTemplate.getSteps().get(step - 1);
		
		GameData gameData = new GameData();
		gameData.setGameId(gameId);
		gameData.setStep(step);
		gameData.setUserId(userId);
		gameData.setValue(value);
		if (stepTemplate.getValue().equals(value)) {
			gameData.setFinished(1);
		} else {
			gameData.setFinished(0);
		}
		
		gameDataDao.upsertOne(gameData);
	}

}









