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

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;

/**
 * 주관기관 DAO
 * 
 * @author HyunBae Shin
 * @since August 28, 2009
 */
public interface SubjectDao {
	List<Subject> getSubjectsByUserId(String userId, String role)
			throws DataAccessException;

	Paging getSubjectsByUserIdWithPaging(String userId, String role,
			int currentPage, int pageSize, String sortColumn)
			throws DataAccessException;

	Subject getSubject(String subjectId) throws DataAccessException;

	void createSubject(Subject subject) throws DataAccessException;

	void updateSubject(Subject subject) throws DataAccessException;

	void updateSubject(String subjectId, String costDetail)
			throws DataAccessException;

	void removeSubject(String subjectId) throws DataAccessException;
}
