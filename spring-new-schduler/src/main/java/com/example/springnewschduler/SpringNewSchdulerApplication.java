package com.example.springnewschduler;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.springnewschduler,controller,service"})

public class SpringNewSchdulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNewSchdulerApplication.class, args);
	}
	
	@Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587); // typically 587 for TLS
        mailSender.setUsername("biswa797813@gmail.com");
        mailSender.setPassword("stda rima aylm qdpo");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}


