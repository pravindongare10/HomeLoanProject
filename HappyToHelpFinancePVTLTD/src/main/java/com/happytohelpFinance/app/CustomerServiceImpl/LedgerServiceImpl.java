package com.happytohelpFinance.app.CustomerServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytohelpFinance.app.CustomerServiceI.LedgerService;
import com.happytohelpFinance.app.Repository.CustomerRepository;
import com.happytohelpFinance.app.model.CustomerDetails;


@Service
public class LedgerServiceImpl implements LedgerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Optional<CustomerDetails> findById(Integer cusid) {
		Optional<CustomerDetails> findById = customerRepository.findById(cusid);
		return findById;
	}

	@Override
	public CustomerDetails saveCustomerLedger(CustomerDetails customerDetails) {
		CustomerDetails savedCustomerDetails = customerRepository.save(customerDetails);
		return savedCustomerDetails;
	}

}
