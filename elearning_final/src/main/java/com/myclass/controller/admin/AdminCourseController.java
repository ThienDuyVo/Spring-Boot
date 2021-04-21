package com.myclass.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.dto.CourseDto;
import com.myclass.service.CourseService;

@Controller
@RequestMapping("admin/course")
public class AdminCourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public String index(ModelMap model) {
		List<CourseDto> listCourse = courseService.findAll();
		model.addAttribute("listCourse", listCourse);
		return "course/index";
	}
	@GetMapping("/add")
	public String add(ModelMap model) {
		CourseDto courseDto = new CourseDto();
		model.addAttribute("courseDto", courseDto);
		return "course/add";
	}
}
