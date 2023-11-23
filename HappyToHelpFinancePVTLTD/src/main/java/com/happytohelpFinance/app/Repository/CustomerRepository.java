package com.happytohelpFinance.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happytohelpFinance.app.model.CustomerDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer>{

	public Iterable<CustomerDetails> findAllByCustomerLoanStatus(String custloanstatus);

//	public CustomerDetails findByCustomerId(Integer custid);

	
}
