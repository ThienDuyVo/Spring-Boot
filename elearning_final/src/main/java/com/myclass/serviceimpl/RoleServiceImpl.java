package com.myclass.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
@Scope("prototype")
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<RoleDto> findAll() {
		List<RoleDto> listRoleDto = new ArrayList<RoleDto>();
		try {
			List<Role> entities = roleRepository.findAll();
			for (Role entity : entities) {
				RoleDto roleDto = new RoleDto();
				roleDto.setId(entity.getId());
				roleDto.setName(entity.getName());
				roleDto.setDescription(entity.getDescription());
				
				listRoleDto.add(roleDto);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listRoleDto;
	}

	@Override
	public boolean insert(RoleDto roleDto) {
		try {
			Role entity = new Role(roleDto.getName(), roleDto.getDescription());
			roleRepository.save(entity);
			return true;
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public RoleDto findById(int id) {
		RoleDto roleDto = new RoleDto();
		try {
			Role entity = roleRepository.findById(id).get();
			roleDto.setId(entity.getId());
			roleDto.setName(entity.getName());
			roleDto.setDescription(entity.getDescription());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return roleDto;
	}

	@Override
	public boolean update(int id, RoleDto roleDto) {
		try {
			Role entity = roleRepository.findById(id).get();
			entity.setName(roleDto.getName());
			entity.setDescription(roleDto.getDescription());
			
			roleRepository.save(entity);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			roleRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
