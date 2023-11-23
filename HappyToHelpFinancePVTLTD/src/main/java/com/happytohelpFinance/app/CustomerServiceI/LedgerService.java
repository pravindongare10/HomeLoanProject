package com.happytohelpFinance.app.CustomerServiceI;

import java.util.Optional;

import com.happytohelpFinance.app.model.CustomerDetails;


public interface LedgerService {

public	Optional<CustomerDetails> findById(Integer cusid);

public CustomerDetails saveCustomerLedger(CustomerDetails customerDetails);

}
