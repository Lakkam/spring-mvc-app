package com.lakkam.springmvcdemo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lakkam.springmvcdemo.cusom.annotations.ZipCode;

public class ZipCodeContraintValidator implements ConstraintValidator<ZipCode, String> {

	private String zipCodePrefix;

	@Override
	public boolean isValid(String theZipCode, ConstraintValidatorContext validatorContext) {

		boolean result = false;
		if (theZipCode != null) {
			result = theZipCode.startsWith(zipCodePrefix);
			return result;
		} else {

			return result;
		}
	}

	@Override
	public void initialize(ZipCode constraintAnnotation) {
		zipCodePrefix = constraintAnnotation.value();
	}
}
