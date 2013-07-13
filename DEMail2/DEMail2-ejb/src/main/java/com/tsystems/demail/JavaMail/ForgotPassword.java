package com.tsystems.demail.JavaMail;

import com.tsystems.demail.Constants.JMailData;
import java.security.Policy;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class ForgotPassword {

    public String sendPass(String phone, String pass, String mail) {

        JMailData data = new JMailData();

        //admin data
        final String username = data.ADMINNAME;
        final String password = data.ADMINPASS;

        Properties props = new Properties();
        props.put(data.AUTH, data.ANS);
        props.put(data.TLS, data.ANS);
        props.put(data.HOSTPARAM, data.SMTPHOST);
        props.put(data.PORTPARAM, data.SMTPPORT);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(data.ADMINNAME));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mail));
            message.setSubject(data.SUBJECT);
            message.setText("Your phone: " + phone + "\nYour password: " + password);

            Transport.send(message);
            return "Done";
        } catch (MessagingException ex) {
            return "Error";
        }

    }
}
