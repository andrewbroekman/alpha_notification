package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.IEmailer;
import com.codinginfinity.research.notification.exceptions.ImageException;
import com.codinginfinity.research.notification.exceptions.RecipientException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

/**
 * Implementation of the IEmailer module which is used to send an email to a user.
 * Makes use of JavaMail API
 *
 * @author	COS301 - Alpha Notifications
 */

public class Emailer implements IEmailer
{
	/**
	 * The email address of the sender.
	 */
	private String sender;
	/**
	 * The password of the sender.
	 */
	protected String password;
	/**
	 * The properties of the environment.
	 */

	protected Properties properties;
	/**
	 * A mail session that provides access to the protocol providers that implement the Store, Transport, and related classes.
	 */
	protected Session session;
	/**
	 * The server that hosts the sender address
	 */
	protected String host;

	protected Message msg;

	public Emailer()
	{
		sender = "cs.mail.alpha@gmail.com";
		password = "12345test";
		host = "smtp.gmail.com";
		properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "true");
		properties.put("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.host", host);

		session = Session.getDefaultInstance(properties,
				new javax.mail.Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								sender, password);// Specify the Username and the PassWord
					}
				});

	}


	/**
	 * Utilised when called through the implementation of the Notifications interface to send a notification
	 *
	 * @param recipient - the email address to which the email must be sent
	 * @param subject   - the subject line of the email
	 * @param message   - the body of the email
	 * @return True if the email was sent successfully
	 * @throws throws a MessagingException
	 */
	public boolean sendMail(String name, String recipient, String subject, String message)
	{
		try{
			// Create a default MimeMessage object.
			MimeMessage msg = new MimeMessage(session);

			// Set From: header field of the header.
			msg.setFrom(new InternetAddress(sender));

			// Set To: header field of the header.
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			// Set Subject: header field
			msg.setSubject(subject);

			// Now set the actual message
			//msg.setText(message);

			//create the html email
			String part1 = "<div dir=\"ltr\"><div style=\"text-align:center\"><img src=\"http://www.up.ac.za/themes/up/img/up-logo.jpg\"><br><img src=\"http://www.cs.up.ac.za/static/images/headerCS.gif\" class=\"\" align=\"middle\"><br><h1><font size=\"2\">";

			String greeting = "Hi "+name;

			String part2 = "</font></h1><p class=\"\"><font size=\"4\"><b>";

			String heading = subject;

			String part3 = "</b></font></p><p>";

			String messageContents = message;

			String part4 = "</p><br><h5><font size=\"1\">Contact us:</font></h5><font size=\"1\"></font><center><font size=\"1\"><a href=\"http://cs.up.ac.za\" align=\"center\" class=\"\">CS website</a><br></font><p><font size=\"1\"><a href=\"http://cs.up.ac.za/contact\">Email Enquiries</a></font></p><font size=\"1\">Phone: +27 12 420 2504</font></center></div></div>";
			// Now set the actual message
			String finalMessage = part1+greeting+part2+heading+part3+messageContents+part4;
			msg.setContent(finalMessage, "text/html");

			// Send message
			Transport.send(msg);

		}
		catch (AddressException e)
		{
			return false;
		}
		catch (javax.mail.MessagingException e)
		{
			return false;
		}
		catch (Exception errr)
		{
			System.out.println(errr.getMessage());
		}
		return true;
	}

	/**
	 * Utilised when called through the implementation of the Notifications interface to send a notification
	 *
	 * @param recipient - the email address to which the email must be sent
	 * @param subject   - the subject line of the email
	 * @param message   - the body of the email
	 * @param image     - the image of the report to be sent to a user
	 * @return True if the email was sent successfully
	 * @throws throws a MessagingException
	 */
	public boolean sendMail(String name, String recipient, String subject, String message, Image image)
	{
//		try
//		{
//
//			InternetAddress address = new InternetAddress(recipient);
//			msg.addRecipient(Message.RecipientType.TO, address);
//			msg.setSubject(subject);
//			msg.setSentDate(new Date());
//			Multipart mp = new MimeMultipart();
//
//			BodyPart bp = new MimeBodyPart();
//			bp.setText(message);
//
////
////			bp = new MimeBodyPart();
////			DataSource source = new FileDataSource();
////			bp.setDataHandler(new DataHandler(source));
////			bp.setFileName();
////			mp.addBodyPart(bp);
//
//
//
//
//
//			mp.addBodyPart(bp);
//			msg.setContent(mp);
//			Transport.send(msg);
//		}
//		catch (javax.mail.MessagingException e)
//		{
//			e.printStackTrace();
//			return false;
//		}

		return true;
	}

	public boolean sendMail(String name, String recipient, String subject, String message, String imagePath) throws MessagingException, RecipientException, ImageException
	{
		try{
// Create a default MimeMessage object.
			MimeMessage msg = new MimeMessage(session);

			// Set From: header field of the header.
			msg.setFrom(new InternetAddress(sender));

			// Set To: header field of the header.
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			// Set Subject: header field
			msg.setSubject(subject);

			// Now set the actual message
			//msg.setText(message);

			//create the html email
			String part1 = "<div dir=\"ltr\"><div style=\"text-align:center\"><img src=\"http://www.up.ac.za/themes/up/img/up-logo.jpg\"><br><img src=\"http://www.cs.up.ac.za/static/images/headerCS.gif\" class=\"\" align=\"middle\"><br><h1><font size=\"2\">";

			String greeting = "Hi "+name;

			String part2 = "</font></h1><p class=\"\"><font size=\"4\"><b>";

			String heading = subject;

			String part3 = "</b></font></p><p>";

			String messageContents = message;

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			BodyPart messageBodyPart = new MimeBodyPart();

			String part4 = "</p><br><h5><font size=\"1\">Contact us:</font></h5><font size=\"1\"></font><center><font size=\"1\"><a href=\"http://cs.up.ac.za\" align=\"center\" class=\"\">CS website</a><br></font><p><font size=\"1\"><a href=\"http://cs.up.ac.za/contact\">Email Enquiries</a></font></p><font size=\"1\">Phone: +27 12 420 2504</font></center></div></div>";
			// Now set the actual message
			String finalMessage = part1+greeting+part2+heading+part3+messageContents+part4;
			messageBodyPart.setContent(finalMessage, "text/html");

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = imagePath;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			msg.setContent(multipart);

			// Send message
			Transport.send(msg);
			//source.getOutputStream().close();

			System.out.println("Sent message successfully....");
		}
		catch (MessagingException mex)
		{
			mex.printStackTrace();
		}
		return true;
	}


	public boolean sendMail(ArrayList<String> recipient, String subject, String message)
	{
		try
		{
			msg = new MimeMessage(session);
//			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//			msg.addHeader("format", "flowed");
//			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("smtp.gmail.com")); // @TODO add a host

			for (int i = 0; i < recipient.size(); ++i)
			{
				String r = recipient.get(i);

				if (!r.equals(""))
				{
					InternetAddress address = new InternetAddress(r);
					msg.addRecipient(Message.RecipientType.TO, address);
				}
			}

			msg.setSubject(subject);
//			msg.setSentDate(new Date());
//			Multipart mp = new MimeMultipart();
//
//			BodyPart bp = new MimeBodyPart();
//			bp.setText(message);

			//mp.addBodyPart(bp);
			String part1 = "<div dir=\"ltr\"><div style=\"text-align:center\"><img src=\"http://www.up.ac.za/themes/up/img/up-logo.jpg\"><br><img src=\"http://www.cs.up.ac.za/static/images/headerCS.gif\" class=\"\" align=\"middle\"><br><h1><font size=\"2\">";

			String greeting = "Hi ";

			String part2 = "</font></h1><p class=\"\"><font size=\"4\"><b>";

			String heading = subject;

			String part3 = "</b></font></p><p>";

			String messageContents = message;

			String part4 = "</p><br><h5><font size=\"1\">Contact us:</font></h5><font size=\"1\"></font><center><font size=\"1\"><a href=\"http://cs.up.ac.za\" align=\"center\" class=\"\">CS website</a><br></font><p><font size=\"1\"><a href=\"http://cs.up.ac.za/contact\">Email Enquiries</a></font></p><font size=\"1\">Phone: +27 12 420 2504</font></center></div></div>";
			// Now set the actual message
			String finalMessage = part1+greeting+part2+heading+part3+messageContents+part4;
			msg.setContent(finalMessage, "text/html");
			Transport.send(msg);
		}

		catch (javax.mail.MessagingException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}