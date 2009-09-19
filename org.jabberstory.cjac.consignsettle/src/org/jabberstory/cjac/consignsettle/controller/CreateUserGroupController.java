package org.jabberstory.cjac.consignsettle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.UserGroup;
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
	
	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		List<UserGroup> ownerGroups = userService.getGroupsByRole("O");
		HashMap map = new HashMap();
		map.put("ownerGroups", ownerGroups);
		return map;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		CreateUserGroupCommand param = (CreateUserGroupCommand) command;
		userService.createUserGroup(param.getGroupName(), param.getRole(), param.getParentGroup());
		return new ModelAndView("redirect:/user/userGroupList");
	}
}
