package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.IEmailer;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.awt.*;
import java.util.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Address;
import javax.mail.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.internet.*;
import javax.mail.Transport;
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
	*	The email address of the sender.
	*/
	private String sender;
	/**
	*	The properties of the environment.
	*/
	protected Properties properties;
	/**
	*	A mail session that provides access to the protocol providers that implement the Store, Transport, and related classes.
	*/
	protected Session session;

	protected Message msg;

	/**
	 * Utilised when initialising an instance of the Emailer class

	 */
	public Emailer()
	{

	} 
	/**
	 * Utilised when called through the implementation of the Notifications interface to send a notification
	 *
	 * @param 	 recipient - the email address to which the email must be sent
	 * @param 	 subject - the subject line of the email
	 * @param 	 message - the body of the email
	 * @return   True if the email was sent successfully
	 * @exception throws a MessagingException
	 */
	public boolean sendMail(String recipient, String subject, String message)
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

			Authenticator auth = new Authenticator()
			{
				@Override
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return super.getPasswordAuthentication("mail.testaplha301@gmail.com", "12345test");
				}
			};

			session = Session.getDefaultInstance(properties, auth);

			InternetAddress address = new InternetAddress(recipient);
			msg.addRecipient(Message.RecipientType.TO, address);
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
		}
	}
	/**
	 * Utilised when called through the implementation of the Notifications interface to send a notification
	 *
	 * @param 	 recipient - the email address to which the email must be sent
	 * @param 	 subject - the subject line of the email
	 * @param 	 message - the body of the email
	 * @param 	 image - the image of the report to be sent to a user
	 * @return   True if the email was sent successfully
	 * @exception throws a MessagingException
	 */
	public boolean sendMail(String recipient, String subject, String message,  Image image) throws MessagingException
	{
		try
		{

			MimeMessage email = new MimeMessage(session);
			email.setFrom(new InternetAddress(sender));
			email.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			email.setSubject(subject);

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(message);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			//Add the attachment
			if(image != null)
			{
				messageBodyPart = new MimeBodyPart();
				//Incomplete
			}
			email.setContent(multipart);
			Transport.send(email);
		}
		catch (AddressException ae)
		{
			ae.printStackTrace();
			return false;
		}

		catch (javax.mail.MessagingException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean sendMail(ArrayList<String> recipient, String subject, String message) throws MessagingException
	{
		try
		{

			MimeMessage email = new MimeMessage(session);
			email.setFrom(new InternetAddress(sender));
			for (int i = 0; i < recipient.size(); ++i)
			{
				String s = recipient.get(i);

				if (!s.equals(""))
					email.addRecipient(Message.RecipientType.TO, new InternetAddress(s));
			}

			email.setSubject(subject);

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(message);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			email.setContent(multipart);
			Transport.send(email);
		}

		catch (AddressException e)
		{
			e.printStackTrace();
			return false;
		}

		catch (javax.mail.MessagingException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}