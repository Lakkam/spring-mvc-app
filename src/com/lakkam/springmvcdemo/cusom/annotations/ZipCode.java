package com.lakkam.springmvcdemo.cusom.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lakkam.springmvcdemo.validators.ZipCodeContraintValidator;

@Constraint(validatedBy = ZipCodeContraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCode {

	public String value() default "5";

	public String message() default "must start with 5";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}
