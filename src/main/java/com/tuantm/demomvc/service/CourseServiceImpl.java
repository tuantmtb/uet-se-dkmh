package com.tuantm.demomvc.service;

import java.util.List;

import com.tuantm.demomvc.dao.CourseDao;
import com.tuantm.demomvc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	CourseDao courseDao;

	@Autowired
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public Course findById(Integer id) {
		return courseDao.findById(id);
	}

	@Override
	public List<Course> findAll() {
		return courseDao.findAll();
	}

	@Override
	public void saveOrUpdate(Course course) {

		if (findById(course.getId())==null) {
			courseDao.save(course);
		} else {
			courseDao.update(course);
		}

	}

	@Override
	public void delete(int id) {
		courseDao.delete(id);
	}

	@Override
	public void update(Course course) {
		courseDao.update(course);
	}

	@Override
	public void save(Course course) {
		courseDao.save(course);
	}
}