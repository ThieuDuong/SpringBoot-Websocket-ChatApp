package com.thieuduong.chatapp.storage;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {
	private static UserStorage instance;
	private Set<String> users;

	private UserStorage() {
		users = new HashSet<String>();
	}

	public static synchronized UserStorage getInstance() {
		if (instance == null) {
			instance = new UserStorage();
		}
		return instance;
	}

	public Set<String> getUsers() {
		return users;
	}

	public void setUsers(String userName) throws Exception {
		if(users.contains(userName)) {
			throw new Exception("User already exist with usernaem: " + userName);
		}
		users.add(userName);
	}
}
