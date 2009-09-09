package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.jabberstory.cjac.consignsettle.domain.Organ;
import org.jabberstory.cjac.consignsettle.domain.OrganService;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OrganMultiActionController extends MultiActionController {

	private Logger log = Logger.getLogger(this.getClass());
	
	public OrganMultiActionController() {}

	private UserService userService;
	private OrganService organService;
	
	protected final String ROLE_ADMIN = "A";	// 관리자
	protected final String ROLE_CONSIGN = "C";	// 회계법인
	protected final String ROLE_OWNER = "O";	// 전담기관
	protected final String ROLE_SUBJECT = "S";	// 주관기관
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setOrganService(OrganService organService) {
		this.organService = organService;
	}
	
	public ModelAndView createOwner(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
//		String organName = (request.getParameter("organName") == null) ? "": request.getParameter("organName");
//		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
//		
//		if (organName.equals("")){
//			ModelAndView mv = new ModelAndView("createOwner");
//			return mv;
//		}
//		
//		Organ organ = new Organ();
//		
//		bind(request, organ);
//		organ.setRole(ROLE_OWNER);
//		
//		organService.createOrgan(organ);
		
	    return new ModelAndView("redirect:ownerList");
	    
	} 
	
	public ModelAndView showOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");

		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showOwner", "organ", organ);

	}
	
	public ModelAndView updateOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		String organId = request.getParameter("organId");
//		String organName = (request.getParameter("organName") == null) ? "": request.getParameter("organName");
//		Organ organ;
//		
//		if (organName.equals("")){
//			organ = organService.getOrgan(organId);
//			ModelAndView mv = new ModelAndView("updateOwner");
//			mv.addObject("organ", organ);
//			return mv;
//		}
//		
//		organ = new Organ();
//
//		bind(request, organ);
//		
//		organ.setRole(ROLE_OWNER);
//
//		organService.updateOrgan(organ);

		return new ModelAndView("redirect:ownerList");

	}
	
	public ModelAndView deleteOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");

		organService.removeOrgan(organId);

		return new ModelAndView("redirect:ownerList");

	}

	public ModelAndView ownerPagingList(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
//		String sortColumn = (request.getParameter("sortColumn") == null) ? "": request.getParameter("sortColumn");
//		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
//		
//		int pageSize = 10;
//
//		Paging pagingList = organService.getOrgansWithPaging(ROLE_OWNER, Integer.parseInt(pageNo), pageSize, sortColumn);
//		
//		ModelAndView mv = new ModelAndView("ownerList", "pagingList", pagingList);
//		mv.addObject("organCount", pagingList.getTotalCount());
//		mv.addObject("sortColumn", sortColumn);
//		
//		return mv;
		return new ModelAndView();

	}
	
	/**
	 * 
	 * 전담기관 생성
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView createSubject(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		String ownerGroupId = (request.getParameter("ownerGroupId") == null) ? "": request.getParameter("ownerGroupId");
		String subjectGroupId = (request.getParameter("subjectGroupId") == null) ? "": request.getParameter("subjectGroupId");
		
		if (ownerGroupId.equals("") || subjectGroupId.equals("")){
			List<UserGroup> ownerGroups = userService.getGroupsByRole(ROLE_OWNER);
			List<UserGroup> subjectGroups = userService.getGroupsByRole(ROLE_SUBJECT);
			ModelAndView mv = new ModelAndView("createSubject");
			mv.addObject("ownerGroups", ownerGroups);
			mv.addObject("subjectGroups", subjectGroups);
			return mv;
		}
		
		UserGroup ownerGroup = userService.getUserGroup(ownerGroupId);
		UserGroup subjectGroup = userService.getUserGroup(subjectGroupId);
		
		Organ organ = new Organ();
		
		bind(request, organ);
		organ.setOwnerGroup(ownerGroup);
		organ.setSubjectGroup(subjectGroup);
		
		organService.createOrgan(organ);
		
	    return new ModelAndView("redirect:subjectList");
	    
	} 
	
	public ModelAndView showSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");

		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showSubject", "organ", organ);

	}
	
	public ModelAndView updateSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");
		String ownerGroupId = (request.getParameter("ownerGroupId") == null) ? "": request.getParameter("ownerGroupId");
		String subjectGroupId = (request.getParameter("subjectGroupId") == null) ? "": request.getParameter("subjectGroupId");
		
		Organ organ = organService.getOrgan(organId);
		String costDetail = organ.getCostDetail();
		String nonApproval1 = organ.getNonApproval1();
		String nonApproval2 = organ.getNonApproval2();
		
		if (ownerGroupId.equals("") || subjectGroupId.equals("")){
			List<UserGroup> ownerGroups = userService.getGroupsByRole(ROLE_OWNER);
			List<UserGroup> subjectGroups = userService.getGroupsByRole(ROLE_SUBJECT);
			ModelAndView mv = new ModelAndView("updateSubject");
			mv.addObject("ownerGroups", ownerGroups);
			mv.addObject("subjectGroups", subjectGroups);
			mv.addObject("organ", organ);
			return mv;
		}
		
		UserGroup ownerGroup = userService.getUserGroup(ownerGroupId);
		UserGroup subjectGroup = userService.getUserGroup(subjectGroupId);
		
		Organ organCommand = new Organ();
		bind(request, organCommand);		
		organCommand.setCostDetail(costDetail);
		organCommand.setNonApproval1(nonApproval1);
		organCommand.setNonApproval2(nonApproval2);
		organCommand.setOwnerGroup(ownerGroup);
		organCommand.setSubjectGroup(subjectGroup);
		
		organService.updateOrgan(organCommand);

		return new ModelAndView("redirect:subjectList");

	}
	
	public ModelAndView deleteSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");

		organService.removeOrgan(organId);

		return new ModelAndView("redirect:subjectList");

	}
	
	public ModelAndView subjectPagingList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
		String sortColumn = (request.getParameter("sortColumn") == null) ? "": request.getParameter("sortColumn");
		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
		
		int pageSize = 10;

		log.info("############################################################");
		log.info(userId);
		log.info("############################################################");
		
		Paging	pagingList = organService.getOrgansWithPaging(userId, Integer.parseInt(pageNo), pageSize, sortColumn);
		
		ModelAndView mv = new ModelAndView("subjectList", "pagingList", pagingList);
		mv.addObject("sortColumn", sortColumn);
		
		return mv;

	}
	
	public ModelAndView updateCostDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String organId = request.getParameter("organId");
		String costDetail = (request.getParameter("costDetail") == null) ? "" : request.getParameter("costDetail");
		
		Organ organ = organService.getOrgan(organId);
		
		if (costDetail.equals("")) {
			return new ModelAndView("updateCostDetail", "organ", organ);
		}
		
		organService.updateOrganCostDetail(organId, costDetail);
		organ = organService.getOrgan(organId);
		
		return new ModelAndView("showCostDetail", "organ", organ);
	
	}
	
	public ModelAndView deleteCostDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");
		//String costDetail = (request.getParameter("costDetail") == null) ? "" : request.getParameter("costDetail");
		
		organService.updateOrganCostDetail(organId, "");
		
		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showCostDetail", "organ", organ);
	
	}
	
	public ModelAndView showCostDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String organId = request.getParameter("organId");
		
		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showCostDetail", "organ", organ);
		
	}
	
	public ModelAndView updateNonApproval1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String organId = request.getParameter("organId");
		String nonApproval1 = (request.getParameter("nonApproval1") == null) ? "" : request.getParameter("nonApproval1");
		
		Organ organ = organService.getOrgan(organId);
		
		if (nonApproval1.equals("")) {
			return new ModelAndView("updateNonApproval1", "organ", organ);
		}
		
		organService.updateOrganNonApproval1(organId, nonApproval1);
		organ = organService.getOrgan(organId);
		
		return new ModelAndView("showNonApproval1", "organ", organ);
	
	}
	
	public ModelAndView deleteNonApproval1(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");
		
		organService.updateOrganNonApproval1(organId, "");
		
		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showNonApproval1", "organ", organ);
	
	}
	
	public ModelAndView showNonApproval1(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String organId = request.getParameter("organId");
		
		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showNonApproval1", "organ", organ);
		
	}
	
	public ModelAndView updateNonApproval2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String organId = request.getParameter("organId");
		String nonApproval2 = (request.getParameter("nonApproval2") == null) ? "" : request.getParameter("nonApproval2");
		
		Organ organ = organService.getOrgan(organId);
		
		if (nonApproval2.equals("")) {
			return new ModelAndView("updateNonApproval2", "organ", organ);
		}
		
		organService.updateOrganNonApproval2(organId, nonApproval2);
		organ = organService.getOrgan(organId);
		
		return new ModelAndView("showNonApproval2", "organ", organ);
	
	}
	
	public ModelAndView deleteNonApproval2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");
		
		organService.updateOrganNonApproval2(organId, "");
		
		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showNonApproval2", "organ", organ);
	
	}
	
	public ModelAndView showNonApproval2(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String organId = request.getParameter("organId");
		
		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showNonApproval2", "organ", organ);
		
	}
		

	public ModelAndView settlementPagingList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
		String sortColumn = (request.getParameter("sortColumn") == null) ? "": request.getParameter("sortColumn");
		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
				
		int pageSize = 10;

		Paging pagingList = organService.getOrgansWithPaging(userId, Integer.parseInt(pageNo), pageSize, sortColumn);
		
		ModelAndView mv = new ModelAndView("settlementList", "pagingList", pagingList);
		mv.addObject("sortColumn", sortColumn);
		
		return mv;

	}
}