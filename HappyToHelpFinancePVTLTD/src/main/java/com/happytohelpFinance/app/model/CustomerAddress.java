package com.happytohelpFinance.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;// customerAddressId;
	private String areaName;
	private String cityName;
	private String district;
	private String state;
	private Long pincode;

	

}
