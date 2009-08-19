package org.jabberstory.cjac.consignsettle.controller;

public class CreateUserGroupCommand {
	private String groupId;
	private String name;
	private String role;
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		return role;
	}
}
