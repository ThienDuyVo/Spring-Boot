package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDto;

public interface UserService {

	List<UserDto> findAll();
	boolean insert(UserDto userDto);
	UserDto findById(int id);
	boolean update(int id, UserDto userDto);
	boolean delete(int id);
	
}
