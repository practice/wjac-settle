package org.jabberstory.cjac.consignsettle.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonVariableInterceptorAdaptor extends HandlerInterceptorAdapter {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getUser(auth.getName());
		mv.addObject("user", user);
		mv.addObject("imgpath", request.getContextPath() + "/img");
	}
}
