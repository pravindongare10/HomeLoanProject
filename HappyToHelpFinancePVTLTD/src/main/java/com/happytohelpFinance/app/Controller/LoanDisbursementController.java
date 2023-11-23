package com.happytohelpFinance.app.Controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.happytohelpFinance.app.CustomerServiceI.LoanDisbursementService;
import com.happytohelpFinance.app.enums.CustomerLoanStatus;
import com.happytohelpFinance.app.exception.CustomerNotFound;
import com.happytohelpFinance.app.model.CustomerDetails;
import com.happytohelpFinance.app.model.LoanDisbursement;
import com.happytohelpFinance.app.response.BaseResponse;
@CrossOrigin("*")
@RestController
@RequestMapping("/LoanDisbursement")
public class LoanDisbursementController {
	@Autowired
	LoanDisbursementService ls;
	
	@PutMapping("/loanDisbursementupdate/{customerId}")
	public ResponseEntity<BaseResponse<CustomerDetails>> updateLoan(@RequestBody LoanDisbursement loandisbursement,@PathVariable("customerId") Integer customerId) throws IOException
	{ 
		Optional<CustomerDetails> customer = ls.finddById(customerId);
		CustomerDetails customerdata = customer.get();
		if(customer.isEmpty()) {			
			throw new CustomerNotFound();
		}else {		
			customerdata.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.LoanDisbursed));
			customerdata.getCustomerLoanDisbursement().setAmountPaidDate(loandisbursement.getAmountPaidDate());
			customerdata.getCustomerLoanDisbursement().setTotalLoanSanctionedAmount(loandisbursement.getTotalLoanSanctionedAmount());
			customerdata.getCustomerLoanDisbursement().setTransferedAmount(loandisbursement.getTransferedAmount());
			customerdata.getCustomerLoanDisbursement().setPaymentStatus(loandisbursement.getPaymentStatus());
			
			customerdata.getCustomerLoanDisbursement().setBuilderBankAccountNumber(loandisbursement.getBuilderBankAccountNumber());
			customerdata.getCustomerLoanDisbursement().setBuilderBankIfscNumber(loandisbursement.getBuilderBankIfscNumber());
			
			CustomerDetails customerdetails=ls.updateloanDisbursement(customerdata);
			BaseResponse br= new BaseResponse<>(200,"Loan Disbursed successfully !!!!",customerdetails);
			return new ResponseEntity<BaseResponse<CustomerDetails>>(br,HttpStatus.OK);
		}		
	}
}
