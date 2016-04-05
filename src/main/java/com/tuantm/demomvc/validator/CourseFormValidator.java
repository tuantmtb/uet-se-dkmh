package com.tuantm.demomvc.validator;

import com.tuantm.demomvc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tuantm.demomvc.service.CourseService;

@Component
public class CourseFormValidator implements Validator {

    @Autowired
    CourseService courseService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Course.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Course course = (Course) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id_course", "NotEmpty.courseForm.id_course");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name_course", "NotEmpty.courseForm.name_course");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tiet", "NotEmpty.courseForm.tiet");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "si_so", "NotEmpty.courseForm.si_so");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "giao_vien", "NotEmpty.courseForm.giao_vien");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phong_hoc", "NotEmpty.courseForm.phong_hoc");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "so_tin_chi", "NotEmpty.courseForm.so_tin_chi");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tiet", "NotEmpty.courseForm.tiet");

    }

}