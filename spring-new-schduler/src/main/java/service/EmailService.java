package service;

//EmailService.java


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

 @Autowired
 private JavaMailSender emailSender;

 public void sendEmail() {
     SimpleMailMessage message = new SimpleMailMessage();
     message.setTo("sn22779@gmail.com");
     message.setSubject("kagami Don Surya");
     message.setText("Hello ,,... Booss");

     emailSender.send(message);
 }
}
