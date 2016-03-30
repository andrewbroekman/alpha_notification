package com.codinginfinity.research.notification;

import java.awt.*;


/**
 * Service contract for the Emailer module which is used to send an email to a user.
 *
 * @author	Amy Lochner
 * @author	Christiaan Nel
 * @author 	Avinash Singh
 * @since 	2016-03-29
 *
 *	29/03/2016 Amy Lochner - worked on functionality and structure
 * 	29/03/2016 Christiaan Nel - worked on functionality and structure
 * 	30/03/2016 Avinash Singh - added Exceptions and modified Javadoc
 *
 */
public interface IEmailer
{
	/**
	 * Utilised when called in the Notifications interface to send a notification
	 *
	 * @param	recipient - the email address to which the email must be sent
	 * @param	subject - the subject line of the email
	 * @param	message - the body of the email
	 * @return	True if the email was sent successfully
	 * @exception	MessagingException if a message is invalid
	 * @exception	RecipientException if a recipient address is invalid
	 */
	public boolean sendMail(String recipient, String subject, String message) throws MessagingException, RecipientException;
	/**
	 * Utilised when called through the implementation of the Notifications interface to send a notification
	 *
	 * @param	recipient - the email address to which the email must be sent
	 * @param	subject - the subject line of the email
	 * @param	message - the body of the email
	 * @param	image - the image of the report to be sent to a user
	 * @return	True if the email was sent successfully
	 * @exception	MessagingException if a message is invalid
	 * @exception 	RecipientException if a recipient address is invalid
	 * @exception 	ImageException if a image is in an invalid format or if there is no image
	 */
	public boolean sendMail(String recipient, String subject, String message, Image image) throws MessagingException, RecipientException,ImageException;
	
}