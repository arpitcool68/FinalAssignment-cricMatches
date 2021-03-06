package com.stackroute.userservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user")
public class User {

	@Id
	private String userId;
	private String password;
	private String cpassword;

	public User() {
		super();
	}

	public User(String userId, String password, String cpassword) {
		super();
		this.userId = userId;
		this.password = password;
		this.cpassword = cpassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", cpassword=" + cpassword + "]";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId=userId;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password=password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword=cpassword;
	}

}
