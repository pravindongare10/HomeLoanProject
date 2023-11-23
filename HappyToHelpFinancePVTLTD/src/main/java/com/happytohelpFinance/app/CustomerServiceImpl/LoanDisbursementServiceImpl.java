package com.happytohelpFinance.app.CustomerServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytohelpFinance.app.CustomerServiceI.LoanDisbursementService;
import com.happytohelpFinance.app.Repository.CustomerRepository;
import com.happytohelpFinance.app.model.CustomerDetails;


@Service
public class LoanDisbursementServiceImpl implements LoanDisbursementService {
	
	@Autowired
	CustomerRepository cr;
	
	@Override
	public CustomerDetails updateloanDisbursement( CustomerDetails cst)
	{

		CustomerDetails savedcustomer = cr.save(cst);
		
		return savedcustomer;
	}
	
	@Override
	public Optional<CustomerDetails> finddById(Integer cstid) 
	{
		 Optional<CustomerDetails> data = cr.findById(cstid);
		  return data;
		
	}

}
