package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
		String queryString = "from UserGroup g where g.groupId like :query or g.groupName like :query";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"query"}, 
				new Object[] {"%" + groupQuery + "%"});
		return list;
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
	public List<User> getUsers(String userQuery) {
		String queryString = "from User u where u.userId like :query or u.username like :query or u.email like :query";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"query"}, 
				new Object[] {"%" + userQuery + "%"});
		return list;
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
