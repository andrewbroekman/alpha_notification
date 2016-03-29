package com.codinginfinity.research.notification;

/**
 * Implementation of the service contract for the Emailing module which is used to send an email to a user.
 *
 * @author	Amy Lochner
 * @author	Christiaan Nel
 * @since 	2016-03-29
 *
 *	29/03/2016 Amy Lochner - worked on functionality and structure
 * 	29/03/2016 Christiaan Nel - worked on functionality and structure
 *
 *		!---Note---! This class is still causing a lot of confusion
 */
public class EmailerMock implements IEmailer
{
	public EmailerMock(String sender ,String host, String mailServer)
	{
		
	}
	public boolean sendMail(String recipient, String subject, String message)
	{

	}
	public boolean sendMail(String recipient, String subject, String message,  Image image)
	{

	}
}