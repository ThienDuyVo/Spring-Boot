package com.myclass.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myclass.dto.TargetDto;
import com.myclass.entity.Target;
import com.myclass.repository.TargetRepository;
import com.myclass.service.TargetService;

@Service
@Scope("prototype")
public class TargetServiceImpl implements TargetService{

	@Autowired
	private TargetRepository targetRepository;

	@Override
	public List<TargetDto> findAll() {
		List<TargetDto> listTargetDto = new ArrayList<TargetDto>();
		try {
			List<Target> entitties = targetRepository.findAll();
			for (Target entity : entitties) {
				TargetDto targetDto = new TargetDto();
				targetDto.setId(entity.getId());
				targetDto.setTitle(entity.getTitle());
				targetDto.setCourseId(entity.getCourseId());
				
				listTargetDto.add(targetDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listTargetDto;
	}

	@Override
	public boolean insert(TargetDto targetDto) {
		try {
			Target entity = new Target(targetDto.getTitle(), targetDto.getCourseId());
			targetRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public TargetDto findById(int id) {
		TargetDto targetDto = new TargetDto();
		try {
			Target entity = targetRepository.findById(id).get();
			targetDto.setId(entity.getId());
			targetDto.setTitle(entity.getTitle());
			targetDto.setCourseId(entity.getCourseId());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return targetDto;
	}

	@Override
	public boolean update(int id, TargetDto targetDto) {
		try {
			Target entity = targetRepository.findById(id).get();
			entity.setTitle(targetDto.getTitle());
			entity.setCourseId(targetDto.getCourseId());
			targetRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			targetRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
