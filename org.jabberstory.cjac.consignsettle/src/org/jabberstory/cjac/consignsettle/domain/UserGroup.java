package org.jabberstory.cjac.consignsettle.domain;

public class UserGroup {
	private String groupId;
	private String name;
	private String role;	// admin(A), consignee(C, 천지), owner(O, 전담), subject(S, 주관)

	public UserGroup() {
	}
	
	public UserGroup(String groupId, String name, String role) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.role = role;
	}

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
