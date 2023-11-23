package com.happytohelpFinance.app.Controller;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happytohelpFinance.app.CustomerServiceI.EnquiryServiceI;
import com.happytohelpFinance.app.enums.CibilStatus;
import com.happytohelpFinance.app.exception.EnquiryNotFound;
import com.happytohelpFinance.app.model.Enquiry;
import com.happytohelpFinance.app.response.BaseResponse;


@CrossOrigin("*")
@RestController
@RequestMapping("/Enquiry")
public class EnquiryController {
	@Autowired
	EnquiryServiceI es;
	
	//http://localhost:9091/saveEnquiry
	@PostMapping("/saveEnquiry")
	public ResponseEntity<BaseResponse<Enquiry>> postEnquiry(@RequestBody Enquiry m){
		
		m.setCibilStatus(String.valueOf(CibilStatus.pending));
		
		Enquiry enquiry= es.saveEnquiry(m);
		BaseResponse bs=new BaseResponse<>(201,"Data saved",enquiry);
		
		return new ResponseEntity<BaseResponse<Enquiry>>(bs,HttpStatus.OK);
		

	}
	
	@GetMapping("/getEnquiry/{CIBILStatus}") 
	public ResponseEntity<BaseResponse<Iterable<Enquiry>>> getEnquiry(@PathVariable("CIBILStatus") String CIBILStatus)
	{
		Enquiry eq=null;
		
		 Iterable<Enquiry> enq = es.getEnquiry(CIBILStatus);
		 for(Enquiry enq1:enq) {
			 if(enq1 !=null) {
				 eq=enq1;
			 }
		 }
		 if(eq !=null) {
		 BaseResponse<Iterable<Enquiry>> ba= new BaseResponse<>(200,"All data Ok",enq);
		 return new ResponseEntity<BaseResponse<Iterable<Enquiry>>>(ba,HttpStatus.OK) ;
		 }else {
		 throw new EnquiryNotFound();
		 }	
		 
	}
	
	@GetMapping("/getsingleenquiry/{enqid}")
	public ResponseEntity<BaseResponse<Enquiry>> getSingleEnquiry(@PathVariable Integer enqid){
		Optional<Enquiry> singleEnquiry = es.getSingleEnquiry(enqid);
		if(singleEnquiry.isPresent()) {
			BaseResponse ba= new BaseResponse<>(200,"All data Ok",singleEnquiry);
			return new ResponseEntity<BaseResponse<Enquiry>>(ba,HttpStatus.OK);
			
		}else {
			throw new EnquiryNotFound();
		}
	}
	
	@PutMapping("/CheckCIBIL/{enquiryId}")
	public ResponseEntity<BaseResponse<Enquiry>> checkCibilScore(@PathVariable("enquiryId") Integer enquiryId,@RequestBody Enquiry enq)
	{
		Random ramdom=new Random();
		int cibilScore = ramdom.nextInt(300, 900);
		
		if(cibilScore>=600 && cibilScore<=900) 
		{
			enq.setCibilStatus(String.valueOf(CibilStatus.approved));
			enq.setCibilScore(cibilScore);
		
		    Enquiry enquiry = es.saveEnquiry(enq);

		    BaseResponse<Enquiry> baseResponse = new BaseResponse<Enquiry>(200,"CIBIL Approved",enquiry);
			return new ResponseEntity<BaseResponse<Enquiry>>(baseResponse,HttpStatus.OK);
		}
		else
		{
			enq.setCibilStatus(String.valueOf(CibilStatus.rejected));
			enq.setCibilScore(cibilScore);
			
			Enquiry enquiry = es.saveEnquiry(enq);
			
	        BaseResponse<Enquiry> baseResponse = new BaseResponse<Enquiry>(200,"CIBIL Rejected",enquiry);
			return new ResponseEntity<BaseResponse<Enquiry>>(baseResponse,HttpStatus.OK);
		}
		
	

}
	
}

