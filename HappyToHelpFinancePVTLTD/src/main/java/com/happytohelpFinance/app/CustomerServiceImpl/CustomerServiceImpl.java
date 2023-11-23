package com.happytohelpFinance.app.CustomerServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytohelpFinance.app.CustomerServiceI.CustomerServiceI;
import com.happytohelpFinance.app.Repository.CustomerRepository;
import com.happytohelpFinance.app.model.CustomerDetails;


@Service
public class CustomerServiceImpl implements CustomerServiceI {

	@Autowired
	CustomerRepository cr;
	
	@Override
	public CustomerDetails saveCustomer(CustomerDetails cd) {
		
		CustomerDetails save=cr.save(cd);
		return save;
	}

	@Override
	public Iterable<CustomerDetails> getCustomer() {
		Iterable<CustomerDetails> get=cr.findAll();
		return get;
	}

	@Override
	public Optional<CustomerDetails> findById(Integer enquid) {
		Optional<CustomerDetails> findById= cr.findById(enquid);
		return findById;
	}

	@Override
	public Iterable<CustomerDetails> getCustomerbyStatus(String custloanstatus) {
		Iterable<CustomerDetails> get = cr.findAllByCustomerLoanStatus(custloanstatus);
		return get;
	}

	@Override
	public CustomerDetails updateCustomer(CustomerDetails csd)
	{
		return cr.save(csd);	
	}

	@Override
	public void deleteData(Integer csid) {
		cr.deleteById(csid);	
		
	}

}
