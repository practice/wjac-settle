package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;

public class UserGroupServiceImpl implements UserGroupService{

	private UserGroupDao userGroupDao;

	public void setUserGroupDao(UserGroupDao userGroupDao) {
		this.userGroupDao = userGroupDao;
	}

	@Override
	public void createUserGroup(UserGroup userGroup) throws DataAccessException {
		userGroupDao.createUserGroup(userGroup);
	}

	@Override
	public UserGroup getUserGroup(String groupId) throws DataAccessException {
		return userGroupDao.getUserGroup(groupId);
	}

	@Override
	public List<UserGroup> getUserGroups(String userId, String role)
			throws DataAccessException {
		return userGroupDao.getUserGroups(userId, role);
	}

	@Override
	public Paging getUserGroupsWithPaging(String userId, String role,
			int currentPage, int pageSize, String sortColumn)
			throws DataAccessException {
		return userGroupDao.getUserGroupsWithPaging(userId, role, currentPage, pageSize, sortColumn);
	}

	@Override
	public void removeUserGroup(String groupId) throws DataAccessException {
		userGroupDao.removeUserGroup(groupId);
	}

	@Override
	public void updateUserGroup(UserGroup userGroup) throws DataAccessException {
		userGroupDao.updateUserGroup(userGroup);
	}

	@Override
	public void updateUserGroup(String groupId, String costDetail)
			throws DataAccessException {
		userGroupDao.updateUserGroup(groupId, costDetail);
	}

}
