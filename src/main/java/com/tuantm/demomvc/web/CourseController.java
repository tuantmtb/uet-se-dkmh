package com.tuantm.demomvc.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tuantm.demomvc.model.Course;
import com.tuantm.demomvc.service.CourseService;
import com.tuantm.demomvc.validator.CourseFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("index()");
        return "redirect:/courses";
    }

    // list page
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String showAllcourses(Model model) {

        logger.debug("showAllCourses()");
        model.addAttribute("courses", courseService.findAll());
        return "courses/list";

    }

    // save or update course
    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public String saveOrUpdatecourse(@ModelAttribute("courseForm") @Validated Course course,
                                     BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        logger.debug("saveOrUpdatecourse() : {}", course);

        if (result.hasErrors()) {
            return "courses/courseform";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (course.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "Tạo môn học thành công!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Cập nhật môn học thành công!");
            }

            courseService.saveOrUpdate(course);
            return "redirect:/courses/" + course.getId();
        }

    }

    // show add course form
    @RequestMapping(value = "/courses/add", method = RequestMethod.GET)
    public String showAddcourseForm(Model model) {

        logger.debug("showAddcourseForm()");

        Course course = new Course();
        course.setTiet("1-3");
        model.addAttribute("courseForm", course);

//		populateDefaultModel(model);

        return "courses/courseform";

    }

    // show update form
    @RequestMapping(value = "/courses/{id}/update", method = RequestMethod.GET)
    public String showUpdatecourseForm(@PathVariable("id") int id, Model model) {

        logger.debug("showUpdatecourseForm() : {}", id);

        Course course = courseService.findById(id);
        model.addAttribute("courseForm", course);
        return "courses/courseform";

    }

    // delete course
    @RequestMapping(value = "/courses/{id}/delete", method = RequestMethod.POST)
    public String deletecourse(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        logger.debug("deletecourse() : {}", id);

        courseService.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Môn học đã được xóa!");

        return "redirect:/courses";

    }

    // show course
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.GET)
    public String showcourse(@PathVariable("id") int id, Model model) {

        logger.debug("showcourse() id: {}", id);

        Course course = courseService.findById(id);
        if (course == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Không tìm thấy khóa học");
        }
        model.addAttribute("course", course);
        return "courses/show";

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

        logger.debug("handleEmptyData()");
        logger.error("Request: {}, error ", req.getRequestURL(), ex);

        ModelAndView model = new ModelAndView();
        model.setViewName("course/show");
        model.addObject("msg", "Không tìm thấy khóa học");

        return model;

    }

}