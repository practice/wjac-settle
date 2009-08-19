package org.jabberstory.cjac.consignsettle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class CreateUserGroupController extends SimpleFormController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CreateUserGroupController() {
		setCommandClass(CreateUserGroupCommand.class);
		setCommandName("createUserGroup");
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		CreateUserGroupCommand param = (CreateUserGroupCommand) command;
		userService.createUserGroup(param.getGroupId(), param.getName(), param.getRole());
		return new ModelAndView("redirect:/forum/userGroup?groupId=" + param.getGroupId());
	}
}
