package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.Organ;
import org.jabberstory.cjac.consignsettle.domain.OrganService;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

public class OrganExcelController implements Controller{

	private UserService userService;
	private OrganService organService;
	private View organExcelView;
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	public void setOrganService(OrganService organService){
		this.organService = organService;
	}
	
	public void setOrganExcelView(View organExcelView){
		this.organExcelView = organExcelView;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {

		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
		String userRole = userService.getUserRole(userId);
		
		List<Organ> organs = organService.getOrgans(userId, userRole);
		
		return new ModelAndView(organExcelView,"organs",organs);
	}
	
}
