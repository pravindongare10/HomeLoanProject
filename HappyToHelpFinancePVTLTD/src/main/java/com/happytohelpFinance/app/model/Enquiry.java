package com.happytohelpFinance.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer enquiryId;
		private String customerFirstName;
		private String customerLastName;
	    private String pancardNumber;
	    private Long aadharNumber;
	    private long customerMobileNumber;
	    private String customerEmailId;
	   
		
		private String cibilStatus;
		private Integer cibilScore;
}