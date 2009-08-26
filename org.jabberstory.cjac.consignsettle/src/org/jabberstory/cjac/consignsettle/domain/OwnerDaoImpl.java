/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package org.jabberstory.cjac.consignsettle.domain;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.jabberstory.cjac.consignsettle.domain.Owner;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * HibernateDaoSupport를 이용한 전담기관 DAO 구현
 *
 * @author HyunBae Shin
 * @since August 24, 2009
 */
public class OwnerDaoImpl extends HibernateDaoSupport implements OwnerDao{

	@Override
	public void createOwner(Owner owner) throws DataAccessException {
		getHibernateTemplate().save(owner);
	}

	@Override
	public Owner getOwner(String ownerId) throws DataAccessException {
		return (Owner) getHibernateTemplate().get(Owner.class, ownerId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Owner> getOwnersByUserId(String userId, String role)
			throws DataAccessException {
		// 권한별로 쿼리를 해야하는데...좀 골치가 아프군.
		String queryString = "from Owner o";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {}, 
				new Object[] {});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Paging getOwnersByUserIdWithPaging(String userId, String role, int currentPage, int pageSize, String sortColumn) throws DataAccessException {

		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getOwnersByUserId(userId, role).size();
		final Order order = (sortColumn == "") ? Order.asc("ownerName"): Order.desc(sortColumn);
		
		Collection owners = (Collection)getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) {
                Criteria criteria = session.createCriteria(Owner.class);
                criteria.addOrder(order);
                criteria.setFirstResult(fromRowNum);
                criteria.setMaxResults(toRowNum);
                return criteria.list();
            }
        });
			
		return new Paging((List)owners, totalCount, currentPage);
	}

	@Override
	public void removeOwner(String ownerId) throws DataAccessException {
		getHibernateTemplate().delete(getOwner(ownerId));
	}

	@Override
	public void updateOwner(Owner owner) throws DataAccessException {
		getHibernateTemplate().update(owner);		
	}

}
