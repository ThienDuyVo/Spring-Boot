package com.myclass.dto;

public class RoleDto {

	private int id;
	private String name;
	private String description;
	
	public RoleDto() {
		// TODO Auto-generated constructor stub
	}

	public RoleDto(String name, String description) {

		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
