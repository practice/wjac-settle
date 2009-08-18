package org.jabberstory.cjac.consignsettle.domain;

public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
