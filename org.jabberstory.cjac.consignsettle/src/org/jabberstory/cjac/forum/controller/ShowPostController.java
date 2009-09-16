package org.jabberstory.cjac.forum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.Forum;
import org.jabberstory.cjac.forum.domain.ForumPost;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.jabberstory.web.util.WebUtil;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ShowPostController extends AbstractController {
	private ForumService forumService;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int forumId = ForumUtil.extractForumId(request);
		Forum forum = forumService.getForum(forumId);
		int id = WebUtil.getIntParam(request, "id", -1);
		ForumPost post = forumService.getPost(id);
		if (post == null) {
			return null;
		}
		List<ForumPost> children = forumService.getChildrenPosts(id);
		request.setAttribute("post", post);
		request.setAttribute("children", children);
		request.setAttribute("childrenCount", new Integer(children.size()));
		request.setAttribute("forum", forum);
		
		// for Modify, Remove buttons.
		String logonId = SecurityContextHolder.getContext().getAuthentication().getName();
		if (post.getUser().getUserId().equals(logonId) || "admin".equals(logonId)) {
			post.getProp().put("canModify", Boolean.valueOf(true));
		} else {
			post.getProp().put("canModify", Boolean.valueOf(false));
		}
		for (ForumPost forumPost : children) {
			if (forumPost.getUser().getUserId().equals(logonId) || "admin".equals(logonId)) {
				forumPost.getProp().put("canModify", Boolean.valueOf(true));
			} else {
				forumPost.getProp().put("canModify", Boolean.valueOf(false));
			}
		}
		return new ModelAndView("forum/showpost");
	}

}
