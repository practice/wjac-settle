package org.jabberstory.cjac.forum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.jabberstory.cjac.forum.domain.Forum;
import org.jabberstory.cjac.forum.domain.ForumPermissionService;
import org.jabberstory.cjac.forum.domain.ForumPost;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.springframework.security.AccessDeniedException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ForumListController extends AbstractController {

	private ForumService forumService;
	private UserService userService;
	private ForumPermissionService forumPermissionService;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public void setForumPermissionService(ForumPermissionService permissionService) {
		this.forumPermissionService = permissionService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int forumId = ForumUtil.extractForumId(request);
		Forum forum = forumService.getForum(forumId);

		if (!forumPermissionService.hasReadPermission(forum)) {
			throw new AccessDeniedException("You don't have enough permission for this forum");
		}
		
		int page = getPageParam(request);
		ModelAndView mv = new ModelAndView();
		List<ForumPost> posts = forumService.getTopLevelPosts(forumId, page);

		mv.addObject("forum", forum);
		mv.addObject("userGroup", userService.getUserGroup(forum.getGroupId()));
		mv.addObject("posts", posts);
		if (posts.isEmpty())
			mv.addObject("isEmptyList", Boolean.TRUE);
		else
			mv.addObject("isEmptyList", Boolean.FALSE);

		Long numPages = forumService.getPageCount(forumId);
		mv.addObject("numPages", numPages);
		mv.addObject("currentPage", page);

		mv.setViewName("forum/list");
		return mv;
	}

	private int getPageParam(HttpServletRequest request) {
		String pageString = request.getParameter("page");
		int page = 0;
		try {
			page = Integer.parseInt(pageString);
		} catch (NumberFormatException e) {
		}
		if (page < 1)
			page = 1;
		return page;
	}
}
