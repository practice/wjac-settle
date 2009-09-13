package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UserListController extends SimpleFormController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserListController() {
		setCommandClass(UserSearchCommand.class);
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		UserSearchCommand query = (UserSearchCommand)command;
		if (query.getUserQuery() != null && query.getUserQuery().trim().length() > 0) {
			List<User> users = userService.getUsers(query.getUserQuery());
			ModelAndView mv = new ModelAndView("user/userList", "users", users);
			mv.addObject("userCount", users.size());
			return mv;
		} 
		if (query.getGroupQuery() != null && query.getGroupQuery().trim().length() > 0) {
			List<UserGroup> groups = userService.getGroups(query.getGroupQuery());
			ModelAndView mv = new ModelAndView("user/userList", "groups", groups);
			mv.addObject("groupCount", groups.size());
			return mv;
		}
		return new ModelAndView("user/userList");
	}
}
