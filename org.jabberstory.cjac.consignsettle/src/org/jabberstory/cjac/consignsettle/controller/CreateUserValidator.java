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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postnum1", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postnum2", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone1", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone2", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone3", "required");
	}

}
