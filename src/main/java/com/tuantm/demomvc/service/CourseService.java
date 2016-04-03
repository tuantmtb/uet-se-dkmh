package com.tuantm.demomvc.service;

import java.util.List;

import com.tuantm.demomvc.model.Course;

public interface CourseService {

	Course findById(Integer id);
	
	List<Course> findAll();

	void saveOrUpdate(Course course);
	
	void delete(int id);
	
}