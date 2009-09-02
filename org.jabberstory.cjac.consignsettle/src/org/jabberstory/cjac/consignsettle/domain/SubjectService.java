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
 * 주관기관 서비스
 *
 * @author HyunBae Shin
 * @since August 28, 2009
 */
public interface SubjectService {
	List<Subject> getSubjectsByUserId(String userId, String role);
	Paging getSubjectsByUserIdWithPaging(String userId, String role, int currentPage, int pageSize, String sortColumn);
	Subject getSubject(String subjectId);
	void createSubject(Subject subject);
	void updateSubject(Subject subject);
	void updateSubject(String subjectId, String costDetail);
	void removeSubject(String subjectId);

}
