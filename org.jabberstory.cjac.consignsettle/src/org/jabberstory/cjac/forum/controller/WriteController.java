package org.jabberstory.cjac.forum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.ForumService;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class WriteController extends SimpleFormController {
	private ForumService forumService;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public WriteController() {
		this.setCommandClass(WriteSubmitCommand.class);
		this.setCommandName("write");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		WriteSubmitCommand writeCommand = (WriteSubmitCommand) command;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// auth type is UsernamePasswordAuthenticationToken.
		forumService.createPost(writeCommand.getTitle(), writeCommand.getBody(), auth.getName(), writeCommand.getFile());
		return new ModelAndView("redirect:/forum/list");
	}
}
