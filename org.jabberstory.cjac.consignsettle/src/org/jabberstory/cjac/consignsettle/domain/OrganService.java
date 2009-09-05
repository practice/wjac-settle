package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;

public interface OrganService {
	List<Organ> getOrgans(String userId, String role) throws DataAccessException;

	Paging getOrgansWithPaging(String userId, String role, int currentPage, int pageSize, String sortColumn) throws DataAccessException;

	Organ getOrgan(String groupId) throws DataAccessException;

	void createOrgan(Organ userGroup) throws DataAccessException;

	void updateOrgan(Organ userGroup) throws DataAccessException;

	void removeOrgan(String organId) throws DataAccessException;

	void updateOrgan(String organId, String costDetail) throws DataAccessException;
}
