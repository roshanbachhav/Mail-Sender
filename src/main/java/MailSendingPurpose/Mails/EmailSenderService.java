package MailSendingPurpose.Mails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender jms;

    public void sendMail(String toEmail , String subject , String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bachhavroshan600@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        jms.send(message);
        System.out.println("Message send");
    }
}
