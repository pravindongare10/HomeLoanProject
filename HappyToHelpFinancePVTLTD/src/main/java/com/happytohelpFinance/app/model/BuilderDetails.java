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
public class BuilderDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer builderDetailId;
	private String builderName;
	private String builderAddress;
	private long builderMobileNo;
	private long builderAccountNumber;
	private String bankIfscNumber;
    private String builderBankName;
       
       
       

}
