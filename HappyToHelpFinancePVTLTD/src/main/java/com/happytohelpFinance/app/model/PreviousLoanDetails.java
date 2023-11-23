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
public class PreviousLoanDetails {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	 private Integer previousLoandetailsId;
	 private Double loanAmount;
	 private Long loanTenure;
	 private long paidAmount;
	 private long remainingAmount;
	 private String bankName;
}
