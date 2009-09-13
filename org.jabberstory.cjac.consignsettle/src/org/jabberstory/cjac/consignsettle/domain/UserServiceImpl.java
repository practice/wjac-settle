package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserGroup> getGroups(String groupQuery) {
		return userRepository.getGroups(groupQuery);
	}

	@Override
	public List<User> getUsers(String userQuery) {
		return userRepository.getUsers(userQuery);
	}
	
	@Override
	public List<User> getAvailableUsers() {
		return userRepository.getAvailableUsers();
	}
	
	@Override
	public List<User> getUsersByGroupId(String groupId)
			throws DataAccessException {
		
		return userRepository.getUsersByGroupId(groupId);
	}
	
	@Override
	public List<UserGroup> getGroupsByRole(String role)
			throws DataAccessException {
		
		return userRepository.getGroupsByRole(role);
	}

	@Override
	public void createUserGroup(String groupName, String role) throws DuplicateEntityException {
//		UserGroup group = userRepository.getUserGroup(groupId);
//		if (group != null) {
//			throw new DuplicateEntityException("Already existing User Group with group id = " + groupId);		
//		}
		userRepository.createUserGroup(groupName, role);
	}

	@Override
	public UserGroup getUserGroup(String groupId) {
		return userRepository.getUserGroup(groupId);
	}

	@Override
	public void updateUserGroup(String groupId, String name, String role) {
		userRepository.updateUserGroup(groupId, name, role);
	}
	
	public void updateUserGroupWithUsers(String groupId, Set<User> users) {
		userRepository.updateUserGroupWithUsers(groupId, users);
	}

	@Override
	public void removeUserGroup(String groupId) {
		userRepository.removeUserGroup(groupId);
	}

	@Override
	public void createUser(String userId, String password, String username, String email) throws DuplicateEntityException {
		User user = userRepository.getUser(userId);
		if (user != null)
			throw new DuplicateEntityException("Already existing user with user id = " + userId);
		userRepository.createUser(userId, password, username, email);
	}
	
	@Override
	public User getUser(String userId) {
		return userRepository.getUser(userId);
	}

	@Override
	public void createUser(String userId, String password, String username,
			String email, String role) throws DuplicateEntityException {
		userRepository.createUser(userId, password, username, email);
		
	}

}
