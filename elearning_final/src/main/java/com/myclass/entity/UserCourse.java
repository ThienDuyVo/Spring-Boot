package com.myclass.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_course")
public class UserCourse implements Serializable{

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", insertable =  false, updatable = false)
	private User user;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	private Course course;
	
	@Column(name = "role_id", length = 11)
	private int roleId;
}
