package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;
import java.util.Set;

import org.jabberstory.cjac.forum.domain.Forum;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.springframework.dao.DataAccessException;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private ForumService forumService;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
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
	public void createUserGroup(String groupName, String role, String parentGroupId) throws DuplicateEntityException {
//		UserGroup group = userRepository.getUserGroup(groupId);
//		if (group != null) {
//			throw new DuplicateEntityException("Already existing User Group with group id = " + groupId);		
//		}
		UserGroup userGroup = userRepository.createUserGroup(groupName, role);
		if (userGroup.isOwner()) {
			forumService.createForum(userGroup.getGroupId(), Forum.PUBLIC_TYPE, "공지사항");
			forumService.createForum(userGroup.getGroupId(), Forum.QNA_TYPE, "Q &amp; A");
			forumService.createForum(userGroup.getGroupId(), Forum.FILES_TYPE, "자료실");
		}
		if (userGroup.isSubject()) {
			UserGroup parent = userRepository.getUserGroup(parentGroupId);
			userGroup.setParentGroup(parent);
		}
	}

	@Override
	public UserGroup getUserGroup(String groupId) {
		return userRepository.getUserGroup(groupId);
	}

	@Override
	public void updateUserGroup(String groupId, String name, String role, String parentGroupId) {
		UserGroup userGroup = userRepository.updateUserGroup(groupId, name, role);
		if (userGroup.isOwner()) {
			List<Forum> forums = forumService.getForumsForGroup(userGroup.getGroupId());
			if (forums.size() == 0) {
				forumService.createForum(userGroup.getGroupId(), Forum.PUBLIC_TYPE, "공지사항");
				forumService.createForum(userGroup.getGroupId(), Forum.QNA_TYPE, "Q &amp; A");
				forumService.createForum(userGroup.getGroupId(), Forum.FILES_TYPE, "자료실");
			}
		}
		// parent handling.
		if (userGroup.isSubject()) {
			UserGroup parent = userRepository.getUserGroup(parentGroupId);
			userGroup.setParentGroup(parent);
		} else {
			userGroup.setParentGroup(null);
		}
	}
	
	public void updateUserGroupWithUsers(String groupId, Set<User> users) {
		userRepository.updateUserGroupWithUsers(groupId, users);
	}

	@Override
	public void removeUserGroup(String groupId) {
		userRepository.removeUserGroup(groupId);
	}
	
	@Override
	public void removeUser(String userId) {
		userRepository.removeUser(userId);
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
	public String getUserRole(String userId){
		User user = userRepository.getUser(userId);
		
		if(user.getUserGroup() == null) return "";
		
		return user.getUserGroup().getRole();		
	}

	@Override
	public void updateUser(String userId, String password, String username,
			String email) {
		userRepository.updateUser(userId, password, username, email);		
	}

}
