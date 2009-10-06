package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Manages Entity objects about user management.
 * 
 * @author shawn.won@gmail.com
 *
 */
public class UserRepository extends HibernateDaoSupport {
	
	protected final Log logger = LogFactory.getLog(getClass());
		
	@SuppressWarnings("unchecked")
	public List<UserGroup> getGroups(String groupQuery) {
		String queryString = "from UserGroup g left join fetch g.parentGroup pg where g.groupId like :query or g.groupName like :query or pg.groupName like :query order by g.role, g.groupName";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"query"}, 
				new Object[] {"%" + groupQuery + "%"});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Paging getUserGroupsWithPaging(int currentPage, int pageSize, String groupQuery) {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getGroups(groupQuery).size();
		
		DetachedCriteria userCriteria = DetachedCriteria.forClass(UserGroup.class);
				
		userCriteria.createAlias("parentGroup", "pg", CriteriaSpecification.LEFT_JOIN)
			.add(Restrictions.disjunction()
					.add(Restrictions.like("groupId", groupQuery, MatchMode.ANYWHERE))
					.add(Restrictions.like("groupName", groupQuery, MatchMode.ANYWHERE))
					.add(Restrictions.like("pg.groupName", groupQuery, MatchMode.ANYWHERE)))
			.addOrder(Order.asc("role"))		
			.addOrder(Order.asc("groupName"));
		
		List users = (List) getHibernateTemplate().findByCriteria(userCriteria,
				fromRowNum, toRowNum);

		return new Paging((List) users, totalCount, currentPage);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserGroup> getGroupsByRole(String role) {
		String queryString = "from UserGroup g where g.role = :role";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"role"}, 
				new Object[] {role});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserGroup> getGroupsByParentGroupId(String groupId) {		
		String queryString = "from UserGroup ug where ug.parentGroup.groupId = :groupId";		
		return getHibernateTemplate().findByNamedParam(queryString, "groupId", groupId); 
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers(String userQuery) {
		String queryString = "from User u left join fetch u.userGroup ug left join fetch ug.parentGroup pg where u.userId like :query or u.username like :query or u.email like :query or ug.groupName like :query or pg.groupName like :query";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"query"}, 
				new Object[] {"%" + userQuery + "%"});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Paging getUsersWithPaging(int currentPage, int pageSize, String userQuery) {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getUsers(userQuery).size();
		
		DetachedCriteria userCriteria = DetachedCriteria.forClass(User.class);
				
		userCriteria.createAlias("userGroup", "ug", CriteriaSpecification.LEFT_JOIN)
			.createAlias("ug.parentGroup", "pg", CriteriaSpecification.LEFT_JOIN)
			.add(Restrictions.disjunction()
					.add(Restrictions.like("userId", userQuery, MatchMode.ANYWHERE))
					.add(Restrictions.like("username", userQuery, MatchMode.ANYWHERE))
					.add(Restrictions.like("email", userQuery, MatchMode.ANYWHERE))
					.add(Restrictions.like("ug.groupName", userQuery, MatchMode.ANYWHERE))
					.add(Restrictions.like("pg.groupName", userQuery, MatchMode.ANYWHERE)))
			.addOrder(Order.asc("ug.role"))		
			.addOrder(Order.asc("ug.groupName"));
		
		List users = (List) getHibernateTemplate().findByCriteria(userCriteria,
				fromRowNum, toRowNum);

		return new Paging((List) users, totalCount, currentPage);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAvailableUsers()
			throws DataAccessException {		
		
		List list = getHibernateTemplate().find("from User u where u.userGroup = null");
		// 해당 사용자 그룹에 할당한 사용자 목록		
		return list;
		
	}

	public UserGroup getUserGroup(String groupId) {
//		String queryString = "from UserGroup g where u.groupId = :groupId";
//		List list = getHibernateTemplate().findByNamedParam(queryString, "groupId", groupId);
//		if (list.size() > 0)
//			return (UserGroup) list.get(0);
//		return null;
		UserGroup group = (UserGroup) getHibernateTemplate().get(UserGroup.class, groupId);
		return group;
	}	
	
	@SuppressWarnings("unchecked")
	public List<User> getUsersByGroupId(String groupId)
			throws DataAccessException {
		
		String queryString = "from User as u where u.userGroup.groupId = :groupId ";
		List list = getHibernateTemplate().findByNamedParam(queryString, "groupId", groupId); 
		
		return list;
	}

	public UserGroup createUserGroup(String groupName, String role) {
		UserGroup group = new UserGroup(groupName, role);
		getHibernateTemplate().save(group);
		return group;
	}

	public UserGroup updateUserGroup(String groupId, String groupName, String role) {
		UserGroup group = getUserGroup(groupId);
		group.setGroupName(groupName);
		group.setRole(role);
		return group;
	}
	
	public void updateUser(String userId, String password, String username, String email) {
		User user = getUser(userId);
		user.setPassword(password);
		user.setUsername(username);
		user.setEmail(email);
	}
	
	public void updateUser(String userId, String password, String username,
			String email, String postnum1, String postnum2, String address,
			String phone1, String phone2, String phone3, UserGroup userGroup) {
		User user = getUser(userId);
		user.setPassword(password);
		user.setUsername(username);
		user.setEmail(email);
		user.setPostnum1(postnum1);
		user.setPostnum2(postnum2);
		user.setAddress(address);
		user.setPhone1(phone1);
		user.setPhone2(phone2);
		user.setPhone3(phone3);
		user.setUserGroup(userGroup);
	}
	
	public void updateUserGroupWithUsers(String groupId, Set<User> users) {
		UserGroup userGroup = getUserGroup(groupId);
		userGroup.setUsers(users);
		
	}

	public void removeUserGroup(String groupId) {
		UserGroup userGroup = getUserGroup(groupId);
		getHibernateTemplate().delete(userGroup);
	}
	
	public void removeUser(String userId) {
		User user = getUser(userId);
		getHibernateTemplate().delete(user);
	}

	public User getUser(String userId) {
		User user = (User) getHibernateTemplate().get(User.class, userId);
		return user;
	}

	public void createUser(String userId, String password, String username, String email) {
		getHibernateTemplate().save(new User(userId, username, email, password));
	}
	
	public void createUser(String userId, String password, String username,
			String email, String postnum1, String postnum2, String address,
			String phone1, String phone2, String phone3, UserGroup userGroup) {
		getHibernateTemplate().save(
				new User(userId, username, email, password, postnum1, postnum2,
						address, phone1, phone2, phone3, userGroup));
	}

}
