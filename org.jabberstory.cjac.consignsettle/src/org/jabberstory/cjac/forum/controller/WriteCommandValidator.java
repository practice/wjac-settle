package org.jabberstory.cjac.forum.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class WriteCommandValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return WriteSubmitCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WriteSubmitCommand command = (WriteSubmitCommand)target;
		// title check is needed only when this is new thread post.
		if (command.getId() == null) { 
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "body", "required");
	}

}
