package org.jabberstory.cjac.consignsettle.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.multipart.MultipartFile;

public class OrganRepository extends HibernateDaoSupport {

	protected final Log logger = LogFactory.getLog(getClass());
	
	private static boolean isUnix = true;
	static {
		String os = System.getProperty("os.name");
		isUnix = !os.contains("Windows");
	}
	
	public void createOrgan(Organ organ) {
		getHibernateTemplate().save(organ);
	}

	@SuppressWarnings("unchecked")
	public List<Organ> getAllOrgans() throws DataAccessException {

		return getHibernateTemplate().findByNamedParam("from Organ as o",
				new String[] {}, new Object[] {});

	}

	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(String userId, String userRole)
			throws DataAccessException {

		StringBuffer hqlBuf = new StringBuffer();
		List list = new ArrayList();

		if (userRole.equals("A") || userRole.equals("C")) {
			list = getHibernateTemplate().find("from Organ o");
		} else {
			hqlBuf.append("	select distinct o ");
			hqlBuf.append("	from Organ o ");
			hqlBuf.append("		left join fetch o.subjectGroup sg ");
			hqlBuf.append("		left join fetch sg.users su ");
			hqlBuf.append("		left join fetch o.subjectGroup.parentGroup pg ");
			hqlBuf.append("		left join fetch pg.users pu ");
			hqlBuf.append("	where su.userId = :userId or pu.userId = :userId");
			list = getHibernateTemplate().findByNamedParam(hqlBuf.toString(),
					new String[] { "userId" }, new Object[] { userId });
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(String userId, String userRole, String keyword)
			throws DataAccessException {

		StringBuffer hqlBuf = new StringBuffer();
		List list = new ArrayList();

		if (userRole.equals("A") || userRole.equals("C")) {
			hqlBuf.append("	select distinct o ");
			hqlBuf.append("	from Organ o ");
			hqlBuf.append("		left join fetch o.subjectGroup sg ");
			hqlBuf.append("		left join fetch sg.users su ");
			hqlBuf.append("		left join fetch o.subjectGroup.parentGroup pg ");
			hqlBuf.append("		left join fetch pg.users pu ");
			hqlBuf.append("	where (o.subjectGroup.groupName like :keyword ");
			hqlBuf.append("		or o.businessName like :keyword ");
			hqlBuf.append("		or o.projectName like :keyword ");
			hqlBuf.append("		or o.subjectGroup.parentGroup.groupName like :keyword) ");
			list = getHibernateTemplate().findByNamedParam(
					hqlBuf.toString(),
					new String[] { "keyword"}, 
					new Object[] { "%" + keyword + "%" });
		} else {
			hqlBuf.append("	select distinct o ");
			hqlBuf.append("	from Organ o ");
			hqlBuf.append("		left join fetch o.subjectGroup sg ");
			hqlBuf.append("		left join fetch sg.users su ");
			hqlBuf.append("		left join fetch o.subjectGroup.parentGroup pg ");
			hqlBuf.append("		left join fetch pg.users pu ");
			hqlBuf.append("	where (o.subjectGroup.groupName like :keyword ");
			hqlBuf.append("		or o.businessName like :keyword ");
			hqlBuf.append("		or o.projectName like :keyword ");
			hqlBuf.append("		or o.subjectGroup.parentGroup.groupName like :keyword) ");
			hqlBuf.append("		and ( su.userId = :userId or pu.userId = :userId)");
			list = getHibernateTemplate().findByNamedParam(
					hqlBuf.toString(),
					new String[] { "userId", "keyword"}, 
					new Object[] { userId, "%" + keyword + "%" });
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(UserGroup group) throws DataAccessException {

		String queryString = "from Organ as o where :group in elements(o.userGroups)";
		List list = getHibernateTemplate().findByNamedParam(queryString,
				new String[] { "group" }, new Object[] { group });
		return list;
	}

	@SuppressWarnings("unchecked")
	public Paging getOrgansWithPaging(String userId, String userRole,
			int currentPage, int pageSize, String sortColumn, String keyword) {
		final int fromRowNum = (currentPage - 1) * pageSize;
		final int toRowNum = pageSize;
		int totalCount = this.getOrgans(userId, userRole, keyword).size();
		final Order order = (sortColumn == "") ? Order.asc("sg.groupName")
				: Order.desc(sortColumn);
		
		DetachedCriteria organCriteria = DetachedCriteria.forClass(Organ.class);
		
		if (userRole.equals("A") || userRole.equals("C")) {
			organCriteria.createAlias("subjectGroup", "sg", CriteriaSpecification.LEFT_JOIN)
				.createAlias("sg.parentGroup", "pg", CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.disjunction()
						.add(Restrictions.like("sg.groupName", keyword, MatchMode.ANYWHERE))
						.add(Restrictions.like("businessName", keyword, MatchMode.ANYWHERE))
						.add(Restrictions.like("projectName", keyword, MatchMode.ANYWHERE))
						.add(Restrictions.like("pg.groupName", keyword, MatchMode.ANYWHERE)))					
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
				.addOrder(order);
		} else if (userRole.equals("O")) {
			organCriteria.createAlias("subjectGroup", "sg", CriteriaSpecification.LEFT_JOIN)
				.createAlias("sg.parentGroup", "pg", CriteriaSpecification.LEFT_JOIN)	
				.createAlias("pg.users", "pu", CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.and(
							Restrictions.eq("pu.userId", userId),
							Restrictions.disjunction()
								.add(Restrictions.like("sg.groupName", keyword, MatchMode.ANYWHERE))
								.add(Restrictions.like("businessName", keyword, MatchMode.ANYWHERE))
								.add(Restrictions.like("projectName", keyword, MatchMode.ANYWHERE))
								.add(Restrictions.like("pg.groupName", keyword, MatchMode.ANYWHERE))
						)
				)					
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
				.addOrder(order);	
		} else {
			organCriteria.createAlias("subjectGroup", "sg", CriteriaSpecification.LEFT_JOIN)
				.createAlias("sg.parentGroup", "pg", CriteriaSpecification.LEFT_JOIN)	
				.createAlias("sg.users", "su", CriteriaSpecification.LEFT_JOIN)				
				.add(Restrictions.and(
							Restrictions.eq("su.userId", userId),
							Restrictions.disjunction()
								.add(Restrictions.like("sg.groupName", keyword, MatchMode.ANYWHERE))
								.add(Restrictions.like("businessName", keyword, MatchMode.ANYWHERE))
								.add(Restrictions.like("projectName", keyword, MatchMode.ANYWHERE))
								.add(Restrictions.like("pg.groupName", keyword, MatchMode.ANYWHERE))
						)
				)					
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
				.addOrder(order);
		}
		List organs = (List) getHibernateTemplate().findByCriteria(organCriteria,
				fromRowNum, toRowNum);

		return new Paging((List) organs, totalCount, currentPage);
	}

	public Organ getOrgan(String organId) {
		return (Organ) getHibernateTemplate().get(Organ.class, organId);
	}

	public void removeOrgan(String organId) {
		getHibernateTemplate().delete(getOrgan(organId));
	}

	public void updateOrgan(Organ organ) {
		getHibernateTemplate().update(organ);
	}

	public void updateOrganCostDetail(String organId, String costDetail) {
		Organ organ = getOrgan(organId);
		organ.setCostDetail(costDetail);
	}
	
	public void removeAttachment(String organId, String attId) {
		Organ organ = getOrgan(organId);
		OrganAttachment attachment = getOrganAttachment(attId);
		organ.getAttachments().remove(attachment);
		
		getHibernateTemplate().delete(getOrganAttachment(attId));
	}
	
	public OrganAttachment getOrganAttachment(String attId){
		return (OrganAttachment) getHibernateTemplate().get(OrganAttachment.class, attId);
	}
	
	@SuppressWarnings("unchecked")
	public OrganAttachment getOrganAttachments(String organId, String attId) {
		String queryString = "from OrganAttachment a where a.id = :attId and a.organ.organId = :organId";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"attId", "organId"}, 
				new Object[] {attId, organId});
		if (list.size() == 0)
			return null;
		return (OrganAttachment)list.get(0);
	}

	public void updateOrganNonApproval1(String organId, String nonApproval1, MultipartFile file) {
		Organ organ = getOrgan(organId);
		organ.setNonApproval1(nonApproval1);
		String saveDir = calcSaveDir(organ);
		addAttachments(file, organ, saveDir, "0");
		saveFiles(file, saveDir);
	}

	public void updateOrganNonApproval2(String organId, String nonApproval2, MultipartFile file) {
		Organ organ = getOrgan(organId);
		organ.setNonApproval2(nonApproval2);
		String saveDir = calcSaveDir(organ);
		addAttachments(file, organ, saveDir, "1");
		saveFiles(file, saveDir);
	}

	private void saveFiles(MultipartFile file, String saveDir) {
		try {
			if (isUnix) {
				createDir(OrganService.FILE_PREFIX_UNIX + saveDir);
				file.transferTo(new File(OrganService.FILE_PREFIX_UNIX + saveDir + "/"
						+ file.getOriginalFilename()));
			} else {
				createDir(OrganService.FILE_PREFIX_WIN + saveDir);
				file.transferTo(new File(OrganService.FILE_PREFIX_WIN + saveDir + "/"
						+ file.getOriginalFilename()));
			}
		} catch (IllegalStateException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void addAttachments(MultipartFile file, Organ organ,
			String saveDir, String filetype) {
		OrganAttachment attachment = new OrganAttachment();
		attachment.setFilename(file.getOriginalFilename());
		attachment.setFilesize(file.getSize());
		attachment.setDir(saveDir);
		attachment.setFiletype(filetype);
		organ.addAttachment(attachment);
	}

	private void createDir(String path) {
		new File(path).mkdirs();
	}

	private String calcSaveDir(Organ organ) {
		//SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd/HH/");
		//String path = dateFormatter.format(new Date());
		//return path + organ.getOrganId();
		return organ.getOrganId();
	}
	
	public static boolean isUnix() {
		return isUnix;
	}
}