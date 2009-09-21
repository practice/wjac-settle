package org.jabberstory.cjac.consignsettle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UpdateUserController extends SimpleFormController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UpdateUserController() {
		setCommandClass(CreateUserCommand.class);
		setCommandName("updateUser");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {

		Map referenceMap = new HashMap();
		referenceMap.put("groups", userService.getGroups(""));
		return referenceMap;
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
		String userGorupId = (user.getUserGroup() == null)? "":user.getUserGroup().getGroupId();
		if (user != null) {
			command.setUserId(userId);
			command.setUsername(user.getUsername());
			command.setEmail(user.getEmail());
			command.setPassword(user.getPassword());
			command.setPasswordConfirm(user.getPassword());
			command.setAddress(user.getAddress());
			command.setPostnum1(user.getPostnum1());
			command.setPostnum2(user.getPostnum2());
			command.setPhone1(user.getPhone1());
			command.setPhone2(user.getPhone2());
			command.setPhone2(user.getPhone2());
			command.setGroupId(userGorupId);
		}
		return command;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		CreateUserCommand param = (CreateUserCommand) command;
		
		try{
			userService.updateUser(param.getUserId(), param.getPassword(), param
					.getUsername(), param.getEmail(), param.getPostnum1(), param
					.getPostnum2(), param.getAddress(), param.getPhone1(), param
					.getPhone2(), param.getPhone3(), param.getGroupId());
		}catch(Exception e){
			return showForm(request, response, errors);
		}
		return new ModelAndView("redirect:/user/list");
	}
}
