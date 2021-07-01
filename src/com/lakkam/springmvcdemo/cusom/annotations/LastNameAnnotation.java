package com.lakkam.springmvcdemo.cusom.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lakkam.springmvcdemo.validators.LastNameConstraintValidator;

/*
 * This is a custom annotation and we have follow the below approach to enable the same
 */

@Constraint(validatedBy = LastNameConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LastNameAnnotation {
	

	public String value() default "";

	public String message() default "must contains lakkam";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
	
	

}
