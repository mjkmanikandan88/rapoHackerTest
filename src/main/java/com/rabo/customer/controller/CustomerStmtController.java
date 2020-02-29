package com.rabo.customer.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerStmtController {

	Logger logger = Logger.getLogger(CustomerStmtController.class.getName());

	@PostMapping("/validateCustStmt")
	public String ValidateCustomerStmt(@RequestParam(value = "customerStmt", defaultValue = "") String customerJson) {
		logger.info("ValidateCustStmt started..." + customerJson);
		return customerJson;
	}

}
