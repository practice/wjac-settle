package org.jabberstory.cjac.forum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.Forum;
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
		int forumId = ForumUtil.extractForumId(request);
		Forum forum = forumService.getForum(forumId);
		String idStr = request.getParameter("id");
		int id = Integer.valueOf(idStr);
		ForumPost post = forumService.getPost(id);
		if (post == null) {
			return null;
		}
		List<ForumPost> children = forumService.getChildrenPosts(id);
		request.setAttribute("post", post);
		request.setAttribute("children", children);
		request.setAttribute("childrenCount", new Integer(children.size()));
		request.setAttribute("forum", forum);
		return new ModelAndView("forum/showpost");
	}

}
