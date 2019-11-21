package com.ap.learnspringboot.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ap.learnspringboot.flightreservation.services.ReservationServiceImpl;

@Component
public class EmailUtil {
	
	@Value("${com.ap.learnspringboot.flightreservation.itinerary.email.body}")
	private String EMAIL_BODY;

	@Value("${com.ap.learnspringboot.flightreservation.itinerary.email.subject}")
	private String EMAIL_SUBJECT;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	@Autowired
	private JavaMailSender sender; 
	

	public void sendItineraryEmail(String toAddress, String filePath) {
		
		LOGGER.info("Inside sendItineraryEmail");
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toAddress);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_BODY);
			helper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
//			e.printStackTrace();
			LOGGER.error("Exception inside sendItineraryEmail " + e);
		}
		
		
	}

}
