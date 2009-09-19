package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.web.multipart.MultipartFile;

public interface OrganService {
	
	List<Organ> getOrgans(String userId, String role);
	
	List<Organ> getOrgansByUserGroup(String groupId);
	
	List<Organ> getAllOrgans();
	
	Paging getOrgansWithPaging(String userId, int currentPage, int pageSize, String sortColumn);

	Organ getOrgan(String organId);

	void createOrgan(Organ organ);
	
	void updateOrgan(Organ organ);
	
	void updateOrganCostDetail(String organId, String costDetail);
	
	void updateOrganNonApproval1(String organId, String nonApproval1, MultipartFile files);
	
	void updateOrganNonApproval2(String organId, String nonApproval2);
	
	void removeOrgan(String organId);
}
