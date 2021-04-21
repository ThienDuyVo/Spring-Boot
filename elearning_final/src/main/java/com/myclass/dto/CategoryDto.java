package com.myclass.dto;

public class CategoryDto {

	private int id;
	private String title;
	private String icon;
	
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(String title, String icon) {

		this.title = title;
		this.icon = icon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
