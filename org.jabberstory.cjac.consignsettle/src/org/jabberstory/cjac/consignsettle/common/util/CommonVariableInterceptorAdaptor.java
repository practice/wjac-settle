package org.jabberstory.cjac.consignsettle.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.jabberstory.cjac.forum.domain.Forum;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonVariableInterceptorAdaptor extends HandlerInterceptorAdapter {
	private UserService userService;
	private ForumService forumService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView mv) throws Exception {
		// user info.
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// 로그인 화면에서 아래 코드가 return 하지 않는다.
//		if (!auth.isAuthenticated())
//			return;
		User user = userService.getUser(auth.getName());
		if (user == null)
			return;
		
		mv.addObject("user", user);
		mv.addObject("imgpath", request.getContextPath() + "/img");
		
		// forums for this user's group.
		List<Forum> forums = forumService.getForumsFor(user.getUserId());
		for (Forum forum : forums) {
			if (forum.getForumType().equals(Forum.PUBLIC_TYPE))
				mv.addObject("publicForum", forum.getId());
			if (forum.getForumType().equals(Forum.QNA_TYPE))
				mv.addObject("qnaForum", forum.getId());
			if (forum.getForumType().equals(Forum.FILES_TYPE))
				mv.addObject("filesForum", forum.getId());
		}
	}

}
