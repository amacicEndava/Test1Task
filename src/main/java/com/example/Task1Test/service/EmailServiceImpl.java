package com.example.Task1Test.service;

// Importing required classes
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.example.Task1Test.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService{

    @Autowired private JavaMailSender javaMailSender;

    //@Value("${spring.mail.username}") private String sender;


    public String sendSimpleMail(EmailDetails details)
    {


        try {


            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();


            mailMessage.setFrom("andrej.macic121@gmail.com");
            mailMessage.setTo("andrej.macic121@gmail.com");
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());


            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }


}