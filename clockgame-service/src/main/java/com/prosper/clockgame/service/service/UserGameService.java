package com.prosper.clockgame.service.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosper.clockgame.service.bean.Game;
import com.prosper.clockgame.service.bean.User;

@Service
public class UserGameService {

	@Autowired
	private GameService gameService;
	
	@Autowired
	private UserService userService;
	
	public List<Game> getUserJoinableGameList(long userId) {
		List<User> friendList = userService.getFriends(userId);
		List<Long> friendIds = new ArrayList<Long>();
		for (User user: friendList) {
			friendIds.add(user.getId());
		}
		
		List<Game> gameList = gameService.getListByCreatorIds(friendIds);
		List<Long> joinedGameIdList = gameService.getIdListByMember(userId);
		
		Iterator<Game> gameListIterator = gameList.iterator();
		while (gameListIterator.hasNext()) {
			Game game = gameListIterator.next();
			if (joinedGameIdList.contains(game.getId())) {
				gameListIterator.remove();
			}
		}
		return gameList;
	}
	
	public Game getUserJoinedGameByPlayTime(long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Game> getUserJoinedGameList(long userId) {
		return gameService.getListByMember(userId);
	}

	public GameService getGameService() {
		return gameService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
}
