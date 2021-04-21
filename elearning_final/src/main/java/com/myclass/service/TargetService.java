package com.myclass.service;

import java.util.List;

import com.myclass.dto.TargetDto;

public interface TargetService {

	List<TargetDto> findAll();
	boolean insert(TargetDto targetDto);
	TargetDto findById(int id);
	boolean update(int id, TargetDto targetDto);
	boolean delete(int id);
}
