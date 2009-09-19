package org.jabberstory.cjac.consignsettle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
		TreeMap availableRoles = new TreeMap();
		availableRoles.put("A", "Admin");
		availableRoles.put("C", "회계법인");
		availableRoles.put("O", "전담기관");
		availableRoles.put("S", "주관기관");
		
		HashMap map = new HashMap();
		map.put("availableRoles", availableRoles);
		
		String groupId = request.getParameter("groupId");
		UserGroup group = userService.getUserGroup(groupId);
		List<UserGroup> ownerGroupList = userService.getGroupsByRole("O");
		TreeMap ownerGroups = new TreeMap();
		for (UserGroup userGroup : ownerGroupList) {
			if (group != null && !group.getGroupId().equals(userGroup.getGroupId()))
				ownerGroups.put(userGroup.getGroupId(), userGroup.getGroupName());
		}
		map.put("ownerGroups", ownerGroups);

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
			command.setGroupName(group.getGroupName());
			command.setRole(group.getRole());
			if (group.getParentGroup() != null)
				command.setParentGroup(group.getParentGroup().getGroupId());
		}
		return command;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		CreateUserGroupCommand param = (CreateUserGroupCommand) command;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "groupName", "required");
		if (errors.hasErrors())
			return showForm(request, response, errors);
		userService.updateUserGroup(param.getGroupId(), param.getGroupName(), param.getRole(), param.getParentGroup());
		return new ModelAndView("redirect:/user/userGroupList");
	}
}
