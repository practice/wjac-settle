package org.jabberstory.cjac.consignsettle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class CreateUserController extends SimpleFormController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CreateUserController() {
		setCommandClass(CreateUserCommand.class);
		setCommandName("createUser");
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		CreateUserCommand param = (CreateUserCommand) command;
		userService.createUser(param.getUserId(), param.getPassword(), param.getUsername(), param.getEmail(), param.getRole());
		return new ModelAndView("redirect:/user/showUser?userId=" + param.getUserId());
	}
}
