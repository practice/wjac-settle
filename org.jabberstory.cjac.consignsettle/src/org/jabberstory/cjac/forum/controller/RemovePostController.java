package org.jabberstory.cjac.forum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.ForumPermissionService;
import org.jabberstory.cjac.forum.domain.ForumPost;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.jabberstory.web.util.WebUtil;
import org.springframework.security.AccessDeniedException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class RemovePostController extends AbstractController {
	private ForumService forumService;
	private ForumPermissionService forumPermissionService;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public void setForumPermissionService(ForumPermissionService permissionService) {
		this.forumPermissionService = permissionService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int forumId = ForumUtil.extractForumId(request);
		int id = WebUtil.getIntParam(request, "id", 0);
		int page = WebUtil.getIntParam(request, "page", 1);
		ForumPost post = forumService.getPost(id);

		if (!forumPermissionService.hasRemovePermission(post)) 
			throw new AccessDeniedException("You don't have enough permisson to remove");
		
		int rootId = post.getRootId();
		forumService.removePost(id);
		if (rootId == 0) {
			return new ModelAndView("redirect:" + ForumUtil.buildListUrl(forumId, page));
		} else {
			return new ModelAndView("redirect:" + ForumUtil.buildShowPostUrl(forumId, rootId, page));
		}
	}

}
