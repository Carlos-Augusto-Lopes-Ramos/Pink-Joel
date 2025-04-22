package com.main.medula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;


    public void sendEmail(String to, String subject, String body) {
        // Implementation for sending email
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("Sending email to: " + to);
        message.setTo(to);
        System.out.println("Subject: " + subject);
        message.setSubject(subject);
        System.out.println("Body: " + body);
        message.setText(body);
        emailSender.send(message);
    }

}
