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

/**
 * 전담기관 서비스 구현
 *
 * @author HyunBae Shin
 * @since August 28, 2009
 */
public class SubjectServiceImpl implements SubjectService{

	private SubjectDao subjectDao;
	
	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	@Override
	public void createSubject(Subject subject) {
		subjectDao.createSubject(subject);		
	}

	@Override
	public Subject getSubject(String subjectId) {
		return subjectDao.getSubject(subjectId);
	}

	@Override
	public List<Subject> getSubjectsByUserId(String userId, String role) {
		return subjectDao.getSubjectsByUserId(userId, role);
	}

	@Override
	public Paging getSubjectsByUserIdWithPaging(String userId, String role,
			int currentPage, int pageSize, String sortColumn) {
		return subjectDao.getSubjectsByUserIdWithPaging(userId, role, currentPage, pageSize, sortColumn);
	}

	@Override
	public void removeSubject(String subjectId) {
		subjectDao.removeSubject(subjectId);
	}

	@Override
	public void updateSubject(Subject subject) {
		subjectDao.updateSubject(subject);
	}

}
