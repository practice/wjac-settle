package org.jabberstory.cjac.forum.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.Forum;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.jabberstory.web.util.WebUtil;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
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
	
	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		HashMap map = new HashMap();
		int forumId = ForumUtil.extractForumId(request);
		Forum forum = forumService.getForum(forumId);
		map.put("forum", forum);
		return map;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		int forumId = ForumUtil.extractForumId(request);
		int id = WebUtil.getIntParam(request, "id", -999);
		WriteSubmitCommand writeCommand = (WriteSubmitCommand) command;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// auth type is UsernamePasswordAuthenticationToken.
		if (id > 0) {  // this is reply.
			int page = Integer.parseInt(request.getParameter("page"));
			forumService.createReply(forumId, id, 
					writeCommand.getTitle(), writeCommand.getBody(), auth.getName(), writeCommand.getFiles());
			return new ModelAndView("redirect:" + ForumUtil.buildShowPostUrl(forumId, id, page));
		}
		// new forum thread.
		forumService.createPost(forumId, writeCommand.getTitle(), writeCommand.getBody(), auth.getName(), writeCommand.getFiles());
		return new ModelAndView("redirect:" + ForumUtil.buildListUrl(forumId));
	}
	
	@Override
	protected ServletRequestDataBinder createBinder(HttpServletRequest request,
			Object command) throws Exception {
		ServletRequestDataBinder binder = new MultiFileSupportServletRequestDataBinder(command, getCommandName());
		prepareBinder(binder);
		initBinder(request, binder);
		return binder;
	}
}
