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
public class CustomerBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer bankDetailsId;
	 private String accountholderName;//AccountholderName
	  private String bankName;   
	  private long bankAcountNumber;
	  private String ifscCode;
	  
}
