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
public class LoanDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanDetails;
	private long expectedLoanAmount;
	private  Integer expectedLoanTenure;
	private long expectedEmiAmount;
	private String loanStatus; 
	private String loanDisbursedStatus;

	
}