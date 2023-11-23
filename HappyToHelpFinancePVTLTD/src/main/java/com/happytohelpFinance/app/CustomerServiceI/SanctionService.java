package com.happytohelpFinance.app.CustomerServiceI;

import java.util.Optional;

import com.happytohelpFinance.app.exception.PdfNotGenerated;
import com.happytohelpFinance.app.model.CustomerDetails;
import com.happytohelpFinance.app.model.SanctionLetter;


public interface SanctionService {

	public Iterable<CustomerDetails> getCustomerbyStatus(String custloanstatus);

	public CustomerDetails updateCustomer(Integer cstid, CustomerDetails csd);

	public CustomerDetails generateSactionId(Integer customerid, SanctionLetter sanctionLetter) throws PdfNotGenerated;

	public Optional<CustomerDetails> findById(Integer cusid);

	public Iterable<CustomerDetails> findByLoanStatus(String loanStatus);

	public CustomerDetails changeStatus(CustomerDetails customerDetails);

}
