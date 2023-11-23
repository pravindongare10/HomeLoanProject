package com.happytohelpFinance.app.CustomerServiceI;

import java.util.Optional;

import com.happytohelpFinance.app.model.Enquiry;



public interface EnquiryServiceI {

	Enquiry saveEnquiry(Enquiry m);

	Iterable<Enquiry> getEnquiry(String cIBILStatus);

	Optional<Enquiry> getSingleEnquiry(Integer enqid);
	
	public Optional<Enquiry> findById(Integer enquiryId);

}
