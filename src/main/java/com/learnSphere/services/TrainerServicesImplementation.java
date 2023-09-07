package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;
import com.learnSphere.repositories.LessonRepository;
import com.learnSphere.repositories.TrainerRepository;

@Service
public class TrainerServicesImplementation implements TrainerServices{

	@Autowired
	TrainerRepository repo;
	
	@Autowired
	LessonRepository lrepo;
	@Override
	public String addCourse(Course course) {
		repo.save(course);
		return "course added sucessfully";
	}
	
	@Override
	public List<Course> fetchAllCourses() {
		
		return repo.findAll();
	}

	@Override
	public String addLesson(Lesson lesson) {
        lrepo.save(lesson);
		return "lesson added";
	}

	@Override
	public String saveCourse(Course course) {
		repo.save(course);
		return "course updated";
	}

}
