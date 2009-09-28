package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;
import org.springframework.web.multipart.MultipartFile;

public class OrganServiceImpl implements OrganService{
	
	private OrganRepository organRepository;

	public void setOrganRepository(OrganRepository organRepository) {
		this.organRepository = organRepository;
	}
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void createOrgan(Organ organ) throws DataAccessException {
		organRepository.createOrgan(organ);
	}
	
	@Override
	public Organ getOrgan(String organId) throws DataAccessException {
		return organRepository.getOrgan(organId);
	}

	@Override
	public List<Organ> getOrgans(String userId, String role)
			{
		return organRepository.getOrgans(userId, role);
	}
	
	@Override
	public List<Organ> getOrgansByUserGroup(String groupId)
			{
		
		UserGroup userGroup = userService.getUserGroup(groupId);		
		return organRepository.getOrgans(userGroup);
	}
	
	@Override
	public List<Organ> getAllOrgans()
			{
		return organRepository.getAllOrgans();
	}
	
	@Override
	public Paging getOrgansWithPaging(String userId,
			int currentPage, int pageSize, String sortColumn, String keyword)
			{
		
		String userRole = userService.getUserRole(userId);		
		return organRepository.getOrgansWithPaging(userId, userRole, currentPage, pageSize, sortColumn, keyword);
	}

	@Override
	public void removeOrgan(String organId) {
		organRepository.removeOrgan(organId);
	}

	@Override
	public void updateOrgan(Organ organ) {
		organRepository.updateOrgan(organ);
	}
	
	@Override
	public void updateOrganCostDetail(String organId, String costDetail)
			{
		organRepository.updateOrganCostDetail(organId, costDetail);
	}
	
	@Override
	public void updateOrganNonApproval2(String organId, String nonApproval2, MultipartFile file)
			{
		organRepository.updateOrganNonApproval2(organId, nonApproval2, file);
	}

	@Override
	public void updateOrganNonApproval1(String organId, String nonApproval1,
			MultipartFile file) {
		organRepository.updateOrganNonApproval1(organId, nonApproval1, file);
		
	}

	@Override
	public OrganAttachment getOrganAttachment(String organId, String attId) {
		return organRepository.getOrganAttachments(organId, attId);
	}

	@Override
	public boolean isUnix() {
		return OrganRepository.isUnix();
	}

	@Override
	public void removeAttachment(String organId, String attId) {
		organRepository.removeAttachment(organId, attId);		
	}
}
