package com.myclass.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myclass.dto.CourseDto;
import com.myclass.entity.Course;
import com.myclass.repository.CourseRepository;
import com.myclass.service.CourseService;

@Service
@Scope("prototype")
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<CourseDto> findAll() {
		List<CourseDto> listCourseDto = new ArrayList<CourseDto>();
		try {
			List<Course> entities = courseRepository.findAll();
			for (Course entity : entities) {
				CourseDto courseDto = new CourseDto();
				courseDto.setId(entity.getId());
				courseDto.setTitle(entity.getTitle());
				courseDto.setImage(entity.getImage());
				courseDto.setLeturesCount(entity.getLeturesCount());
				courseDto.setHourCount(entity.getHourCount());
				courseDto.setViewCount(entity.getViewCount());
				courseDto.setPrice(entity.getPrice());
				courseDto.setDiscount(entity.getDiscount());
				courseDto.setPromotionPrice(entity.getPromotionPrice());
				courseDto.setDescription(entity.getDescription());
				courseDto.setContent(entity.getContent());
				courseDto.setCategoryId(entity.getCategoryId());
				courseDto.setLastUpdate(entity.getLastUpdate());
				
				listCourseDto.add(courseDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listCourseDto;
	}

	@Override
	public boolean insert(CourseDto courseDto) {
		try {
			Course entity = new Course(courseDto.getTitle(), courseDto.getImage(), courseDto.getLeturesCount(), courseDto.getHourCount()
					, courseDto.getViewCount(), courseDto.getPrice(), courseDto.getDiscount(), courseDto.getPromotionPrice()
					, courseDto.getDescription(), courseDto.getContent(), courseDto.getCategoryId(), courseDto.getLastUpdate());
			
			courseRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public CourseDto findById(int id) {
		CourseDto courseDto = new CourseDto();
		try {
			Course entity = courseRepository.findById(id).get();
			courseDto.setId(entity.getId());
			courseDto.setTitle(entity.getTitle());
			courseDto.setImage(entity.getImage());
			courseDto.setLeturesCount(entity.getLeturesCount());
			courseDto.setHourCount(entity.getHourCount());
			courseDto.setViewCount(entity.getViewCount());
			courseDto.setPrice(entity.getPrice());
			courseDto.setDiscount(entity.getDiscount());
			courseDto.setPromotionPrice(entity.getPromotionPrice());
			courseDto.setDescription(entity.getDescription());
			courseDto.setContent(entity.getContent());
			courseDto.setCategoryId(entity.getCategoryId());
			courseDto.setLastUpdate(entity.getLastUpdate());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return courseDto;
	}

	@Override
	public boolean update(int id, CourseDto courseDto) {
		try {
			Course entity = courseRepository.findById(id).get();
			entity.setTitle(courseDto.getTitle());
			entity.setImage(courseDto.getImage());
			entity.setLeturesCount(courseDto.getLeturesCount());
			entity.setHourCount(courseDto.getHourCount());
			entity.setViewCount(courseDto.getViewCount());
			entity.setPrice(courseDto.getPrice());
			entity.setDiscount(courseDto.getDiscount());
			entity.setPromotionPrice(courseDto.getPromotionPrice());
			entity.setDescription(courseDto.getDescription());
			entity.setContent(courseDto.getContent());
			entity.setCategoryId(courseDto.getCategoryId());
			entity.setLastUpdate(courseDto.getLastUpdate());
			
			courseRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			courseRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
}
