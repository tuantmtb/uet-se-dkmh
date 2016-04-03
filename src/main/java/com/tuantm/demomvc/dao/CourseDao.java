package com.tuantm.demomvc.dao;

import java.util.List;

import com.tuantm.demomvc.model.Course;

public interface CourseDao {

	Course findById(Integer id);

	List<Course> findAll();

	void save(Course course);

	void update(Course course);

	void delete(Integer id);

}