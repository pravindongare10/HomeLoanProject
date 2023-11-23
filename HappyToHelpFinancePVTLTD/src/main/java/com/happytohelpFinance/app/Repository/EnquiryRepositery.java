package com.happytohelpFinance.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happytohelpFinance.app.model.Enquiry;


@Repository
public interface EnquiryRepositery extends JpaRepository<Enquiry, Integer> {
	
	   public Iterable<Enquiry> findAllByCibilStatus(String cibilStatus);	


}
