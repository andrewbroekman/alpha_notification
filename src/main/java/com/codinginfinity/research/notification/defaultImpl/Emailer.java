package com.codinginfinity.research.notification.defaultImpl;

import javax.mail.*;
import javax.mail.internet.*;
import java.awt.*;
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
		sender = "mbhelethemba4@gmail.com";
		password = "mbhele11";
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
	public boolean sendMail(String recipient, String subject, String message)
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
			msg.setText(message);

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
	public boolean sendMail(String recipient, String subject, String message, Image image)
	{
		try
		{
			msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("smtp.gmail.com")); // @TODO add a host

			properties = System.getProperties();
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.starttls.required", "true");
			properties.put("mail.smtp.auth", "true");
			properties.setProperty("mail.smtp.host", "mail.testaplha301@gmail.com");


			InternetAddress address = new InternetAddress(recipient);
			msg.addRecipient(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			Multipart mp = new MimeMultipart();

			BodyPart bp = new MimeBodyPart();
			bp.setText(message);

//
//			bp = new MimeBodyPart();
//			DataSource source = new FileDataSource();
//			bp.setDataHandler(new DataHandler(source));
//			bp.setFileName();
//			mp.addBodyPart(bp);





			mp.addBodyPart(bp);
			msg.setContent(mp);
			Transport.send(msg);
		}
		catch (javax.mail.MessagingException e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}


	public boolean sendMail(ArrayList<String> recipient, String subject, String message)
	{
		try
		{
			msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
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
			msg.setSentDate(new Date());
			Multipart mp = new MimeMultipart();

			BodyPart bp = new MimeBodyPart();
			bp.setText(message);

			mp.addBodyPart(bp);
			msg.setContent(mp);
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