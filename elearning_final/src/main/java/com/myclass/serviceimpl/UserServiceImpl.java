package com.myclass.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
@Scope("prototype")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> findAll() {
		List<UserDto> listUserDto = new ArrayList<UserDto>();
		
		try {
			List<User> entities = userRepository.findAll();
			for (User entity : entities) {
				UserDto userDto = new UserDto();
				userDto.setId(entity.getId());
				userDto.setEmail(entity.getEmail());
				userDto.setPassWord(entity.getPassword());
				userDto.setFullName(entity.getFullName());
				userDto.setAvatar(entity.getAvatar());
				userDto.setPhone(entity.getPhone());
				userDto.setAddress(entity.getAddress());
				userDto.setRoleId(entity.getRoleId());
				
				listUserDto.add(userDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listUserDto;
	}

	@Override
	public boolean insert(UserDto userDto) {
		try {
			User entity = new User(userDto.getEmail(), userDto.getFullName(), userDto.getPassWord()
					, userDto.getAvatar(), userDto.getPhone(), userDto.getAddress(), userDto.getRoleId());
			
			userRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public UserDto findById(int id) {
		UserDto userDto = new UserDto();
		try {
			User entity = userRepository.findById(id).get();
			userDto.setId(entity.getId());
			userDto.setEmail(entity.getEmail());
			userDto.setPassWord(entity.getPassword());
			userDto.setFullName(entity.getFullName());
			userDto.setAvatar(entity.getAvatar());
			userDto.setPhone(entity.getPhone());
			userDto.setAddress(entity.getAddress());
			userDto.setRoleId(entity.getRoleId());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userDto;
	}

	@Override
	public boolean update(int id, UserDto userDto) {
		try {
			User entity = userRepository.findById(id).get();
			entity.setEmail(userDto.getEmail());
			entity.setPassword(userDto.getPassWord());
			entity.setFullName(userDto.getFullName());
			entity.setAvatar(userDto.getAvatar());
			entity.setPhone(userDto.getPhone());
			entity.setAddress(userDto.getAddress());
			entity.setRoleId(userDto.getRoleId());
			
			userRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
