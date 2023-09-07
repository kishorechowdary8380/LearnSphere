package com.learnSphere.services;

import com.learnSphere.entities.Users;

public interface UsersServices {
	
	public String addUser(Users user);
	public Users findByEmail(String email);
	  boolean checkEmail(String email);
	  String saveUsers(Users user);
	

}
