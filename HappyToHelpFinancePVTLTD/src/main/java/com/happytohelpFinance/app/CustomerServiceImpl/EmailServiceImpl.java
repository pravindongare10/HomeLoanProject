package com.happytohelpFinance.app.CustomerServiceImpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.happytohelpFinance.app.CustomerServiceI.EmailService;
import com.happytohelpFinance.app.model.CustomerDetails;
import com.happytohelpFinance.app.model.Email;
import com.happytohelpFinance.app.model.SanctionLetter;


@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender sender;
	
	@Override
	public void sendMail(Email e) 
	{
	try {
		SimpleMailMessage message=new SimpleMailMessage();
		      message.setTo(e.getToEmail());
		      message.setFrom(e.getFromEmail());
		      message.setSubject(e.getSubject());
		      message.setText(e.getText());
		      
		      sender.send(message);
	} catch (MailException e1) {
		System.out.println("Email Failed to send");
		e1.printStackTrace();
	}		
	}

	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Override
	public SanctionLetter sendSantionLetterMail(CustomerDetails customerDetails) 
	{
		MimeMessage mimemessage = sender.createMimeMessage();
		
		byte[] sanctionLetter = customerDetails.getCustomerSanctionLetter().getSanctionLetter();

		try {
			MimeMessageHelper mimemessageHelper = new MimeMessageHelper(mimemessage, true);
			mimemessageHelper.setFrom(fromEmail);
			mimemessageHelper.setTo(customerDetails.getCustomerEmailId());
			mimemessageHelper.setSubject("HappyToHelp Finance Ltd. Sanction Letter");
			String text = "Dear " + customerDetails.getCustomerLastName() + customerDetails.getCustomerFirstName() + customerDetails.getCustomerMiddleName()
					+ ",\n" + "\n"
					+ "This letter is to inform you that we have reviewed your request for a credit loan . We are pleased to offer you a credit loan of "
					+ customerDetails.getCustomerSanctionLetter().getLoanAmountSanctioned() + " for "
					+ customerDetails.getCustomerSanctionLetter().getLoanTenure() + ".\n" + "\n"
					+ "We are confident that you will manage your credit loan responsibly, and we look forward to your continued business.\n"
					+ "\n"
					+ "Should you have any questions about your credit loan, please do not hesitate to contact us.\n"
					+ "\n" + "Thank you for your interest in our services.";

			mimemessageHelper.setText(text);

			mimemessageHelper.addAttachment("loanSanctionLetter.pdf", new ByteArrayResource(sanctionLetter));
			sender.send(mimemessage);

		} catch (Exception e) {
			System.out.println("Email Failed to Send!!!!!!");
			e.printStackTrace();
		}

		
		return null;
	}

	
} 
