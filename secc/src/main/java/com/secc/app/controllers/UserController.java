package com.secc.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secc.app.models.User;

@RestController
public class UserController {
	
	Map<Integer, User> db = new HashMap<Integer, User>();
	int current = 1;
	//Create - Register
	@PostMapping("/user/register")
	public String createUser(@RequestBody User newUser) {
		try {
			db.put(current, newUser);
			current ++;
			return "Registration Successful";
		} catch (Exception e) {
			return "Registration Failed";
		}
	}
	
	//Read - Show All
	@GetMapping("/user/show_all")
	public ArrayList<User> showAll() {
//		ArrayList<User> list = new ArrayList<User>();
//		list.addAll(db.values());
//		return list;
		return new ArrayList<User>(db.values());
	}
	//Read - Show One
	@GetMapping("/user/show_one/{id}")
	public User showOne(@PathVariable int id) {
		try {
				return db.get(id);
		} catch (Exception e) {
			return null;
		}
		
	}
}
