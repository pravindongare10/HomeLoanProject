package com.happytohelpFinance.app.CustomerServiceI;

import com.happytohelpFinance.app.model.CustomerDetails;
import com.happytohelpFinance.app.model.Email;
import com.happytohelpFinance.app.model.SanctionLetter;

public interface EmailService
{
  public void sendMail(Email e);

  public SanctionLetter sendSantionLetterMail(CustomerDetails customerDetails);
}
