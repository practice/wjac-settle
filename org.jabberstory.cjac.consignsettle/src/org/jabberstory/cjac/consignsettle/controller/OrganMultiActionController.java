package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.jabberstory.cjac.consignsettle.domain.Organ;
import org.jabberstory.cjac.consignsettle.domain.OrganService;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OrganMultiActionController extends MultiActionController {

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
		
		String organName = (request.getParameter("organName") == null) ? "": request.getParameter("organName");
		String userId = (request.getParameter("userId") == null) ? "": request.getParameter("userId");
		
		if (organName.equals("")){
			ModelAndView mv = new ModelAndView("createOwner");
			return mv;
		}
		
		Organ organ = new Organ();
		
		bind(request, organ);
		organ.setRole(ROLE_OWNER);
		
		organService.createOrgan(organ);
		
	    return new ModelAndView("redirect:ownerList");
	    
	} 
	
	public ModelAndView showOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");

		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showOwner", "organ", organ);

	}
	
	public ModelAndView updateOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");
		String organName = (request.getParameter("organName") == null) ? "": request.getParameter("organName");
		Organ organ;
		
		if (organName.equals("")){
			organ = organService.getOrgan(organId);
			ModelAndView mv = new ModelAndView("updateOwner");
			mv.addObject("organ", organ);
			return mv;
		}
		
		organ = new Organ();

		bind(request, organ);
		
		organ.setRole(ROLE_OWNER);

		organService.updateOrgan(organ);

		return new ModelAndView("redirect:ownerList");

	}
	
	public ModelAndView deleteOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");

		organService.removeOrgan(organId);

		return new ModelAndView("redirect:ownerList");

	}

	public ModelAndView ownerList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		List<Organ> organs = organService.getOrgans(userId, ROLE_OWNER);
		
		ModelAndView mv = new ModelAndView("ownerList", "organs", organs);

		return mv;

	}
	
	public ModelAndView OwnerPagingList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
		String sortColumn = (request.getParameter("sortColumn") == null) ? "": request.getParameter("sortColumn");

		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		int pageSize = 10;

		Paging pagingList = organService.getOrgansWithPaging(userId, ROLE_OWNER, Integer.parseInt(pageNo), pageSize, sortColumn);
		
		ModelAndView mv = new ModelAndView("ownerList", "pagingList", pagingList);
		mv.addObject("organCount", pagingList.getTotalCount());
		mv.addObject("sortColumn", sortColumn);
		
		return mv;

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
		
		String organName = (request.getParameter("organName") == null) ? "": request.getParameter("organName");
		String userId = (request.getParameter("userId") == null) ? "": request.getParameter("userId");
		String ownerId = (request.getParameter("ownerId") == null) ? "": request.getParameter("ownerId");
		
		if (organName.equals("")){
			List<Organ> owners = organService.getAllOrgans(ROLE_OWNER);
			ModelAndView mv = new ModelAndView("createSubject");
			mv.addObject("owners", owners);
			return mv;
		}
		
		Organ organ = new Organ();
		
		bind(request, organ);
		
		organ.setRole(ROLE_SUBJECT);		
		
		organService.createOrgan(organ, ownerId);
		
	    return new ModelAndView("redirect:subjectList");
	    
	} 
	
	public ModelAndView showSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");

		Organ organ = organService.getOrgan(organId);
		
		return new ModelAndView("showSubject", "organ", organ);

	}
	
	public ModelAndView updateSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");
		String organName = (request.getParameter("organName") == null) ? "": request.getParameter("organName");
		String ownerId = (request.getParameter("ownerId") == null) ? "": request.getParameter("ownerId");
		
		Organ organ = organService.getOrgan(organId);
		
		if (organName.equals("")){			
			List<Organ> owners = organService.getAllOrgans(ROLE_OWNER);			
			ModelAndView mv = new ModelAndView("updateSubject");
			mv.addObject("owners", owners);
			mv.addObject("organ", organ);
			return mv;			
		}
		
		String costDetail = organ.getCostDetail();
		String nonApproval1 = organ.getNonApproval1();
		String nonApproval2 = organ.getNonApproval2();
		
		Organ organCommand = new Organ();
		bind(request, organCommand);		
		organCommand.setRole(ROLE_SUBJECT);
		organCommand.setCostDetail(costDetail);
		organCommand.setNonApproval1(nonApproval1);
		organCommand.setNonApproval2(nonApproval2);
		
		organService.updateOrgan(organCommand, ownerId);

		return new ModelAndView("redirect:subjectList");

	}
	
	public ModelAndView deleteSubject(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String organId = request.getParameter("organId");

		organService.removeOrgan(organId);

		return new ModelAndView("redirect:subjectList");

	}
	
	public ModelAndView subjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		List<Organ> organs = organService.getOrgans(userId, ROLE_SUBJECT);
		
		ModelAndView mv = new ModelAndView("subjectList", "organs", organs);

		return mv;

	}
	
	public ModelAndView subjectPagingList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
		String sortColumn = (request.getParameter("sortColumn") == null) ? "": request.getParameter("sortColumn");
		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
		
		int pageSize = 10;

		Paging pagingList = organService.getOrgansWithPaging(userId, ROLE_SUBJECT, Integer.parseInt(pageNo), pageSize, sortColumn);
		
		ModelAndView mv = new ModelAndView("subjectList", "pagingList", pagingList);
		mv.addObject("organCount", pagingList.getTotalCount());
		mv.addObject("sortColumn", sortColumn);
		mv.addObject("userId", userId);
		
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

		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		int pageSize = 10;

		Paging pagingList = organService.getOrgansWithPaging(userId, ROLE_SUBJECT, Integer.parseInt(pageNo), pageSize, sortColumn);
		
		ModelAndView mv = new ModelAndView("settlementList", "pagingList", pagingList);
		mv.addObject("organCount", pagingList.getTotalCount());
		mv.addObject("sortColumn", sortColumn);
		
		return mv;

	}
}