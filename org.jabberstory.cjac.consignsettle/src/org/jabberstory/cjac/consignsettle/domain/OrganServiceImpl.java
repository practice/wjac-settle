package org.jabberstory.cjac.consignsettle.domain;

import java.util.List;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;

public class OrganServiceImpl implements OrganService{

	private OrganRepository organRepository;

	public void setOrganRepository(OrganRepository organRepository) {
		this.organRepository = organRepository;
	}

	@Override
	public void createOrgan(Organ organ) throws DataAccessException {
		organRepository.createOrgan(organ);
	}

	@Override
	public Organ getOrgan(String groupId) throws DataAccessException {
		return organRepository.getOrgan(groupId);
	}

	@Override
	public List<Organ> getOrgans(String userId, String role)
			throws DataAccessException {
		return organRepository.getOrgans(userId, role);
	}

	@Override
	public Paging getOrgansWithPaging(String userId, String role,
			int currentPage, int pageSize, String sortColumn)
			throws DataAccessException {
		return organRepository.getOrgansWithPaging(userId, role, currentPage, pageSize, sortColumn);
	}

	@Override
	public void removeOrgan(String groupId) throws DataAccessException {
		organRepository.removeOrgan(groupId);
	}

	@Override
	public void updateOrgan(Organ organ) throws DataAccessException {
		organRepository.updateOrgan(organ);
	}

	@Override
	public void updateOrgan(String groupId, String costDetail)
			throws DataAccessException {
		organRepository.updateOrgan(groupId, costDetail);
	}

}
