package com.learnSphere.services;

import java.util.List;

import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;

public interface StudentService {
	List<Course> fetchCourse();
    Course fetchCourse(int courseId);
    Lesson getLesson(int lessonId);
    void addComment(String comment);
}
