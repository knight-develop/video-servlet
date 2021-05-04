package com.webvideo.utils;import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static void send(String to, String subject, String msg) {
		final String user = "anhkhai1222@gmail.com";
		final String pass = "anhkhai123456";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(user));
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject(subject, "utf-8");
			message.setText(msg, "utf-8","html");
			message.setReplyTo(message.getFrom());
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
