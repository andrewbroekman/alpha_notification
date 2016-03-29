package com.codinginfinity.research.notification;
import java.util.Date;

/**
 * Implementation for the sendNotificationMessage module which is used to send an email to a user,
 * notifying them of modications and additions of publications, a report that has been generated, a reminder set by the user
 * or a broadcast notification sent by an authorised user
 *
 * @author	Amy Lochner
 * @author	Christiaan Nel
 * @since 	2016-03-29
 *
 *	29/03/2016 Amy Lochner - worked on functionality and structure
 * 	29/03/2016 Christiaan Nel - worked on functionality and structure
 *
 */
public class sendNotificationMessage
{
	/**
	*	An instance of the class which contains the functionality to send an email.
	*/
	private IEmailer emailer;
	/**
	 * Utilised when initialising an instance of the sendNotificationMessage class
	 *
	 * @param 	 emailer - an instance of the IEmailer class or its derived classes which provides this class
	 *						with the functionality needed to send an email.
	 * 
	 */
	public sendNotificationMessage(IEmailer emailer)
	{
		this.emailer = emailer;
	}
	/**
	 * Utilised when called through the interface to send a report to a user
	 *
	 * @param 	 report - the report object which contains the information to be sent to the respective user
	 * @param 	 recipient - the user to which the email must be sent
	 * @return   True if the email was sent successfully
	 * @exception ??
	 */
	public boolean sendReport(Report report, User recipient)
	{
		//Extract image here
		emailer.sendMail();
	}
	/**
	 * Utilised when called through the interface to send a broadcast notification
	 *
	 * @param 	 message - a custom message which is to be sent to various users
	 * @param 	 recipient - the user to which the email must be sent
	 * @return   True if the email was sent successfully
	 * @exception ??
	 */
	public boolean sendBroadcastNotification(String message, User recipient)
	{
		emailer.sendMail(recip, image)
	}
	/**
	 * Utilised when called through the interface to send a notification to make users aware of modifications/additions to a paper on which they are an author
	 *
	 * @param 	 publication - the publication object which was modified/added
	 * @param 	 recipient - the user to which the email must be sent 
	 * @return   True if the email was sent successfully
	 * @exception ??
	 */
	public boolean sendActivityNotification(Publication publication, User recipient )
	{
		emailer.sendMail();
	}
	/**
	 * Utilised when called through the interface to send a reminder to a user
	 *
	 * @param 	 recipient - the user who must receive the reminder
	 * @param 	 message - the message to be used to remind the user of a task
	 * @param 	 date - the date on which the reminder should be sent
	 * @return   True if the email was sent successfully
	 * @exception ??
	 */
	public boolean sendReminder(User recipient, String message, Date date)
	{
		//Send to a scheduler
		Scheduler scheduler = new Scheduler();
	}

}