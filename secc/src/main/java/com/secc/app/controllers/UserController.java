
package com.secc.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secc.app.models.User;
import com.secc.app.services.UserService;
@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class UserController {
	
	
	@Autowired
	UserService service;
	
	
	//Create - Register
	@PostMapping("/user/register")
	public String createUser(@RequestBody User newUser) {
		User user = service.register(newUser);
		if(user != null) {
			return "Registration Successful.";
		}
		return "Registration Failed.";
	}
	
	//Create - Register
		@PostMapping("/user/login")
		public String loginUser(@RequestBody Map<String, String> loginMap) {
			User user = service.login(loginMap);
			if(user != null) {
				return "Registration Successful.";
			}
			return "Registration Failed.";
		}
		
	//Read - Show All
	@GetMapping("/user/show_all")
	public ArrayList<User> showAll() {
//		ArrayList<User> list = new ArrayList<User>();
//		list.addAll(db.values());
//		return list;
		return service.showAll();
	}
	//Read - Show One
	@GetMapping("/user/show_one/{id}")
	public User showOne(@PathVariable int id) {
	
		return service.showOne(id);
	}
}
