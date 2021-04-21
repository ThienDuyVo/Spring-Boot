package com.myclass.dto;

public class UserDto {

	private int id;
	private String email;
	private String passWord;
	private String fullName;
	private String phone;
	private String address;
	private String avatar;
	private int roleId;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(String email, String passWord, String fullName, String phone, String address, String avatar,
			int roleId) {

		this.email = email;
		this.passWord = passWord;
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
		this.avatar = avatar;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
