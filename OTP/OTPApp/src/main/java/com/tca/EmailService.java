package com.tca;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {
    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "587";
    private static final String SENDER_EMAIL = "senderEmail@gmail.com"; //211
    private static final String PASSWORD = "qmxh xhus mixo vkra"; //your app password

    public void sendEmail(String recipient, String subject, String body) throws MessagingException{
        // Configure properties for javamail
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);


        //Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER_EMAIL, PASSWORD);
            }
        });


        //Compose the mail
        Message message = new MimeMessage(session);
        message.setFrom( new InternetAddress(SENDER_EMAIL));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject(subject);
        message.setText(body);

        //Send the email
        Transport.send(message);
    }
}
