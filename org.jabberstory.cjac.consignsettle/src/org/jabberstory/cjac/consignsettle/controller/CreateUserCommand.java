package org.jabberstory.cjac.consignsettle.controller;

public class CreateUserCommand {
	private String userId;
	private String password;
	private String passwordConfirm;
	private String username;
	private String email;
	private String postnum1;
	private String postnum2;
	private String address;
	private String phone1;
	private String phone2;
	private String phone3;
	private String groupId;
	
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	

}
