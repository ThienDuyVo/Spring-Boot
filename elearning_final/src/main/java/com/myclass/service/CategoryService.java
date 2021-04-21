package com.myclass.service;

import java.util.List;

import com.myclass.dto.CategoryDto;

public interface CategoryService {

	List<CategoryDto> findAll();
	boolean insert(CategoryDto categoryDto);
	CategoryDto findById(int id);
	boolean update(int id, CategoryDto categoryDto);
	boolean delete(int id);
}
