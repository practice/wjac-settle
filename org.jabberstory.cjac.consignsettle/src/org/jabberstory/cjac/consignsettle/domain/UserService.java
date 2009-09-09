package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;
import java.util.Set;

public interface UserService {

	public List<User> getUsers(String userQuery);

	public List<User> getAvailableUsers();
	
	public List<User> getUsersByUserGroup(String groupId);
	
	public List<UserGroup> getGroups(String groupQuery);
	
	public List<UserGroup> getGroupsByRole(String role);

	public void createUserGroup(String groupName, String role) 
		throws DuplicateEntityException;

	public UserGroup getUserGroup(String groupId);

	public void updateUserGroup(String groupId, String name, String role);
	
	public void updateUserGroupWithUsers(String groupId, Set<User> users);

	public void removeUserGroup(String groupId);

	public void createUser(String userId, String password, String username, String email) 
		throws DuplicateEntityException;
	
	public void createUser(String userId, String password, String username, String email, String role) 
	throws DuplicateEntityException;

	public User getUser(String userId);

}
