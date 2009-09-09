package org.jabberstory.cjac.consignsettle.domain;

import java.util.ArrayList;
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
	
	@SuppressWarnings("unchecked")
	public List<Organ> getAllOrgans()
			throws DataAccessException {		
		
		return getHibernateTemplate().findByNamedParam("from Organ as o", new String[]{}, new Object[]{});
		
	}

	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(String userId, String userRole)
			throws DataAccessException {
		
		StringBuffer hqlBuf = new StringBuffer();
		List list = new ArrayList();
		
		if(userRole.equals("A") || userRole.equals("C")){			
			list = getHibernateTemplate().find("from Organ o");
		}
		
		if(userRole.equals("O")){
			hqlBuf.append("	from Organ o ");
			hqlBuf.append("		join o.ownerGroup g ");
			hqlBuf.append("		join g.users u ");
			hqlBuf.append("	where u.userId = :userId ");
			list = getHibernateTemplate().findByNamedParam(hqlBuf.toString(), 
					new String[] {"userId"}, 
					new Object[] {userId});
		}
		if(userRole.equals("S") || userRole.equals("")){
			hqlBuf.append("	from Organ o ");
			hqlBuf.append("		join o.subjectGroup g ");
			hqlBuf.append("		join g.users u ");
			hqlBuf.append("	where u.userId = :userId ");
			list = getHibernateTemplate().findByNamedParam(hqlBuf.toString(), 
					new String[] {"userId"}, 
					new Object[] {userId});
		}
		
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
	public Paging getOrgansWithPaging(String userId, String userRole, int currentPage, int pageSize, String sortColumn) throws DataAccessException {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getOrgans(userId, userRole).size();
		final Order order = (sortColumn == "") ? Order.asc("businessName"): Order.desc(sortColumn);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Organ.class);
		
		if(userRole.equals("O")){
			criteria.createCriteria("ownerGroup")
					.createCriteria("users")
					.add(Restrictions.eq("userId", userId));
		}else if(userRole.equals("S") || userRole.equals("")){
			criteria.createCriteria("subjectGroup")
					.createCriteria("users")
					.add(Restrictions.eq("userId", userId));
		}
		
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