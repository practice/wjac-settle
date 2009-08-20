package org.jabberstory.cjac.consignsettle.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UpdateUserGroupController extends SimpleFormController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UpdateUserGroupController() {
		setCommandClass(CreateUserGroupCommand.class);
		setCommandName("updateUserGroup");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		HashMap<String, String> availableRoles = new HashMap<String, String>();
		availableRoles.put("A", "Admin");
		availableRoles.put("C", "회계법인");
		availableRoles.put("O", "전담기관");
		availableRoles.put("S", "주관기관");
		
		HashMap map = new HashMap();
		map.put("availableRoles", availableRoles);
		return map;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		if (isFormSubmission(request)) {
			return super.formBackingObject(request);
		}
		CreateUserGroupCommand command = new CreateUserGroupCommand();
		String groupId = request.getParameter("groupId");
		UserGroup group = userService.getUserGroup(groupId);
		if (group != null) {
			command.setGroupId(groupId);
			command.setName(group.getName());
			command.setRole(group.getRole());
		}
		return command;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		CreateUserGroupCommand param = (CreateUserGroupCommand) command;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		if (errors.hasErrors())
			return showForm(request, response, errors);
		userService.updateUserGroup(param.getGroupId(), param.getName(), param.getRole());
		return new ModelAndView("redirect:/user/showUserGroup?groupId=" + param.getGroupId());
	}
}
