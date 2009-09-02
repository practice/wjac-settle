package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserGroupDaoImpl extends HibernateDaoSupport implements UserGroupDao{

	@Override
	public void createUserGroup(UserGroup userGroup) throws DataAccessException {
		getHibernateTemplate().save(userGroup);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserGroup> getUserGroups(String userId, String role)
			throws DataAccessException {
		
		// 권한별로 쿼리를 해야하는데...좀 골치가 아프군.
		String queryString = "from UserGroup o";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {}, 
				new Object[] {});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Paging getUserGroupsWithPaging(String userId, String role, int currentPage, int pageSize, String sortColumn) throws DataAccessException {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getUserGroups(userId, role).size();
		final Order order = (sortColumn == "") ? Order.asc("groupName"): Order.desc(sortColumn);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(UserGroup.class);
        criteria.addOrder(order);
        List userGroups = (List)getHibernateTemplate().findByCriteria(criteria, fromRowNum, toRowNum);
		
		return new Paging((List)userGroups, totalCount, currentPage);
	}

	@Override
	public UserGroup getUserGroup(String groupId) throws DataAccessException {
		return (UserGroup) getHibernateTemplate().get(UserGroup.class, groupId);
	}

	@Override
	public void removeUserGroup(String groupId) throws DataAccessException {
		getHibernateTemplate().delete(getUserGroup(groupId));		
	}

	@Override
	public void updateUserGroup(UserGroup userGroup) throws DataAccessException {
		getHibernateTemplate().update(userGroup);	
	}

	@Override
	public void updateUserGroup(String groupId, String costDetail) throws DataAccessException {
		UserGroup userGroup = getUserGroup(groupId);
		userGroup.setCostDetail(costDetail);
	}
}
