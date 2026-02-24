package com.secc.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secc.app.models.User;
import com.secc.app.repositories.UserRepository;


@Service
public class UserService {
	
//	UserRepository repo = new UserRepository();
	
	
	@Autowired
	UserRepository repo;
	public User register(User newUser) {
		return repo.register(newUser);
	}
	
	public ArrayList<User> showAll() {
		return repo.showAll();
	}
	
	public User showOne(int id) {
		return repo.showOne(id);
	}
}
