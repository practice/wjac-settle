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
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 우편번호 리파지토리
 *
 * @author HyunBae Shin
 * @since June 4, 2009
 */
public class ZipCodeRepository extends HibernateDaoSupport {
	
	@SuppressWarnings("unchecked")
	public List<ZipCode> getZipCodes(String keyword) {
		String queryString = "from ZipCode z where z.addr03 like :keyword or z.addr04 like :keyword or z.addr05 like :keyword";
		return getHibernateTemplate().findByNamedParam(queryString, "keyword", "%" + keyword + "%");
	}
	
	@SuppressWarnings("unchecked")	
	public Paging getZipCodesWithPaging(String keyword, int currentPage, int pageSize) throws DataAccessException {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getZipCodes(keyword).size();
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ZipCode.class);
		criteria.add(
				Restrictions.disjunction()
					.add(Restrictions.like("addr03", keyword, MatchMode.ANYWHERE))
					.add(Restrictions.like("addr04", keyword, MatchMode.ANYWHERE))
					.add(Restrictions.like("addr05", keyword, MatchMode.ANYWHERE))
				);		
		criteria.addOrder(Order.asc("addr"));
		
        List zipCodes = (List)getHibernateTemplate().findByCriteria(criteria, fromRowNum, toRowNum);
        
		return new Paging((List)zipCodes, totalCount, currentPage);
	}
}
