package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class UserGroupListController extends AbstractController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserGroupListController() {
//		setCommandClass(UserSearchCommand.class);
	}
	
//	@Override
//	protected ModelAndView onSubmit(HttpServletRequest request,
//			HttpServletResponse response, Object command, BindException errors)
//			throws Exception {
//		UserSearchCommand query = (UserSearchCommand)command;
//		
//		List<UserGroup> groups = userService.getGroups(query.getGroupQuery());
//		ModelAndView mv = new ModelAndView("user/userGroupList", "groups", groups);
//		mv.addObject("groupCount", groups.size());
//		return mv;
//	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
		String groupQuery = (request.getParameter("groupQuery") == null) ? "": request.getParameter("groupQuery");
		
		Paging	pagingList = userService.getUserGroupsWithPaging(Integer.parseInt(pageNo), 10, groupQuery);
		
		ModelAndView mv = new ModelAndView("user/userGroupList", "pagingList", pagingList);
		mv.addObject("groupQuery", groupQuery);
		return mv;
	}
}
