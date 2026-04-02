package com.secc.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secc.app.repositories.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository repo;
	public boolean manageAccess(int id) {
		return repo.manageAccess(id);
	}
	
	public void login() {
		
	}
}
