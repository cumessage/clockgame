package com.prosper.clockgame.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prosper.clockgame.service.bean.Game;
import com.prosper.clockgame.service.service.GameService;
import com.prosper.clockgame.service.view.View;

@Controller
@RequestMapping(value="/game")
public class GameController { 
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public View create(
			@RequestParam("time") long time,
			@RequestParam("userid") long userId) { 
		// TODO validate time&userid
		gameService.create(time, userId);
		return new View();
	}
	
	@RequestMapping(value="/{gameid}/user", method=RequestMethod.POST)
	@ResponseBody
	public View join(
			@PathVariable("gameid") long gameId,
			@RequestParam("userid") long userId) { 
		// TODO validate userid
		gameService.join(gameId, userId);
		return new View();
	}
	
	@RequestMapping(value="/{gameid}/user", method=RequestMethod.DELETE)
	@ResponseBody
	public View quit(
			@PathVariable("gameid") long gameId,
			@RequestParam("userid") long userId) { 
		// TODO validate userid
		gameService.quit(gameId, userId);
		return new View();
	}
	
	@RequestMapping(value="/{gameid}/info", method=RequestMethod.DELETE)
	@ResponseBody
	public View getInfo(
			@PathVariable("gameid") long gameId) {
		// TODO validate gameId
		Game game = gameService.getInfo(gameId);
		// TODO write view;
		return new View();
	}
	
	@RequestMapping(value="/{gameid}/result", method=RequestMethod.GET)
	@ResponseBody
	public View getResults(
			@PathVariable("gameid") long gameId) { 
		// TODO 
		return new View();
	}
	
	@RequestMapping(value="/{gameid}/result/{userid}", method=RequestMethod.POST)
	@ResponseBody
	public View postResult(
			@PathVariable("gameid") long gameId,
			@PathVariable("userid") long userId) { 
		// TODO 
		return new View();
	}
	
}
