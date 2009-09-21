package org.jabberstory.cjac.forum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.Forum;
import org.jabberstory.cjac.forum.domain.ForumPermissionService;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.springframework.security.AccessDeniedException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ShowForumListController extends AbstractController {
	private ForumService forumService;
	private ForumPermissionService forumPermissionService;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!forumPermissionService.hasBrowserForumPermission())
			throw new AccessDeniedException("You don't have enough permission to browser forums");
		
		int page = getPageParam(request);
		ModelAndView mv = new ModelAndView("forum/showForumList");
		List<Forum> forums = forumService.getForums(page);
		if (forums.size() == 0)
			mv.addObject("isEmptyList", Boolean.valueOf(true));
		else
			mv.addObject("isEmptyList", Boolean.valueOf(false));
		mv.addObject("forums", forums);
		
		int numPages = forums.size() / (ForumService.PAGESIZE * 3);
		if ((forums.size() % (3 * ForumService.PAGESIZE)) != 0)
			numPages++;
		mv.addObject("numPages", numPages);
		mv.addObject("currentPage", page);
		int firstResult = ForumService.PAGESIZE * 3 * (page -1);
		for (int i=0; i < firstResult; i++) {
			forums.remove(0);
		}
		while (forums.size() > (ForumService.PAGESIZE * 3))
			forums.remove(forums.size() - 1);
		
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

	public void setForumPermissionService(ForumPermissionService forumPermissionService) {
		this.forumPermissionService = forumPermissionService;
	}

}
