package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;
import com.learnSphere.entities.Users;
import com.learnSphere.services.StudentService;
import com.learnSphere.services.UsersServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	@Autowired
	StudentService sservice;
	
	@Autowired
	UsersServices uservice;
	
	@Autowired
	StudentService stservice;
	
	@GetMapping("/purchase")
	public String purchse(Model model) {
		List<Course> courseList=sservice.fetchCourse();
		model.addAttribute("courseList", courseList);
		return "purchaseCourse";
	}
	
	@GetMapping("/myCourses")
	public String myCourses(Model model, HttpSession session) {
		Users loggedUser=(Users) session.getAttribute("loggedInUser"); // fetching user object from session, which was created in usercontroller.
		String email=loggedUser.getEmail();
		Users user =uservice.findByEmail(email);
		List<Course> courseList=user.getCourseList();
		model.addAttribute("courseList", courseList);
		
		return "myCourses";
	}
	
	@GetMapping("/viewLesson")
	public String viewLesson(@RequestParam("lessonId")int lessonId,
							Model model,HttpSession session) {
		Lesson lesson = sservice.getLesson(lessonId);
		session.setAttribute("lessoninfo", lesson);
		// Extract the YouTube video id from the URL
	    String youtubeUrl = lesson.getLessonLink();
	    
	    String videoId = youtubeUrl.substring(youtubeUrl.indexOf("=") + 1);
	    lesson.setLessonLink(videoId);
		
		
		model.addAttribute("lesson",lesson);
		
		
		return "myLesson";
	}
	
	@PostMapping("/comment")
	public String addComment(@RequestParam("comment") String comment,
			Model model,HttpSession session)
	{
		Lesson lessonId=(Lesson) session.getAttribute("lessoninfo");
		
		model.addAttribute("lesson",lessonId);
		stservice.addComment(comment);
		return "myLesson";
	}

}
