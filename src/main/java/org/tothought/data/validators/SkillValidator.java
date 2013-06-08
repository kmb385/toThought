package org.tothought.data.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.tothought.data.entities.Skill;

public class SkillValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Skill.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "skillCategory", "skillCategory.empty");
		ValidationUtils.rejectIfEmpty(errors, "rating", "rating.empty");
	}

}
