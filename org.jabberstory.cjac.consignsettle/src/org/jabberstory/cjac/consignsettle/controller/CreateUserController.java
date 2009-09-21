package org.jabberstory.cjac.consignsettle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.Organ;
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

	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {

		Map referenceMap = new HashMap();
		referenceMap.put("groups", userService.getGroups(""));
		return referenceMap;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		CreateUserCommand param = (CreateUserCommand) command;

		try{
			userService.createUser(param.getUserId(), param.getPassword(), param
					.getUsername(), param.getEmail(), param.getPostnum1(), param
					.getPostnum2(), param.getAddress(), param.getPhone1(), param
					.getPhone2(), param.getPhone3(), param.getGroupId());
		}catch(Exception e){
			return showForm(request, response, errors);
		}

		return new ModelAndView("redirect:/user/list");
	}
}
