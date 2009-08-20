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
	public void createUserGroup(String groupId, String name, String role) throws DuplicateUserGroupException {
		UserGroup group = userRepository.getUserGroup(groupId);
		if (group != null) {
			throw new DuplicateUserGroupException("Already existing User Group with group id = " + groupId);		
		}
		userRepository.createUserGroup(groupId, name, role);
	}

	@Override
	public UserGroup getUserGroup(String groupId) {
		return userRepository.getUserGroup(groupId);
	}

}
