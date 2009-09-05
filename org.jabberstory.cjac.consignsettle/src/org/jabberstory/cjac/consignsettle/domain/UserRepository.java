package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Manages Entity objects about user management.
 * 
 * @author shawn.won@gmail.com
 *
 */
public class UserRepository extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<UserGroup> getGroups(String groupQuery) {
		String queryString = "from UserGroup g where g.groupId like :query or g.groupName like :query";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"query"}, 
				new Object[] {"%" + groupQuery + "%"});
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers(String userQuery) {
		String queryString = "from User u where u.userId like :query or u.username like :query or u.email like :query";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"query"}, 
				new Object[] {"%" + userQuery + "%"});
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

	public void createUserGroup(String groupName, String role) {
		UserGroup group = new UserGroup(groupName, role);
		getHibernateTemplate().save(group);
	}

	public void updateUserGroup(String groupId, String groupName, String role) {
		UserGroup group = getUserGroup(groupId);
		group.setGroupName(groupName);
		group.setRole(role);
	}

	public void removeUserGroup(String groupId) {
		UserGroup userGroup = getUserGroup(groupId);
		getHibernateTemplate().delete(userGroup);
	}

	public User getUser(String userId) {
		User user = (User) getHibernateTemplate().get(User.class, userId);
		return user;
	}

	public void createUser(String userId, String password, String username, String email) {
		getHibernateTemplate().save(new User(userId, username, email, password));
	}

}
