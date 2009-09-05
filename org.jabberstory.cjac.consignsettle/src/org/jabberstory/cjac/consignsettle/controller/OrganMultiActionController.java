package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.jabberstory.cjac.consignsettle.domain.Organ;
import org.jabberstory.cjac.consignsettle.domain.OrganService;
import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OrganMultiActionController extends MultiActionController {

	public OrganMultiActionController() {}

	private UserService userService;
	private OrganService organService;
	
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
		organ.setRole("O");
		
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
		
		organ.setRole("O");

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
		String role = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		List<Organ> organs = organService.getOrgans(userId, role);
		
		ModelAndView mv = new ModelAndView("ownerList", "organs", organs);

		return mv;

	}
	
	public ModelAndView OwnerPagingList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
		String sortColumn = (request.getParameter("sortColumn") == null) ? "": request.getParameter("sortColumn");

		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		String role = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		int pageSize = 10;

		Paging pagingList = organService.getOrgansWithPaging(userId, role, Integer.parseInt(pageNo), pageSize, sortColumn);
		
		ModelAndView mv = new ModelAndView("ownerList", "pagingList", pagingList);
		mv.addObject("organCount", pagingList.getTotalCount());
		mv.addObject("sortColumn", sortColumn);
		
		return mv;

	}
	
}