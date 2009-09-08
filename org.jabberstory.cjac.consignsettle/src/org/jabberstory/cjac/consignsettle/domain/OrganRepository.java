package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrganRepository extends HibernateDaoSupport {

	public void createOrgan(Organ organ) throws DataAccessException {
		getHibernateTemplate().save(organ);
	}
	
	public void createOrgan(Organ organ, String ownerId) throws DataAccessException {
		Organ owner = this.getOrgan(ownerId);
		organ.setOwner(owner);
		getHibernateTemplate().save(organ);
	}
	
	@SuppressWarnings("unchecked")
	public List<Organ> getAllOrgans()
			throws DataAccessException {		
		
		return getHibernateTemplate().findByNamedParam("from Organ as o", new String[]{}, new Object[]{});
		
	}

	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(String userId, String role)
			throws DataAccessException {
		
		StringBuffer hqlBuf = new StringBuffer();
		hqlBuf.append("from Organ as o ");
		hqlBuf.append("		join o.userGroups as ug ");
		hqlBuf.append("		join ug.users as u ");
		hqlBuf.append("where u.userId = :userId ");
		hqlBuf.append("		and o.role = :role");

		List list = getHibernateTemplate().findByNamedParam(hqlBuf.toString(), 
				new String[] {"userId", "role"}, 
				new Object[] {userId, role});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(String role)
			throws DataAccessException {
		
		StringBuffer hqlBuf = new StringBuffer();
		hqlBuf.append("from Organ as o ");
		hqlBuf.append("where o.role = :role");

		List list = getHibernateTemplate().findByNamedParam(hqlBuf.toString(), 
				new String[] {"role"}, 
				new Object[] {role});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(UserGroup group)
			throws DataAccessException {
		
		String queryString = "from Organ as o where :group in elements(o.userGroups)";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"group"}, 
				new Object[] {group});
		return list;
	}
	
	@SuppressWarnings("unchecked")	
	public Paging getOrgansWithPaging(String role, int currentPage, int pageSize, String sortColumn) throws DataAccessException {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getOrgans(role).size();
		final Order order = (sortColumn == "") ? Order.asc("organName"): Order.desc(sortColumn);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Organ.class);
		criteria.add(Restrictions.eq("role", role));
		criteria.addOrder(order);
        List organs = (List)getHibernateTemplate().findByCriteria(criteria, fromRowNum, toRowNum);
        
		return new Paging((List)organs, totalCount, currentPage);
	}

	@SuppressWarnings("unchecked")	
	public Paging getOrgansWithPaging(String userId, String role, int currentPage, int pageSize, String sortColumn) throws DataAccessException {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getOrgans(userId, role).size();
		final Order order = (sortColumn == "") ? Order.asc("organName"): Order.desc(sortColumn);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Organ.class);
		criteria.add(Restrictions.eq("role", role))
			.createCriteria("userGroups").createCriteria("users")
			.add(Restrictions.eq("userId", userId));			
		criteria.addOrder(order);
        List organs = (List)getHibernateTemplate().findByCriteria(criteria, fromRowNum, toRowNum);
        
		return new Paging((List)organs, totalCount, currentPage);
	}

	
	public Organ getOrgan(String organId) throws DataAccessException {
		return (Organ) getHibernateTemplate().get(Organ.class, organId);
	}

	
	public void removeOrgan(String organId) throws DataAccessException {
		getHibernateTemplate().delete(getOrgan(organId));		
	}

		
	public void updateOrgan(Organ organ) throws DataAccessException {
		getHibernateTemplate().update(organ);	
	}
	
	public void updateOrgan(Organ organ, String ownerId) throws DataAccessException {
		Organ owner = this.getOrgan(ownerId);
		organ.setOwner(owner);
		getHibernateTemplate().update(organ);	
	}
	
	public void updateOrganCostDetail(String organId, String costDetail) throws DataAccessException {
		Organ organ = getOrgan(organId);
		organ.setCostDetail(costDetail);
	}
	
	public void updateOrganNonApproval1(String organId, String nonApproval1) throws DataAccessException {
		Organ organ = getOrgan(organId);
		organ.setNonApproval1(nonApproval1);
	}
	
	public void updateOrganNonApproval2(String organId, String nonApproval2) throws DataAccessException {
		Organ organ = getOrgan(organId);
		organ.setNonApproval2(nonApproval2);
	}
}