package org.jabberstory.cjac.forum.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.forum.domain.Forum;
import org.jabberstory.cjac.forum.domain.ForumPost;
import org.jabberstory.cjac.forum.domain.ForumService;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UpdatePostController extends SimpleFormController {
	private ForumService forumService;

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public UpdatePostController() {
		setCommandClass(WriteSubmitCommand.class);
		setCommandName("updatePost");
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
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		if (isFormSubmission(request)) {
			return super.formBackingObject(request);
		}
		WriteSubmitCommand command = new WriteSubmitCommand();
		String id = request.getParameter("id");
		ForumPost post = forumService.getPost(Integer.valueOf(id));
		if (post != null) {
			command.setId(id);
			if (post.getSubject() != null) {
				String subject = post.getSubject().replaceAll("\"", "&quot;");
				command.setTitle(subject);
			}
			command.setBody(post.getBody());
		}
		return command;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		int forumId = ForumUtil.extractForumId(request);
		int page = ForumUtil.getIntParam(request, "page", 1);
		WriteSubmitCommand param = (WriteSubmitCommand) command;
		ForumPost oldPost = forumService.getPost(Integer.valueOf(param.getId()));
		if (oldPost.getRootId() == 0) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body", "required");
		if (errors.hasErrors())
			return showForm(request, response, errors);
		ForumPost post = forumService.updatePost(Integer.valueOf(param.getId()), param.getTitle(), param.getBody());
		int rootId = post.getId();
		if (post.getRootId() != 0) {
			rootId = post.getRootId();
		}
		return new ModelAndView("redirect:" + ForumUtil.buildShowPostUrl(forumId, rootId, page));
	}
}
