package com.codinginfinity.research.notification;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Implementation of the IEmailer module which is used to send an email to a user.
 * Makes use of JavaMail API
 *
 * @author	Amy Lochner
 * @author	Christiaan Nel
 * @since 	2016-03-29
 *
 *	29/03/2016 Amy Lochner - worked on functionality and structure
 * 	29/03/2016 Christiaan Nel - worked on functionality and structure
 *
 */
public class Emailer implements IEmailer
{
	/**
	*	The email address of the sender.
	*/
	private static final String sender;
	/**
	*	The properties of the environment.
	*/
	private static final Properties properties;
	/**
	*	A mail session that provides access to the protocol providers that implement the Store, Transport, and related classes.
	*/
	private static final Session session;

	/**
	 * Utilised when initialising an instance of the Emailer class
	 *
	 * @param 	 sender - the email address from which the email must be sent
	 * @param 	 host - the host on which the program runs    ----------->unsure
	 * @param 	 mailServer - the server from which the mail is sent
	 * 
	 */
	public Emailer(String sender ,String host, String mailServer)
	{
		this.sender = sender;
		this.properties = System.getProperties();
		properties.setProperty(mailServer,host);
		this.session = Session.getDefaultInstance(properties);
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
			sendMail(recipient,subject,message,null);
		}
		catch(MessagingException exception)
		{
			exception.printStackTrace();
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
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject(subject);

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
			message.setContent(multipart);
			Transport.send(message);
		}
		catch(MessagingException exception)
		{
			exception.printStackTrace();
		}
	}
}