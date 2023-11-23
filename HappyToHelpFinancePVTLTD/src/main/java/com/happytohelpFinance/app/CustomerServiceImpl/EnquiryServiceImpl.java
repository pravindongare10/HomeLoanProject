package com.happytohelpFinance.app.CustomerServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytohelpFinance.app.CustomerServiceI.EnquiryServiceI;
import com.happytohelpFinance.app.Repository.EnquiryRepositery;
import com.happytohelpFinance.app.model.Enquiry;



@Service
public class EnquiryServiceImpl implements EnquiryServiceI {
	
	@Autowired
	EnquiryRepositery er;

	@Override
	public Enquiry saveEnquiry(Enquiry m) {
		
		System.out.println("Save Enquiry method start");
		System.out.println(m.getAadharNumber());
		System.out.println(m.getEnquiryId());
		System.out.println(m.getCibilStatus());
		System.out.println(m.getCustomerFirstName());
		System.out.println("Save Enquiry method end");

		Enquiry save = er.save(m);

		return save;
	}

	@Override
	public Iterable<Enquiry> getEnquiry(String cIBILStatus) {
		
		Iterable<Enquiry> get = er.findAllByCibilStatus(cIBILStatus);
		return get;
	}

	@Override
	public Optional<Enquiry> getSingleEnquiry(Integer enqid) {
		
		Optional<Enquiry> findById = er.findById(enqid);
		return findById;
	}

	@Override
	public Optional<Enquiry> findById(Integer enquiryId) {
		
		return er.findById(enquiryId);

	}
	
	

}
