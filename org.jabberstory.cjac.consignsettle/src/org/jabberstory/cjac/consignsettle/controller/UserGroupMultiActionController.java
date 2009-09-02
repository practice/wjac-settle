package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserGroupService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserGroupMultiActionController extends MultiActionController {

	public UserGroupMultiActionController() {}

	private UserGroupService userGroupService;
	
	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}
	
	public ModelAndView createOwner(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		String groupName = (request.getParameter("groupName") == null) ? "": request.getParameter("groupName");
		
		if (groupName.equals("")){
			return new ModelAndView("createOwner");
		}
		
		UserGroup userGroup = new UserGroup();
		
		bind(request, userGroup);
		
		userGroupService.createUserGroup(userGroup);
		
	    return new ModelAndView("redirect:listOwner");
	    
	} 
	
	public ModelAndView showOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String groupId = request.getParameter("groupId");

		UserGroup userGroup = userGroupService.getUserGroup(groupId);
		
		return new ModelAndView("showOwner", "userGroup", userGroup);

	}
	
	public ModelAndView updateOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String groupId = request.getParameter("groupId");
		String groupName = (request.getParameter("groupName") == null) ? "": request.getParameter("groupName");
		UserGroup userGroup;
		
		if (groupName.equals("")){
			userGroup = userGroupService.getUserGroup(groupId);
			return new ModelAndView("updateOwner", "userGroup", userGroup);
		}
		
		userGroup = new UserGroup();

		bind(request, userGroup);

		userGroupService.updateUserGroup(userGroup);

		return new ModelAndView("redirect:listOwner");

	}
	
	public ModelAndView deleteOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String groupId = request.getParameter("groupId");

		userGroupService.removeUserGroup(groupId);

		return new ModelAndView("redirect:listOwner");

	}

	public ModelAndView listOwner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		String role = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		List<UserGroup> userGroups = userGroupService.getUserGroups(userId, role);
		
		ModelAndView mv = new ModelAndView("listOwner", "userGroups", userGroups);

		return mv;

	}
	
	public ModelAndView OwnerPagingList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
		String sortColumn = (request.getParameter("sortColumn") == null) ? "": request.getParameter("sortColumn");

		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		String role = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		int pageSize = 10;

		Paging pagingList = userGroupService.getUserGroupsWithPaging(userId, role, Integer.parseInt(pageNo), pageSize, sortColumn);
		
		ModelAndView mv = new ModelAndView("listOwner", "pagingList", pagingList);
		mv.addObject("userGroupCount", pagingList.getTotalCount());
		mv.addObject("sortColumn", sortColumn);
		
		return mv;

	}
	
}