package com.prosper.clockgame.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosper.clockgame.service.bean.Game;
import com.prosper.clockgame.service.bean.User;
import com.prosper.clockgame.service.dao.GameDao;
import com.prosper.clockgame.service.dao.GameMemberDao;
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
	
	public void create(long time, long userId) {
		long now = System.currentTimeMillis();
		if (time < now + CREATE_DELAY) {
			throw new OutOfLimitException();
		}
		
		Game game = new Game();
		game.setCreateTime(now);
		game.setPlaytime(time);
		game.setCreator(new User(userId));
		
		long gameId = gameDao.insertOne(game);
		gameMemberDao.insertOne(gameId, userId);
	}

	public void join(long gameId, long userId) {
		Game game = gameDao.getOne(gameId);
		if (game == null) {
			throw new DataNotExistException();
		}
		
		if (game.joinable()) {
			gameMemberDao.insertOne(gameId, userId);
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
		Game game = gameDao.getOne(gameId);
		if (game == null) {
			throw new DataNotExistException();
		} 
		
		User creator = userService.getUserInfo(game.getCreator().getId());
		game.setCreator(creator);

		// TODO get members
		return game;
	}

}









