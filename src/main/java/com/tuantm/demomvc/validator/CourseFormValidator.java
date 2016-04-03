package com.tuantm.demomvc.validator;

import com.tuantm.demomvc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tuantm.demomvc.service.CourseService;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
@Component
public class CourseFormValidator implements Validator {

	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
	@Autowired
	CourseService courseService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Course.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Course course = (Course) target;
//
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id_course", "NotEmpty.courseForm.id_course");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tiet", "NotEmpty.courseForm.tiet");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "si_so", "NotEmpty.courseForm.si_so");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "giao_vien", "NotEmpty.courseForm.giao_vien");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phong_hoc","NotEmpty.courseForm.phong_hoc");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "so_tin_chi", "NotEmpty.courseForm.so_tin_chi");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ghi_chu", "NotEmpty.courseForm.ghi_chu");


//		if(course.getNumber()==null || course.getNumber()<=0){
//			errors.rejectValue("number", "NotEmpty.courseForm.number");
//		}
//
//		if(course.getCountry().equalsIgnoreCase("none")){
//			errors.rejectValue("country", "NotEmpty.courseForm.country");
//		}
//
//		if (!course.getPassword().equals(course.getConfirmPassword())) {
//			errors.rejectValue("confirmPassword", "Diff.courseform.confirmPassword");
//		}
//
//		if (course.getFramework() == null || course.getFramework().size() < 2) {
//			errors.rejectValue("framework", "Valid.courseForm.framework");
//		}
//
//		if (course.getSkill() == null || course.getSkill().size() < 3) {
//			errors.rejectValue("skill", "Valid.courseForm.skill");
//		}

	}

}