package com.rdec.services;


import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class OTPService {
	public static boolean sendRegisterOTP(String to, String userName, int OTP) {
		String sender = "";
		String senderPassword = "";
		
		Properties emailProperties = new Properties();
		emailProperties.put("mail.smtp.host", "smtp.gmail.com");
		emailProperties.put("mail.smtp.port", "587");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, senderPassword);
			}
		};
		
		Session emailSession = Session.getInstance(emailProperties, auth);
		
		Message emailMsg = new MimeMessage(emailSession);
		try {
			emailMsg.setFrom(new InternetAddress(sender));
			emailMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			emailMsg.setSubject("Welcome Onboard!");
			emailMsg.setText("Hey, " + userName + "\n \n"
							+ "Your account has been created successfully \n\n"
							+"Your OTP (One Time Password) is :" + OTP
							+"Best Regards, \n"
							+"Team Sec-C"
							);
			Transport.send(emailMsg);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
