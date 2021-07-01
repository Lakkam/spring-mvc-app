package com.lakkam.springmvcdemo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lakkam.springmvcdemo.cusom.annotations.LastNameAnnotation;

public class LastNameConstraintValidator implements ConstraintValidator<LastNameAnnotation, String> {
	
	@Override
	public boolean isValid(String lastName, ConstraintValidatorContext validatorContext) {

		if(lastName.contains("lakkam")) {
			return true;
		}
		return false;
	}

}
