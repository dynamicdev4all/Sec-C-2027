package com.secc.app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.secc.app.models.User;


@Repository
public class UserRepository {
	public Map<Integer, User> db = new HashMap<Integer, User>();
	int current = 1;
	public User register(User newUser) {
		try {
			db.put(newUser.getId(), newUser);
			return newUser;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public Map<String, String> userLogin(String email, String pass, String key) {
		Map<String, String> responseMap = new HashMap<String, String>();;
		try {
			
			User user = db.get(key);
			if(user == null) {
				responseMap.put("status_code", "404");
				responseMap.put("msg", "No Account Found");
				return responseMap;
			}
			else {
				if(user.getBanned() == true) {
					responseMap.put("status_code", "403");
					responseMap.put("msg", "The Account is Banned");
					return responseMap;
				}else {
					if(user.getEmail() == email && user.getPass() == pass) {
						responseMap.put("status_code", "200");
						responseMap.put("msg", "Login Success");
						return responseMap;
					}
					else {
						responseMap.put("status_code", "401");
						responseMap.put("msg", "Login FailedM");
						return responseMap;
					}
				}
			}
			
			
			
			
			
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
