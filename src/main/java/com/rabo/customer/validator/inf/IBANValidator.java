package com.rabo.customer.validator.inf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.rabo.customer.validator.impl.IBANValidatorImpl;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IBANValidatorImpl.class)
public @interface IBANValidator {
	    String message() default "{com.dolszewski.blog.UniqueLogin.message}";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
}
