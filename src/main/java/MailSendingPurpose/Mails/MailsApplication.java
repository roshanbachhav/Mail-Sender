package MailSendingPurpose.Mails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Scanner;

@SpringBootApplication
public class MailsApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(MailsApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email address here");
		String email = sc.next();
		System.out.println("Enter Subject");
		String subject = sc.next();
		System.out.println("Enter Your things");
		String body = sc.next();
		emailSenderService.sendMail(email , subject , body);
	}
}
