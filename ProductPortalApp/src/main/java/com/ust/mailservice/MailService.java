package com.ust.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
    private JavaMailSender javaMailSender;


	public void sendEmail(String toEmail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmail);

        msg.setSubject("Online Shoppy");
        msg.setText("Successfully Registerd with Online Shoppy|| mail from AKASH");

        javaMailSender.send(msg);
}
}
