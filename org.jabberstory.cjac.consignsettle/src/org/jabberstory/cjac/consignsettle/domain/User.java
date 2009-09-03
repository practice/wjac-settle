package org.jabberstory.cjac.consignsettle.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String userId;
	private String username;
	private String email;
	private String password;
	private String role;
	private Set<UserGroup> userGroups = new HashSet<UserGroup>();
	
	public User() {
	}

	public User(String userId, String username, String email, String password) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User(String userId, String username, String email, String password, String role) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public User(String userId, String username, String email, String password, String role, Set<UserGroup> userGroups) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.userGroups = userGroups;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
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

	public Set<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

}
