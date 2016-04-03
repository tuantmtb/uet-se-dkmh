package com.tuantm.demomvc.web;

import com.tuantm.demomvc.model.Course;
import com.tuantm.demomvc.service.CourseService;
import com.tuantm.demomvc.validator.CourseFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

//import javax.validation.Valid;

//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
@RestController
public class CourseController {

    private final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseFormValidator courseFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(courseFormValidator);
    }

    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

//
//    // list
//    @RequestMapping(value = "/api/course/all", method = RequestMethod.GET)
//    public @ResponseBody List<Course> showAllcourses() {
//        logger.debug("API: showAllcourses()");
//        List<Course> courses = courseService.findAll();
//        if (courses.isEmpty()) {
//            return null;
//        }
//        return courses;
//
//    }
    @RequestMapping(value = "/api/course/all", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> showAllcourses() {
        logger.debug("API: showAllcourses()");
        List<Course> courses = courseService.findAll();
        if (courses.isEmpty()) {
            return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);

    }

    // create
    @RequestMapping(value = "/api/create/course", method = RequestMethod.POST)
    public ResponseEntity<Void> createCourse(@Validated @RequestBody Course course, UriComponentsBuilder ucBuilder) {

        logger.debug("API createCourse() : {}", course);


        if (!course.isNew()) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        courseService.saveOrUpdate(course);

        // POST/REDIRECT/GET
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/course/{id}").buildAndExpand(course.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // update
    @RequestMapping(value = "/api/update/course/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Integer id, @RequestBody Course course) {

        logger.debug("API updateCourse() : {}", course);
        Course currentCourse = courseService.findById(id);

        if (currentCourse == null) {
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
//        currentCourse.setTiet(course.getTiet());
//        currentCourse.setName_course(course.getName_course());
//        currentCourse.setPhong_hoc(course.getPhong_hoc());
//        currentCourse.setGhi_chu(course.setName_course());
        courseService.saveOrUpdate(course);
        return new ResponseEntity<Course>(currentCourse, HttpStatus.OK);
    }

    // delete course
    @RequestMapping(value = "/api/course/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Course> deleteCourse(@PathVariable("id") int id) {

        logger.debug("API:deletecourse() : {}", id);
        Course course = courseService.findById(id);
        if (course == null) {
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
        courseService.delete(id);
        return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
    }

    // show course
//    @RequestMapping(value = "/api/course/{id}", method = RequestMethod.GET)
//    public @ResponseBody Course showCourse(@PathVariable("id") int id) {
//
//        logger.debug("API: showcourse() id: {}", id);
//
//        Course course = courseService.findById(id);
//        if (course == null) {
//            return null;
//        }
//        return course;
//    }
    // show course
    @RequestMapping(value = "/api/course/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> showCourse(@PathVariable("id") int id) {

        logger.debug("API: showcourse() id: {}", id);

        Course course = courseService.findById(id);
        if (course == null) {
            return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

}