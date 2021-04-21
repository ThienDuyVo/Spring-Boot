package com.myclass.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;
import com.myclass.service.CategoryService;

@Service
@Scope("prototype")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryDto> findAll() {
		List<CategoryDto> listCategoryDto = new ArrayList<CategoryDto>();
		try {
			List<Category> entities = categoryRepository.findAll();
			for (Category entity : entities) {
				CategoryDto categoryDto = new CategoryDto();
				categoryDto.setId(entity.getId());
				categoryDto.setTitle(entity.getTitle());
				categoryDto.setIcon(entity.getIcon());
				
				listCategoryDto.add(categoryDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listCategoryDto;
	}

	@Override
	public boolean insert(CategoryDto categoryDto) {
		try {
			Category entity = new Category(categoryDto.getTitle(), categoryDto.getIcon());
			categoryRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public CategoryDto findById(int id) {
		CategoryDto categoryDto = new CategoryDto();
		try {
			Category entity = categoryRepository.findById(id).get();
			categoryDto.setId(entity.getId());
			categoryDto.setTitle(entity.getTitle());
			categoryDto.setIcon(entity.getIcon());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return categoryDto;
	}

	@Override
	public boolean update(int id, CategoryDto categoryDto) {
		try {
			Category entity = categoryRepository.findById(id).get();
			entity.setTitle(categoryDto.getTitle());
			entity.setIcon(categoryDto.getIcon());
			
			categoryRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			categoryRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
