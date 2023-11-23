package com.happytohelpFinance.app.CustomerServiceI;

import java.util.Optional;

import com.happytohelpFinance.app.model.CustomerDetails;


public interface LoanDisbursementService {

	public CustomerDetails updateloanDisbursement( CustomerDetails cst);

	public Optional<CustomerDetails> finddById(Integer cstid);

}
