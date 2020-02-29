package com.rabo.customer.model.wrapper;

import javax.validation.constraints.NotNull;

import com.rabo.customer.models.CustomerStatement;
@NotNull
public class CutstomerStatementWrapper {

	private CustomerStatement customerStatement;

	public CustomerStatement getCustomerStatement() {
		return customerStatement;
	}

	public void setCustomerStatement(CustomerStatement customerStatement) {
		this.customerStatement = customerStatement;
	}
	
	
}
