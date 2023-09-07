package com.learnSphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entities.Comment;

public interface StudentRepository extends JpaRepository<Comment, Integer> {

	void save(String comment);

	

	
	


}
