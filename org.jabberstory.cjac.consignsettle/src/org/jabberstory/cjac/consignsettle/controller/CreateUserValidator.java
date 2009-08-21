package org.jabberstory.cjac.consignsettle.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CreateUserValidator implements Validator {

	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz) {
		return CreateUserCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CreateUserCommand param = (CreateUserCommand)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "required");
		if (!param.getPassword().equals(param.getPasswordConfirm()))
			errors.rejectValue("passwordConfirm", "password mismatch");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
	}

}
