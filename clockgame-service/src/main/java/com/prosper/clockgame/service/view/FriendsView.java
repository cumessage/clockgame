package com.prosper.clockgame.service.view;

import java.util.List;

import com.prosper.clockgame.service.bean.User;

public class FriendsView extends View {
	
	private FriendView[] friends;
	
	public FriendsView(List<User> userList) {
		setFriends(new FriendView[userList.size()]);
		for (int i = 0; i < userList.size(); i ++) {
			getFriends()[i] = new FriendView(userList.get(i));
		}
	}
	
	class FriendView {
		
		private long userId;
		
		private String name;
		
		public FriendView(User user) {
			setUserId(user.getId());
			setName(user.getName());
		}

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
	
	public FriendView[] getFriends() {
		return friends;
	}

	public void setFriends(FriendView[] friends) {
		this.friends = friends;
	}

}
