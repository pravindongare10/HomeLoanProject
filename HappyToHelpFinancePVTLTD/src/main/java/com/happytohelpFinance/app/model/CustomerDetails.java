package com.happytohelpFinance.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Component
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String customerFirstName;
	private String customerMiddleName;
	private String customerLastName;
	private long mobileNumber;
	private String CustomerEmailId;
	private String panCardNumber;
	private long aadharNumber;
	private String customerDateOfBirth;
	private String customerGender;
	private String qualification;
	private Integer customerCibilScore;
	private String customerLoanStatus;//customerLoanStatus
	private Double loanAmountRequired;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private CustomerDocuments customerdocuments;

	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDocuments customerAllDocuments;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerProfession customerProfession;
	
	//builderDetails:BuilderDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BuilderDetails builderDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetails customerBankDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement customerLoanDisbursement;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ledger customerLedger;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertyDetails;
	//   customerSanctionLetter:SanctionLetter;
	@OneToOne(cascade = CascadeType.ALL)
    private SanctionLetter  customerSanctionLetter;
	// guarantorDetails:GuarantorDetails;
	@OneToOne(cascade = CascadeType.ALL)
    private GuarantorDetails guarantorDetails;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//    private LoanDetails loandetails;
//	
	//previousLoanDetails:PreviousLoanDetails;
	@OneToOne(cascade = CascadeType.ALL)
    private PreviousLoanDetails previousLoanDetails;
	
}
