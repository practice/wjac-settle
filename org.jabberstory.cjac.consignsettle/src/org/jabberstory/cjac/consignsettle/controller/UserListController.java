package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class UserListController extends AbstractController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserListController() {
		//setCommandClass(UserSearchCommand.class);
	}
	
//	@Override
//	protected ModelAndView onSubmit(HttpServletRequest request,
//			HttpServletResponse response, Object command, BindException errors)
//			throws Exception {
//		UserSearchCommand query = (UserSearchCommand)command;
//		List<User> users = userService.getUsers(query.getUserQuery());
//		ModelAndView mv = new ModelAndView("user/userList", "users", users);
//		mv.addObject("userCount", users.size());
//		return mv;
//	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<User> users = userService.getUsers("");
		ModelAndView mv = new ModelAndView("user/userList", "users", users);
		mv.addObject("userCount", users.size());
		return mv;
	}
}
