package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entities.Users;
import com.learnSphere.services.UsersServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersServices uservice;
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute Users user) {
		String email=user.getEmail();
		boolean isPresent=uservice.checkEmail(email);
		if(isPresent==false)
		{
		uservice.addUser(user);
		}
		else
		{
			System.out.println("email already exists");
		}
		return "login";
	}
	
	@PostMapping("/validateUser")
	public String validateUser( @RequestParam("email") String email, @RequestParam("password") String password, HttpSession session,Model model) {

	Users user=uservice.findByEmail(email);
	String dbpassword=user.getPassword();	
	String role=user.getRole();
	
	if(password.equals(dbpassword)) {
		session.setAttribute("loggedInUser", user);
		model.addAttribute("user", user);
		if(role.equals("Trainer") ) {
			
			return "trainerHome";
		}
		else {
			
			return "studentHome";
		}
	}
	
	else {
	
	model.addAttribute("wrongPassword",true);
	return "login";
	}
	}
}


