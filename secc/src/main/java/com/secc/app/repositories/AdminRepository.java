package com.secc.app.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.secc.app.models.User;


@Repository
public class AdminRepository {
	
	@Autowired
	UserRepository repo;
	
	public boolean manageAccess(int id) {
		//first we have to search user by their id in the database
		
		User user = repo.db.get(id);
		
		if(user.getBanned() == false) {
			user.setBanned(true);
			
			return true;
		}else {
			user.setBanned(false);
			return false;
		}
	}
}
