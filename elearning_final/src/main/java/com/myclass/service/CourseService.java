package com.myclass.service;

import java.util.List;

import com.myclass.dto.CourseDto;

public interface CourseService {

	List<CourseDto> findAll();
	boolean insert(CourseDto courseDto);
	CourseDto findById(int id);
	boolean update(int id, CourseDto courseDto);
	boolean delete(int id);
}
