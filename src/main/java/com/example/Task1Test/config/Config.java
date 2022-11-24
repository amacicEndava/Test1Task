package com.example.Task1Test.config;

import com.example.Task1Test.model.EmailDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
public EmailDetails emailDetails(){
    return new EmailDetails();
}
}
