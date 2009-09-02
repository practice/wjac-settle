package org.jabberstory.cjac.consignsettle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ShowUserGroupController extends AbstractController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		String groupId = request.getParameter("groupId");
//		UserGroup group = userService.getUserGroup(groupId);
//		ModelAndView mv = new ModelAndView("showUserGroup", "group", group);
//		return mv;
		return null;
	}
}
