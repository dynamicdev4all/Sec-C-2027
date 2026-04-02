package com.secc.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.secc.app.dto.AdminLoginDTO;
import com.secc.app.models.Admin;
import com.secc.app.models.User;
import com.secc.app.services.AdminService;

@RestController
public class AdminController {
	
	
	@Autowired
	AdminService service;
	
	//Create - Register
			@PostMapping("/admin/login")
			public String loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO) {
				Admin admin = service.login();
				if(user != null) {
					return "Registration Successful.";
				}
				return "Registration Failed.";
			}
			
	
	
	@PatchMapping("/admin/manage_access/{id}")
	public String manageUserAccess(@PathVariable int id) {
		boolean response = service.manageAccess(id);
		
		if(response == true) {
			return "The account has been banned.";
		}else {
			return "The accound has been un-banned.";
		}
	}
}
