package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;
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
	public List<Organ> getAllOrgans(String role)
			throws DataAccessException {
		
		String queryString = "from Organ as o where o.role = :role order by o.organName asc";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"role"}, 
				new Object[] {role});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(String userId, String role)
			throws DataAccessException {
		
		// 권한별로 쿼리를 해야하는데...좀 골치가 아프군.
		String queryString = "from Organ as o where o.role like :role";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"role"}, 
				new Object[] {'%' + role + '%'});
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
	public Paging getOrgansWithPaging(String userId, String role, int currentPage, int pageSize, String sortColumn) throws DataAccessException {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getOrgans(userId, role).size();
		final Order order = (sortColumn == "") ? Order.asc("organName"): Order.desc(sortColumn);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Organ.class);
		criteria.add(Restrictions.eq("role", role));
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