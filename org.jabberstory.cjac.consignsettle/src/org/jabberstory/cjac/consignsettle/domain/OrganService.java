package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;

public interface OrganService {
	List<Organ> getOrgans(String userId, String role) throws DataAccessException;
	
	List<Organ> getAllOrgans(String role) throws DataAccessException;
	
	Paging getOrgansWithPaging(String userId, String role, int currentPage, int pageSize, String sortColumn) throws DataAccessException;

	Organ getOrgan(String organId) throws DataAccessException;

	void createOrgan(Organ organ) throws DataAccessException;
	
	void createOrgan(Organ organ, String ownerId) throws DataAccessException;

	void updateOrgan(Organ organ, String ownerId) throws DataAccessException;

	void updateOrgan(Organ organ) throws DataAccessException;
	
	void updateOrganCostDetail(String organId, String costDetail) throws DataAccessException;
	
	void updateOrganNonApproval1(String organId, String nonApproval1) throws DataAccessException;
	
	void updateOrganNonApproval2(String organId, String nonApproval2) throws DataAccessException;
	
	void removeOrgan(String organId) throws DataAccessException;
}
