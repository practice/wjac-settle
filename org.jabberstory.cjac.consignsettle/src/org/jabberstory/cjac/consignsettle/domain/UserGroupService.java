package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;

public interface UserGroupService {
	List<UserGroup> getUserGroups(String userId, String role) throws DataAccessException;

	Paging getUserGroupsWithPaging(String userId, String role, int currentPage, int pageSize, String sortColumn) throws DataAccessException;

	UserGroup getUserGroup(String groupId) throws DataAccessException;

	void createUserGroup(UserGroup userGroup) throws DataAccessException;

	void updateUserGroup(UserGroup userGroup) throws DataAccessException;

	void removeUserGroup(String groupId) throws DataAccessException;

	void updateUserGroup(String groupId, String costDetail) throws DataAccessException;
}
