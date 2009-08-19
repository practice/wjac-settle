package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

public interface UserService {

	List<User> getUsers(String userQuery);

	List<UserGroup> getGroups(String groupQuery);

	void createUserGroup(String groupId, String name, String role) throws DuplicateUserGroupException;

}
