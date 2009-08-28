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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 주관기관 DAO 구현
 *
 * @author HyunBae Shin
 * @since June 4, 2009
 */
public class SubjectDaoImpl extends HibernateDaoSupport implements SubjectDao{

	@Override
	public void createSubject(Subject subject) throws DataAccessException {
		getHibernateTemplate().save(subject);
	}

	@Override
	public Subject getSubject(String subjectId) throws DataAccessException {
		return (Subject) getHibernateTemplate().get(Subject.class, subjectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> getSubjectsByUserId(String userId, String role)
			throws DataAccessException {
		// 권한별로 쿼리를 해야하는데...좀 골치가 아프군.
		String queryString = "from Subject o";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {}, 
				new Object[] {});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Paging getSubjectsByUserIdWithPaging(String userId, String role,
			int currentPage, int pageSize, String sortColumn)
			throws DataAccessException {
		
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getSubjectsByUserId(userId, role).size();
		final Order order = (sortColumn == "") ? Order.asc("subjectName"): Order.desc(sortColumn);
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Subject.class);
        criteria.addOrder(order);
        List subjects = (List)getHibernateTemplate().findByCriteria(criteria, fromRowNum, toRowNum);
		
		return new Paging((List)subjects, totalCount, currentPage);
	}

	@Override
	public void removeSubject(String subjectId) throws DataAccessException {
		getHibernateTemplate().delete(getSubject(subjectId));		
	}

	@Override
	public void updateSubject(Subject subject) throws DataAccessException {
		getHibernateTemplate().update(subject);	
	}

}
