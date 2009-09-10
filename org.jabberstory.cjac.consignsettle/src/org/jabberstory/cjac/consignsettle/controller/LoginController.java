package org.jabberstory.cjac.consignsettle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class LoginController extends AbstractController {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ("anonymous".equals(auth.getName())) {
			return new ModelAndView("login");
		}
		return new ModelAndView("redirect:/organ/subjectList");
	}
}
