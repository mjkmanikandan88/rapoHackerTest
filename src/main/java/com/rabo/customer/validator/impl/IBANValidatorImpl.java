package com.rabo.customer.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rabo.customer.proxy.service.IBanValidatorProxyService;
import com.rabo.customer.validator.inf.IBANValidator;

public class IBANValidatorImpl implements ConstraintValidator<IBANValidator, String> {

	@Autowired
	IBanValidatorProxyService proxyService;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return proxyService.isValidIBN(value);
	}

}
