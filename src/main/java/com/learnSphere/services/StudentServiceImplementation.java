package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entities.Comment;
import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;
import com.learnSphere.repositories.LessonRepository;
import com.learnSphere.repositories.StudentRepository;
import com.learnSphere.repositories.TrainerRepository;

@Service
public class StudentServiceImplementation implements StudentService{

	@Autowired
	TrainerRepository repo;
	
	@Autowired
	LessonRepository lrepo;
	
	@Autowired
	StudentRepository srepo;
	
	@Override
	public List<Course> fetchCourse() {
		return	repo.findAll();
		
	}
	@Override
	public Course fetchCourse(int courseId) {
		
		return repo.findByCourseId(courseId);
	}
	@Override
	public Lesson getLesson(int lessonId) {
		return lrepo.findByLessonId(lessonId);
	}
	@Override
	public void addComment(String comment) {
		Comment com = new Comment();
		com.setComment(comment);
		srepo.save(com);
		
	}

}
