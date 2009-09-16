package org.jabberstory.cjac.consignsettle.domain;


public class User {
	private String userId;
	private String username;
	private String email;
	private String password;
	private String postnum1;
	private String postnum2;
	private String address;
	private String phone1;
	private String phone2;
	private String phone3;
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
	public User(String userId, String username, String email, String password, 
			String postnum1, String postnum2, String address, String phone1, String phone2, 
			String phone3,UserGroup userGroup) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.postnum1 = postnum1;
		this.postnum2 = postnum2;
		this.address = address;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
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

	public String getPostnum1() {
		return postnum1;
	}

	public void setPostnum1(String postnum1) {
		this.postnum1 = postnum1;
	}

	public String getPostnum2() {
		return postnum2;
	}

	public void setPostnum2(String postnum2) {
		this.postnum2 = postnum2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@Override
	public String toString() {
		return "User [address=" + address + ", email=" + email + ", password="
				+ password + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", phone3=" + phone3 + ", postnum1=" + postnum1
				+ ", postnum2=" + postnum2 + ", userId=" + userId
				+ ", username=" + username + "]";
	}

}
