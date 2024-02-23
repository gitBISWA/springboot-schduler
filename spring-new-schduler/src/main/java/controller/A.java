 /* import javax.mail.*;
  import javax.mail.internet.InternetAddress;
  import javax.mail.internet.MimeMessage;
  import java.util.Properties;

 @Service
 public class EmailService {

    public void sendEmail() {
        // Sender's email address
        String from = "your-email@example.com";
        // Recipient's email address
        String to = "recipient@example.com";
        // SMTP server hostname
        String host = "smtp.example.com";
        // SMTP server port
        int port = 587; // Change this to the appropriate port for your SMTP server
        // Email credentials (username and password)
        String username = "your-username";
        String password = "your-password";

        // Set properties for SMTP server
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Get the Session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);
            // Set From: header field of the header
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject("Test Email");
            // Set the actual message
            message.setText("This is a test email from your application.");

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

///   ////////////////////  //////   /////   /////  ///////   ///////
 
  

  1..> IF A PROCESS IS RUNNING ANOTHER SHOULD WAIT..(WE PROVIDE SLEEP TIME 2.5 HOURS)usi
  2..> Every 5 Hours it should send mail..(it should not send mail between 3pm to 12 am  )
  3>> fresh projects using spring boot and quartz....
  3>> We should have to write an api where we can restart the process or thread.. manually..(we wherever we want)
  
  
  
  
  
  
// ProcessController.java
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProcessService;

@RestController
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping("/start-process")
    public String startProcess() {
        processService.startAndWait();
        return "Process started!";
    }

    @PostMapping("/restart-process")
    public String restartProcess() {
        processService.restart();
        return "Process restarted!";
    }
}


     // ProcessService.java
package service;

import org.springframework.stereotype.Service;

@Service
public class ProcessService {

    private Thread processThread;

    public synchronized void startAndWait() {
        System.out.println("Starting Process...");
        // Start the process
        processThread = new Thread(() -> {
            try {
                // Simulate process execution
                Thread.sleep(2 * 60 * 1000); // Sleep for 2 minutes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Process completed.");
        });
        processThread.start();
        
        try {
            // Wait for the process to finish
            processThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void restart() {
        if (processThread != null) {
            // Interrupt the current process thread
            processThread.interrupt();
            // Start a new process thread
            startAndWait();
        } else {
            System.out.println("No process is currently running.");
        }
    }
}

  */
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 



