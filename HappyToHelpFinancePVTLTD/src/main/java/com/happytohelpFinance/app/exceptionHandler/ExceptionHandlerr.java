package com.happytohelpFinance.app.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.happytohelpFinance.app.exception.CustomerNotFound;
import com.happytohelpFinance.app.exception.EnquiryCanNotUpdateException;
import com.happytohelpFinance.app.exception.EnquiryNotFound;
import com.happytohelpFinance.app.response.ApiErrorResponse;



@RestControllerAdvice
public class ExceptionHandlerr {
	
	@ExceptionHandler(value = EnquiryNotFound.class)
	public ResponseEntity<ApiErrorResponse> handlerNotPresent(){
		ApiErrorResponse apir= new ApiErrorResponse(404,"Enquiry Not Found",new Date());
		return new ResponseEntity<ApiErrorResponse>(apir,HttpStatus.NOT_FOUND);
		
	}
	
	 @ExceptionHandler(value=EnquiryCanNotUpdateException.class)
		public ResponseEntity<ApiErrorResponse> enquiryCanNotUpdate(){
			ApiErrorResponse apir= new ApiErrorResponse(404,"Enquiry Not Update",new Date());
			return new ResponseEntity<ApiErrorResponse>(apir,HttpStatus.NOT_FOUND);		
		}
	    
	    @ExceptionHandler(value=CustomerNotFound.class)
		public ResponseEntity<ApiErrorResponse> customerNotFound(){
			ApiErrorResponse apir= new ApiErrorResponse(404,"Customer Not Found",new Date());
			return new ResponseEntity<ApiErrorResponse>(apir,HttpStatus.NOT_FOUND);		
		}
	    
	    @ExceptionHandler(value=com.happytohelpFinance.app.exception.PdfNotGenerated.class)
		public ResponseEntity<ApiErrorResponse> PdfNotGenerated(){
			ApiErrorResponse apir= new ApiErrorResponse(404,"Pdf Not Generated",new Date());
			return new ResponseEntity<ApiErrorResponse>(apir,HttpStatus.NOT_FOUND);		
		}

}
