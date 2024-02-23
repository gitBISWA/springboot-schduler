package service;

//EmailScheduler.java


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class EmailScheduler {

 @Autowired
 private EmailService emailService;

 //@Scheduled(cron = "0 0/5 * * * *") // Every 5 hours
 @Scheduled(cron = "0 */2 * * * *") // Every 2 minutes
 public void sendEmailEvery5Hours() {
    LocalTime currentTime = LocalTime.now();
     /*if (currentTime.isAfter(LocalTime.parse("03:00")) && currentTime.isBefore(LocalTime.parse("12:00"))) {
       //  Do not send email between 3 pm and 12 am
     return;
   }*/
   emailService.sendEmail();
} 
}






