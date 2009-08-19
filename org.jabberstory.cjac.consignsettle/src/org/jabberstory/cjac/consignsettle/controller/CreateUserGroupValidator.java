package org.jabberstory.cjac.consignsettle.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CreateUserGroupValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return CreateUserGroupCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "groupId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
	}

}
