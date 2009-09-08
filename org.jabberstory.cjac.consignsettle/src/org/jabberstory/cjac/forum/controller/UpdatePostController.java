package org.jabberstory.cjac.forum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//			command.setTitle(post.getSubject());
			String subject = post.getSubject().replaceAll("\"", "&quot;");
			command.setTitle(subject);
			command.setBody(post.getBody());
		}
		return command;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		WriteSubmitCommand param = (WriteSubmitCommand) command;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body", "required");
		if (errors.hasErrors())
			return showForm(request, response, errors);
		forumService.updatePost(Integer.valueOf(param.getId()), param.getTitle(), param.getBody());
		return new ModelAndView("redirect:/forum/showpost?id=" + param.getId());
	}
}
