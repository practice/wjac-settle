package org.jabberstory.cjac.consignsettle.controller;

import java.util.HashSet;
import java.util.Set;

import org.jabberstory.cjac.consignsettle.domain.UserGroup;

public class CreateUserCommand {
	private String userId;
	private String password;
	private String passwordConfirm;
	private String username;
	private String email;
	private String role;
	private Set<UserGroup> userGroup = new HashSet<UserGroup>();
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<UserGroup> getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(Set<UserGroup> userGroup) {
		this.userGroup = userGroup;
	}

	public String getPassword() {
		return password;
	}
		
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
