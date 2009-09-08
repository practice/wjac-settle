package org.jabberstory.cjac.forum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.ForumPost;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class RemovePostController extends AbstractController {
	private ForumService forumService;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int id = Integer.valueOf(request.getParameter("id"));
		String page = request.getParameter("page");
		ForumPost post = forumService.getPost(id);
		int rootId = post.getRootId();
		forumService.removePost(id);
		if (rootId == 0) {
			return new ModelAndView("redirect:/forum/list?page=" + page);
		} else {
			return new ModelAndView("redirect:/forum/showpost?id=" + rootId + "&page=" + page);
		}
	}

}
