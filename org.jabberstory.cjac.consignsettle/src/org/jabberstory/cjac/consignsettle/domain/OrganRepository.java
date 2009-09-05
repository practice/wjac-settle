package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrganRepository extends HibernateDaoSupport {

	public void createOrgan(Organ organ) throws DataAccessException {
		getHibernateTemplate().save(organ);
	}

	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(String organId, String role)
			throws DataAccessException {
		
		// 권한별로 쿼리를 해야하는데...좀 골치가 아프군.
		String queryString = "from Organ o";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {}, 
				new Object[] {});
		return list;
	}

	@SuppressWarnings("unchecked")	
	public Paging getOrgansWithPaging(String organId, String role, int currentPage, int pageSize, String sortColumn) throws DataAccessException {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getOrgans(organId, role).size();
		final Order order = (sortColumn == "") ? Order.asc("organName"): Order.desc(sortColumn);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Organ.class);
        criteria.addOrder(order);
        List organs = (List)getHibernateTemplate().findByCriteria(criteria, fromRowNum, toRowNum);
		
		return new Paging((List)organs, totalCount, currentPage);
	}

	
	public Organ getOrgan(String groupId) throws DataAccessException {
		return (Organ) getHibernateTemplate().get(Organ.class, groupId);
	}

	
	public void removeOrgan(String groupId) throws DataAccessException {
		getHibernateTemplate().delete(getOrgan(groupId));		
	}

	
	public void updateOrgan(Organ organ) throws DataAccessException {
		getHibernateTemplate().update(organ);	
	}

	
	public void updateOrgan(String groupId, String costDetail) throws DataAccessException {
		Organ organ = getOrgan(groupId);
		organ.setCostDetail(costDetail);
	}
}