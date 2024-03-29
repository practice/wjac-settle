package org.jabberstory.cjac.consignsettle.controller;

public class CreateUserGroupCommand {
	private String groupId;
	private String groupName;
	private String role;
	private String parentGroup;
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
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
	public void setParentGroup(String parentGroup) {
		this.parentGroup = parentGroup;
	}
	public String getParentGroup() {
		return parentGroup;
	}
}
