package org.jabberstory.cjac.consignsettle.domain;


public class User {
	private String userId;
	private String username;
	private String email;
	private String password;
	private UserGroup userGroup;
	
	public User() {
	}

	public User(String userId) {
        this.userId = userId;
    }
	
	public User(String userId, String username, String email, String password) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(String userId, String username, String email, String password, UserGroup userGroup) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userGroup = userGroup;
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

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", userId="
				+ userId + ", username=" + username + "]";
	}

}
