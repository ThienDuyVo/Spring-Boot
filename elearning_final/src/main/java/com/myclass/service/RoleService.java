package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDto;

public interface RoleService {

	List<RoleDto> findAll();
	boolean insert(RoleDto roleDto);
	RoleDto findById(int id);
	boolean update(int id, RoleDto roleDto);
	boolean delete(int id);
}
