package com.rabo.customer.proxy.service;

import org.apache.commons.validator.routines.IBANValidator;
import org.springframework.stereotype.Service;

@Service
public class IBanValidatorProxyService {

	public boolean isValidIBN(String code) {
		return IBANValidator.getInstance().isValid(code);
	}

}
