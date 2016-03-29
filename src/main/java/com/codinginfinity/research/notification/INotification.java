package com.codinginfinity.research.notification;

/**
 * Service contract for the Notifications module which is used to send a variety of notifications
 * to users
 *
 * @author 	Christiaan Nel
 * @author  Amy Lochner
 * @author Themba Mbhele
 * @author Avinash Singh
 * @since 	2016-03-20
 *
 *	21/03/2016 Amy Lochner - clarified javadoc comments
 *
 */
public interface INotification 
{
	
	/**
	 * Utilised by users to send a publications report to a group automatically.
	 *
	 * @param 	reportNotificationRequest Wrapper request object
	 * @return 	Wrapper response object
	 */
	public boolean sendReport(Report report);
	public boolean removeNotification();
	public boolean modifyNotification();
	public boolean scheduleBroadNotification();
	public boolean scheduleReportNotification();
	public boolean scheduleReminderNotification();
	/*does not make sense*/
	public boolean scheduleSendActivityNotification();
	
	/**
	 * Utilised to notify users of any changes made to publications for which they are authors on.
	 *
	 * @param 	activitiesNotificationsRequest Wrapper request object
	 * @return 	Wrapper response object
	 */	 
	public boolean sendActivityNotification(Publication publication, User recipient);
	
	/**
	 * Utilised to schedule general reminders for users.
	 *
	 * @param 	reminderRequest Wrapper request object
	 * @return 	Wrapper response object
	 */
	public boolean sendReminder(User recipient, String message, Date date);
	
	/**
	 * Utilised by group leaders or administrators to send scheduled broadcast messages.
	 *
	 * @param 	broadNotificationRequest Wrapper request object
	 * @return 	Wrapper response object
	 */
	public boolean sendBroadNotification();
}