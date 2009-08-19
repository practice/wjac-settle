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

}
