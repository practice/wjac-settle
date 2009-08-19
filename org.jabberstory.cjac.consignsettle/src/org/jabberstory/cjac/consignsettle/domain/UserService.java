package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

public interface UserService {

	List<User> getUsers(String userQuery);

	List<UserGroup> getGroups(String groupQuery);

}
