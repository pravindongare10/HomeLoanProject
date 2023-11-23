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
public class GuarantorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer guarantorDetailsId;
	private String gurantorName;
	private String guarantorAddress;
	private long mobileNumber;
	private String designation;
}


