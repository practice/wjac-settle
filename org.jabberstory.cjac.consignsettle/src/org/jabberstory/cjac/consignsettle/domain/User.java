package org.jabberstory.cjac.consignsettle.domain;

public class User {
	private String userId;
	private String username;
	private String email;
	private String password;
	
	public User() {
	}
	
	public User(String userId, String password) {
		this.setUserId(userId);
		this.setPassword(password);
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
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

	public boolean hasRole(Role role) {
		return false;
	}

}
