package com.learnSphere.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Users { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String username;
	String email;
	String password;
	String gender;
	String role;
	
	@ManyToMany   // one user can have many courses and one course can be axcissed by many users.
    List<Course> courseList;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String username, String email, String password, String gender, String role,
			List<Course> courseList) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.courseList = courseList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", role=" + role + ", courseList=" + courseList + "]";
	}

	
    
	
	

}
