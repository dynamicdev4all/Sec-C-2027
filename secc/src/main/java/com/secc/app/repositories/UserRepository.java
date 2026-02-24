package com.secc.app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.secc.app.models.User;


@Repository
public class UserRepository {
	Map<Integer, User> db = new HashMap<Integer, User>();
	int current = 1;
	public User register(User newUser) {
		try {
			db.put(newUser.getId(), newUser);
			return newUser;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public ArrayList<User> showAll() {
		return new ArrayList<User>(db.values());
	}
	
	public User showOne(int id) {
		try {
			return db.get(id);
	} catch (Exception e) {
		return null;
	}
	}
}
