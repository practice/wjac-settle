package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

public interface UserService {

	public List<User> getUsers(String userQuery);

//	public List<UserGroup> getGroups(String groupQuery);
//
//	public void createUserGroup(String groupId, String name, String role) 
//		throws DuplicateEntityException;
//
//	public UserGroup getUserGroup(String groupId);
//
//	public void updateUserGroup(String groupId, String name, String role);
//
//	public void removeUserGroup(String groupId);

	public void createUser(String userId, String password, String username, String email) 
		throws DuplicateEntityException;
	
	public void createUser(String userId, String password, String username, String email, String role) 
	throws DuplicateEntityException;

	public User getUser(String userId);

}
