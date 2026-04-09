package com.secc.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secc.app.dto.UserDataDto;
import com.secc.app.models.User;
import com.secc.app.repositories.AdminRepository;
import com.secc.app.repositories.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository repo;
	
	@Autowired
	UserRepository uRepo;
	public boolean manageAccess(int id) {
		return repo.manageAccess(id);
	}
	
	public void login() {
		
	}
	
	public ArrayList<UserDataDto> showAllUsers() {
		ArrayList<User> list1 = new ArrayList<User>();
		list1.addAll(uRepo.db.values());
		ArrayList<UserDataDto> list2 = new ArrayList<UserDataDto>();
		for(int i = 0; i< list1.size(); i++) {
			UserDataDto user = new UserDataDto(list1.get(i).getId(), list1.get(i).getName(), list1.get(i).getEmail(), list1.get(i).getBanned());
			list2.add(user);
		}
		return list2;
	}
}
