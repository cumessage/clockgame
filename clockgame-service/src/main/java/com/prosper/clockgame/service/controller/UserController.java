package com.prosper.clockgame.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prosper.clockgame.service.bean.User;
import com.prosper.clockgame.service.service.FriendService;
import com.prosper.clockgame.service.service.UserService;
import com.prosper.clockgame.service.view.FriendsView;
import com.prosper.clockgame.service.view.LoginView;
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
	public View register(@RequestBody Map<String, String> requestMap) {
		String email = requestMap.get("email");
		String password = requestMap.get("password");
		// TODO validate email&password
		userService.register(email, password);
		return new View();
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public View login(@RequestBody Map<String, String> requestMap) {
		String email = requestMap.get("email");
		String password = requestMap.get("password");
		// TODO validate email&password
		long userId = userService.login(email, password);
		return new LoginView(userId);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.DELETE)
	@ResponseBody
	public View logout(@RequestBody Map<String, String> requestMap) {
		String userId = requestMap.get("userId");
		userService.logout(userId);
		return new View();
	}
	
	@RequestMapping(value="/{userId}/info", method=RequestMethod.GET)
	@ResponseBody
	public View getUserInfo(@PathVariable("userId") long userId) {
		User user = userService.getUserInfo(userId);
		return new UserView(user);
	}
	
	@RequestMapping(value="/{userId}/info", method=RequestMethod.PUT)
	@ResponseBody
	public View updateUserInfo(
			@PathVariable("userId") long userId,
			@RequestBody Map<String, String> requestMap) {
		String name = requestMap.get("name");
		// TODO validate name
		userService.updateUserInfo(userId, name);
		return new View();
	}
	
	@RequestMapping(value="/{userId}/friend/unchecked", method=RequestMethod.POST)
	@ResponseBody
	public View addFriend(
			@RequestBody Map<String, String> requestMap,
			@PathVariable("userId") long userId) {
		long friendId = Long.parseLong(requestMap.get("friendId"));
		userService.addFriend(userId, friendId);
		return new View();
	}
	
	@RequestMapping(value="/{userId}/friend/unchecked", method=RequestMethod.GET)
	@ResponseBody
	public View getFriendsRequest(@PathVariable("userId") long userId) {
		List<User> userList = userService.getFriendsRequest(userId);
		return new FriendsView(userList);
	}
	
	@RequestMapping(value="/{userId}/friend/", method=RequestMethod.POST)
	@ResponseBody
	public View varifyFriend(
			@RequestBody Map<String, String> requestMap,
			@PathVariable("userId") long userId) {
		long friendId = Long.parseLong(requestMap.get("friendId"));
		friendService.varifyFriend(userId, friendId);
		return new View();
	}
	
	@RequestMapping(value="/{userId}/friend", method=RequestMethod.GET)
	@ResponseBody
	public View getFriends(@PathVariable("userId") long userId) {
		List<User> userList = userService.getFriends(userId);
		return new FriendsView(userList);
	}
	
	
	
}
