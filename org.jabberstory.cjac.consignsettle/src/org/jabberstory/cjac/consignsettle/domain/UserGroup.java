package org.jabberstory.cjac.consignsettle.domain;

import java.util.HashSet;
import java.util.Set;

public class UserGroup {
	private String groupId;
	private String name;
	private String role;	// admin(A), consignee(C, 회계법인), owner(O, 전담), subject(S, 주관)
	private Set<User> users = new HashSet<User>();

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

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<User> getUsers() {
		return users;
	}	
}
