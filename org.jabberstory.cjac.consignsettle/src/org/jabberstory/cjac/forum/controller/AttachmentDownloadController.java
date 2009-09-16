package org.jabberstory.cjac.forum.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.ForumPermissionService;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.jabberstory.cjac.forum.domain.PostAttachment;
import org.jabberstory.web.util.WebUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.AccessDeniedException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

public class AttachmentDownloadController implements Controller, ApplicationContextAware {
	private ForumService forumService;
	private WebApplicationContext appContext;
	private ForumPermissionService forumPermissionService;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public void setForumPermissionService(ForumPermissionService permissionService) {
		this.forumPermissionService = permissionService;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
				this.appContext = (WebApplicationContext) applicationContext;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int postId = WebUtil.getIntParam(request, "post", -999);
		int attId = WebUtil.getIntParam(request, "file", -999);

		if (!forumPermissionService.hasReadPermission(forumService.getPost(postId)))
			throw new AccessDeniedException("You don't have enough permission to download");
		
		PostAttachment attachment = forumService.getPostAttachment(postId, Integer.valueOf(attId));
		File file;
		if (forumService.isUnix()) {
			file = new File(ForumService.FILE_PREFIX_UNIX + attachment.getDir() + "/" + attachment.getFilename());
		} else {
			file = new File(ForumService.FILE_PREFIX_WIN + attachment.getDir() + "/" + attachment.getFilename());
		}
		
		return new ModelAndView((View)appContext.getBean("downloadView"), "file", file);	// here we do not use view name. Instead use view object.
	}

}
