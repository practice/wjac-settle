package org.jabberstory.cjac.consignsettle.controller;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jabberstory.cjac.consignsettle.domain.OrganService;
import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AuthAdminMultiActionController extends MultiActionController {
	
	private Logger log = Logger.getLogger(this.getClass());

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private OrganService organService;

	public void setOrganService(OrganService organService) {
		this.organService = organService;
	}

	public AuthAdminMultiActionController() {}	

	public ModelAndView showUserAuthAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String selectedGroupId = request.getParameter("selectedGroupId");
		
		// 모든 사용자 그룹 목록
		List<UserGroup> userGroups = userService.getGroups("");
		
		// 가용 유저 목록: Any 그룹에 속하지 않은 유저 목록
		List<User> availableUsers = userService.getAvailableUsers();
		
		ModelAndView mv = new ModelAndView("admin/userAuthAdmin");
		mv.addObject("userGroups", userGroups);
		mv.addObject("availableUsers", availableUsers);
		
		// 사용자그룹으로 조회시
		if(selectedGroupId != null){
			
			// 해당 사용자 그룹에 할당한 사용자 목록		
			List<User> authorizedUsers = userService.getUsersByGroupId(selectedGroupId); 
			mv.addObject("selectedGroupId", selectedGroupId);
			mv.addObject("selectedUsers", authorizedUsers);
			return mv;
		}			
				
		return mv;
	}
	
	public ModelAndView updateUserAuthAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String selectedGroupId = request.getParameter("selectedGroupId");
		String[] selectedUserIds = request.getParameterValues("selectedUserId");

		// 모든 사용자 그룹 목록
		List<UserGroup> userGroups = userService.getGroups("");

		// 가용 유저  목록
		List<User> availableUsers = userService.getAvailableUsers();
		
		ModelAndView mv = new ModelAndView("admin/userAuthAdmin");
		mv.addObject("userGroups", userGroups);

		
		// 해당 그룹에 사용자 Assign
		if(selectedGroupId != null){
			
			// 선택한 사용자 목록 Set
			Set<User> selectedUsers = new HashSet<User>();
			if(selectedUserIds != null){
				for(int i=0; i<selectedUserIds.length; i++){			
					selectedUsers.add(userService.getUser(selectedUserIds[i]));
					
				}		
			}
			
			// 선택한 사용자그룹에 사용자 Assign
			userService.updateUserGroupWithUsers(selectedGroupId, selectedUsers);
			
			// 변경된 가용 유저 목록
			availableUsers = userService.getAvailableUsers();
			
			// 해당 사용자 그룹에 할당한 사용자 목록		
			List<User> authorizedUsers = userService.getUsersByGroupId(selectedGroupId);
			mv.addObject("selectedGroupId", selectedGroupId);
			mv.addObject("selectedUsers", authorizedUsers);			
		}	
		
		mv.addObject("availableUsers", availableUsers);
	
		return mv;
	}
}
