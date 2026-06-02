package com.product.lms.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	 @Autowired
	    private JavaMailSender mailSender;
	 public void sendPasswordMail(String toEmail, String newPassword) {

	        SimpleMailMessage message = new SimpleMailMessage();

	        message.setTo(toEmail);
	        message.setSubject("Your New Password");

	        message.setText(
	                "Hello User,\n\n" +
	                "Your password has been reset successfully.\n\n" +
	                "New Password: " + newPassword +
	                "\n\nRegards,\nAdmin");

	        message.setFrom("94saleem@gmail.com");

	        mailSender.send(message);
	    }
	
	

}
