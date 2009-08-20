package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

public interface UserService {

	public List<User> getUsers(String userQuery);

	public List<UserGroup> getGroups(String groupQuery);

	void createUserGroup(String groupId, String name, String role) throws DuplicateUserGroupException;

	public UserGroup getUserGroup(String groupId);

}
