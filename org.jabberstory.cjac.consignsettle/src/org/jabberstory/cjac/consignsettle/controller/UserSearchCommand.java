package org.jabberstory.cjac.consignsettle.controller;

public class UserSearchCommand {
	private String userQuery;
	private String groupQuery;
	
	public void setUserQuery(String userQuery) {
		this.userQuery = userQuery;
	}
	public String getUserQuery() {
		return userQuery;
	}
	public void setGroupQuery(String groupQuery) {
		this.groupQuery = groupQuery;
	}
	public String getGroupQuery() {
		return groupQuery;
	}
}
