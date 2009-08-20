package org.jabberstory.cjac.consignsettle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class RemoveUserGroupController extends AbstractController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String groupId = request.getParameter("groupId");
		userService.removeUserGroup(groupId);
		return new ModelAndView("redirect:/user/list");
	}

}
