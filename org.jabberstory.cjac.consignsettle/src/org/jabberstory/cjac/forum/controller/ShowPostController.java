package org.jabberstory.cjac.forum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.ForumPost;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ShowPostController extends AbstractController {
	private ForumService forumService;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		ForumPost post = forumService.getPost(Integer.valueOf(id));
		if (post == null) {
			return null;
		}
		request.setAttribute("post", post);
		return new ModelAndView("forum/showpost");
	}

}
