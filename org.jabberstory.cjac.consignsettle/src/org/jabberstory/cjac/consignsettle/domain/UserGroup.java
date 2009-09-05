package org.jabberstory.cjac.consignsettle.domain;

import java.util.HashSet;
import java.util.Set;

public class UserGroup {

	private String groupId;
	private String groupName;
	private String role; // admin(A), consignee(C, 회계법인), owner(O, 전담), // subject(S, 주관)
	private Set<User> users = new HashSet<User>(0);
	private Set<Organ> organs = new HashSet<Organ>(0);

	public UserGroup() {
	}

	public UserGroup(String groupName, String role) {
		this.groupName = groupName;
		this.role = role;		
	}
	
	public UserGroup(String groupName, String role, Set<User> users,
			Set<Organ> organs) {
		this.groupName = groupName;
		this.role = role;
		this.users = users;
		this.organs = organs;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Organ> getOrgans() {
		return this.organs;
	}

	public void setOrgans(Set<Organ> organs) {
		this.organs = organs;
	}

}
