package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;
import com.learnSphere.entities.Users;
import com.learnSphere.services.TrainerServices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TrainerController {
	@Autowired
	TrainerServices tservice;
	
	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute Course course, Model model,HttpSession session) {
		tservice.addCourse(course);
		Users loggedUser=(Users) session.getAttribute("loggedInUser");
		model.addAttribute("user",loggedUser );
		return "trainerHome";
		
	}
	
	@GetMapping("/viewC")
	public String viewC(Model model) {
		
		List<Course> courseList= tservice.fetchAllCourses();
		model.addAttribute("courseList", courseList);
		return "viewCourse"; 
		
	}
	
	@PostMapping("/addLesson")
	public String addLesson(@ModelAttribute Lesson lesson,HttpSession session,Model model ) {
		tservice.addLesson(lesson);
		Users loggedUser=(Users) session.getAttribute("loggedInUser");
		model.addAttribute("user",loggedUser );
		Course course=lesson.getCourse();
		course.getLessonList().add(lesson);
		tservice.saveCourse(course);
		return "trainerHome";
		
	}
	}
		


