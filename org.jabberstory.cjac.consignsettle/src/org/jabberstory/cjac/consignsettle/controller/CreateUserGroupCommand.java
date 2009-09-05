package org.jabberstory.cjac.consignsettle.controller;

public class CreateUserGroupCommand {
	private String groupName;
	private String role;
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
}
