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
import org.jabberstory.cjac.consignsettle.domain.Owner;

/**
 * 전담기관 관리 서비스
 *
 * @author HyunBae Shin
 * @since August 24, 2009
 */
public interface OwnerService {
	List<Owner> getOwnersByUserId(String userId, String role);
	Paging getOwnersByUserIdWithPaging(String userId, String role, int currentPage, int pageSize, String sortColumn);
	Owner getOwner(String ownerId);
	void createOwner(Owner owner);
	void updateOwner(Owner owner);
	void removeOwner(String ownerId);
}
