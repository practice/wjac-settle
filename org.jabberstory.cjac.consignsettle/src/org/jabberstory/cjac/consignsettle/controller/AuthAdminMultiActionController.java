package org.jabberstory.cjac.consignsettle.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.Organ;
import org.jabberstory.cjac.consignsettle.domain.OrganService;
import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AuthAdminMultiActionController extends MultiActionController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private OrganService organService;

	public void setOrganService(OrganService organService) {
		this.organService = organService;
	}

	public AuthAdminMultiActionController() {}	

	public ModelAndView showOrganAuthAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String selectedGroupId = request.getParameter("selectedGroupId");
		
		// 모든 사용자 그룹 목록
		List<UserGroup> userGroups = userService.getGroups("");
		
		// 가용 기관(전체 기관) 목록
		List<Organ> availableOrgans = organService.getAllOrgans();		
		
		ModelAndView mv = new ModelAndView("organAuthAdmin");
		mv.addObject("userGroups", userGroups);
		mv.addObject("availableOrgans", availableOrgans);
		
		// 사용자그룹으로 조회시
		if(selectedGroupId != null){
			
			// 해당 사용자 그룹이 접근 가능한 기관 목록		
			List<Organ> authrizedOrgans = organService.getOrgansByUserGroup(selectedGroupId);
			mv.addObject("selectedGroupId", selectedGroupId);
			mv.addObject("selectedOrgans", authrizedOrgans);
			return mv;
		}			
				
		return mv;
	}
			
	public ModelAndView updateOrganAuthAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String selectedGroupId = request.getParameter("selectedGroupId");
		String[] selectedOrganIds = request.getParameterValues("selectedOrganId");

		// 모든 사용자 그룹 목록
		List<UserGroup> userGroups = userService.getGroups("");
		
		// 가용 기관(전체 기관) 목록
		List<Organ> availableOrgans = organService.getAllOrgans();		
		
		ModelAndView mv = new ModelAndView("organAuthAdmin");
		mv.addObject("userGroups", userGroups);
		mv.addObject("availableOrgans", availableOrgans);
		
		// 해당 그룹에 기관 Assign
		if(selectedOrganIds != null && selectedGroupId != null){
			
			// 선택한 기관 목록 Set
			Set<Organ> selectedOrgans = new HashSet<Organ>();		
			for(int i=0; i<selectedOrganIds.length; i++){			
				selectedOrgans.add(organService.getOrgan(selectedOrganIds[i]));
			}		
			
			// 선택한 사용자그룹에 기관 Assign
			userService.updateUserGroupWithOrgans(selectedGroupId, selectedOrgans);
			
			// 해당 사용자 그룹이 접근 가능한 기관 목록		
			List<Organ> authrizedOrgans = organService.getOrgansByUserGroup(selectedGroupId);
			mv.addObject("selectedGroupId", selectedGroupId);
			mv.addObject("selectedOrgans", authrizedOrgans);
			return mv;
		}	
	
		return mv;
	}
	
	public ModelAndView showUserAuthAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String selectedGroupId = request.getParameter("selectedGroupId");
		
		// 모든 사용자 그룹 목록
		List<UserGroup> userGroups = userService.getGroups("");
		
		// 가용 유저(전체 유저) 목록
		List<User> availableUsers = userService.getAllUsers();
		
		ModelAndView mv = new ModelAndView("userAuthAdmin");
		mv.addObject("userGroups", userGroups);
		mv.addObject("availableUsers", availableUsers);
		
		// 사용자그룹으로 조회시
		if(selectedGroupId != null){
			
			// 해당 사용자 그룹에 할당한 사용자 목록		
			List<User> authrizedUsers = userService.getUsersByUserGroup(selectedGroupId); 
			mv.addObject("selectedGroupId", selectedGroupId);
			mv.addObject("selectedUsers", authrizedUsers);
			return mv;
		}			
				
		return mv;
	}
	
	public ModelAndView updateUserAuthAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String selectedGroupId = request.getParameter("selectedGroupId");
		String[] selectedUserIds = request.getParameterValues("selectedUserId");

		// 모든 사용자 그룹 목록
		List<UserGroup> userGroups = userService.getGroups("");
		
		// 가용 유저(전체 유저) 목록
		List<User> availableUsers = userService.getAllUsers();		
		
		ModelAndView mv = new ModelAndView("userAuthAdmin");
		mv.addObject("userGroups", userGroups);
		mv.addObject("availableUsers", availableUsers);
		
		// 해당 그룹에 사용자 Assign
		if(selectedUserIds != null && selectedGroupId != null){
			
			// 선택한 사용자 목록 Set
			Set<User> selectedUsers = new HashSet<User>();		
			for(int i=0; i<selectedUserIds.length; i++){			
				selectedUsers.add(userService.getUser(selectedUserIds[i]));
			}		
			
			// 선택한 사용자그룹에 사용자 Assign
			userService.updateUserGroupWithUsers(selectedGroupId, selectedUsers);
			
			// 해당 사용자 그룹에 할당한 사용자 목록		
			List<User> authrizedUsers = userService.getUsersByUserGroup(selectedGroupId); 
			mv.addObject("selectedGroupId", selectedGroupId);
			mv.addObject("selectedUsers", authrizedUsers);
			return mv;
		}	
	
		return mv;
	}
}
