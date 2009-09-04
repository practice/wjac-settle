package org.jabberstory.cjac.forum.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.ForumService;
import org.jabberstory.cjac.forum.domain.PostAttachment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

public class AttachmentDownloadController implements Controller, ApplicationContextAware {
	private ForumService forumService;
	private WebApplicationContext appContext;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
				this.appContext = (WebApplicationContext) applicationContext;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String postId = request.getParameter("post");
		String attId = request.getParameter("file");
		PostAttachment attachment = forumService.getPostAttachment(Integer.valueOf(postId), Integer.valueOf(attId));
		File file = new File(ForumService.FILE_PREFIX + attachment.getFilename());
		return new ModelAndView((View)appContext.getBean("downloadView"), "file", file);	// here we do not use view name. Instead use view object.
	}

}
