package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UserGroupListController extends SimpleFormController {

	private Logger log = Logger.getLogger(this.getClass());
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserGroupListController() {
		setCommandClass(UserSearchCommand.class);
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		UserSearchCommand query = (UserSearchCommand)command;
		
		List<UserGroup> groups = userService.getGroups(query.getGroupQuery());
		ModelAndView mv = new ModelAndView("user/userGroupList", "groups", groups);
		mv.addObject("groupCount", groups.size());
		return mv;
	}
}
