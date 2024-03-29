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
 * 우편번호 서비스 구현
 *
 * @author HyunBae Shin
 * @since June 4, 2009
 */
public class ZipCodeServiceImpl implements ZipCodeService{

	private ZipCodeRepository zipCodeRepository;
	
	public void setZipCodeRepository(ZipCodeRepository zipCodeRepository){
		this.zipCodeRepository = zipCodeRepository;
	}
	
	@Override
	public List<ZipCode> getZipCodes(String keyword) throws DataAccessException {
		return zipCodeRepository.getZipCodes(keyword);
	}

	@Override
	public Paging getZipCodesWithPaging(String keyword, int currentPage, int pageSize)
			throws DataAccessException {		
		return zipCodeRepository.getZipCodesWithPaging(keyword, currentPage, pageSize);
	}

}
