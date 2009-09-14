package org.jabberstory.cjac.consignsettle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UpdateUserController extends SimpleFormController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UpdateUserController() {
		setCommandClass(CreateUserCommand.class);
		setCommandName("updateUser");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		if (isFormSubmission(request)) {
			return super.formBackingObject(request);
		}
		CreateUserCommand command = new CreateUserCommand();
		String userId = request.getParameter("userId");
		User user = userService.getUser(userId);
		if (user != null) {
			command.setUserId(userId);
			command.setUsername(user.getUsername());
			command.setEmail(user.getEmail());
			command.setPassword(user.getPassword());
			command.setPasswordConfirm(user.getPassword());
		}
		return command;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		CreateUserCommand param = (CreateUserCommand) command;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "required");
		if (errors.hasErrors())
			return showForm(request, response, errors);
		userService.updateUser(param.getUserId(),param.getPassword(),param.getUsername(),param.getEmail());
		return new ModelAndView("redirect:/user/list");
	}
}
