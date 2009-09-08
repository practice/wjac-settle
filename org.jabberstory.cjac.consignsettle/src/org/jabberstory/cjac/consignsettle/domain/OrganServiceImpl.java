package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;

public class OrganServiceImpl implements OrganService{

	private OrganRepository organRepository;

	public void setOrganRepository(OrganRepository organRepository) {
		this.organRepository = organRepository;
	}
	
	private UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void createOrgan(Organ organ) throws DataAccessException {
		organRepository.createOrgan(organ);
	}
	
	@Override
	public void createOrgan(Organ organ, String ownerId) throws DataAccessException {
		organRepository.createOrgan(organ, ownerId);
	}

	@Override
	public Organ getOrgan(String organId) throws DataAccessException {
		return organRepository.getOrgan(organId);
	}

	@Override
	public List<Organ> getOrgans(String userId, String role)
			throws DataAccessException {
		return organRepository.getOrgans(userId, role);
	}
	
	@Override
	public List<Organ> getOrgans(String role)
			throws DataAccessException {
		return organRepository.getOrgans(role);
	}
	
	@Override
	public List<Organ> getOrgansByUserGroup(String groupId)
			throws DataAccessException {
		
		UserGroup userGroup = userRepository.getUserGroup(groupId);		
		return organRepository.getOrgans(userGroup);
	}
	
	@Override
	public List<Organ> getAllOrgans()
			throws DataAccessException {
		return organRepository.getAllOrgans();
	}
	
	@Override
	public Paging getOrgansWithPaging(String role,
			int currentPage, int pageSize, String sortColumn)
			throws DataAccessException {
		return organRepository.getOrgansWithPaging(role, currentPage, pageSize, sortColumn);
	}
	
	@Override
	public Paging getOrgansWithPaging(String userId, String role,
			int currentPage, int pageSize, String sortColumn)
			throws DataAccessException {
		return organRepository.getOrgansWithPaging(userId, role, currentPage, pageSize, sortColumn);
	}

	@Override
	public void removeOrgan(String organId) throws DataAccessException {
		organRepository.removeOrgan(organId);
	}

	@Override
	public void updateOrgan(Organ organ) throws DataAccessException {
		organRepository.updateOrgan(organ);
	}
	
	@Override
	public void updateOrgan(Organ organ, String ownerId) throws DataAccessException {
		organRepository.updateOrgan(organ, ownerId);
	}

	@Override
	public void updateOrganCostDetail(String organId, String costDetail)
			throws DataAccessException {
		organRepository.updateOrganCostDetail(organId, costDetail);
	}
	
	@Override
	public void updateOrganNonApproval1(String organId, String nonApproval1)
			throws DataAccessException {
		organRepository.updateOrganNonApproval1(organId, nonApproval1);
	}
	
	@Override
	public void updateOrganNonApproval2(String organId, String nonApproval2)
			throws DataAccessException {
		organRepository.updateOrganNonApproval2(organId, nonApproval2);
	}

}
