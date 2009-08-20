package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

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
	public void createUserGroup(String groupId, String name, String role) throws DuplicateEntityException {
		UserGroup group = userRepository.getUserGroup(groupId);
		if (group != null) {
			throw new DuplicateEntityException("Already existing User Group with group id = " + groupId);		
		}
		userRepository.createUserGroup(groupId, name, role);
	}

	@Override
	public UserGroup getUserGroup(String groupId) {
		return userRepository.getUserGroup(groupId);
	}

	@Override
	public void updateUserGroup(String groupId, String name, String role) {
		userRepository.updateUserGroup(groupId, name, role);
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

}
