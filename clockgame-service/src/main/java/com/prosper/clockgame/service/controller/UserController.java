package com.prosper.clockgame.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prosper.clockgame.service.bean.User;
import com.prosper.clockgame.service.service.FriendService;
import com.prosper.clockgame.service.service.UserService;
import com.prosper.clockgame.service.view.UserView;
import com.prosper.clockgame.service.view.View;

@Controller
@RequestMapping(value="/user")
public class UserController { 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FriendService friendService;

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public View register(
			@RequestParam("email") String email,
			@RequestParam("password") String password) { 
		// TODO validate email&password
		userService.register(email, password);
		return new View();
	}
	
	@RequestMapping(value="/login")
	public View login(
			@RequestParam("email")String email, 
			@RequestParam("password")String password) {
		// TODO validate email&password
		userService.login(email, password);
		return new View();
	}
	
	@RequestMapping(value="login", method=RequestMethod.DELETE)
	public View logout(@RequestParam("userId") String userId) {
		userService.logout(userId);
		return new View();
	}
	
	@RequestMapping(value="/{userId}/info", method=RequestMethod.GET)
	public View getUserInfo(@PathVariable("userId") long userId) {
		User user = userService.getUserInfo(userId);
		return new UserView(user);
	}
	
	@RequestMapping(value="/{userId}/info", method=RequestMethod.GET)
	public View updateUserInfo(
			@PathVariable("userId") long userId,
			@RequestParam("name") String name) {
		// TODO validate name
		userService.updateUserInfo(userId, name);
		return new View();
	}
	
	@RequestMapping(value="/{userId}/friend/unchecked", method=RequestMethod.POST)
	public View addFriend(
			@RequestParam("friendId") long friendId,
			@PathVariable("userId") long userId) {
		friendService.addFriend(userId, friendId);
		return new View();
	}
	
	@RequestMapping(value="/{userId}/friend/", method=RequestMethod.POST)
	public View varifyFriend(
			@RequestParam("friendId") long friendId,
			@PathVariable("userId") long userId) {
		friendService.varifyFriend(userId, friendId);
		return new View();
	}
	
	@RequestMapping(value="/{userId}/friend", method=RequestMethod.GET)
	public View getFriends(@PathVariable("userId") long userId) {
		List<User> userList = userService.getFriends(userId);
		// TODO write user list view
		return new View();
	}
	
}
