package com.codinginfinity.research.notification;

/**
 * Service contract for the Notifications module which is used to send a variety of notifications
 * to users
 *
 * @author	Christiaan Nel
 * @autho	Amy Lochner
 * @author	Themba Mbhele
 * @author	Avinash Singh
 * @since 	2016-03-20
 *
 *	21/03/2016 Amy Lochner - clarified javadoc comments
 * 	29/03/2016 Avinash Singh - Added javadoc for new function
 *
 */
public interface INotification 
{
	
	/**
	 * Utilised by Users to send a Report to a to a specific User.
	 *
	 * @param 	Report object than contains the Report image to sent to the recipient
	 * @return 	boolean - True is successful, false otherwise
	 */
	public boolean sendReport(Report report);
	
	/**
	 * Utilised by Users to remove a Notification.
	 *
	 * @param 	
	 * @return 	boolean - True if removed successfully, false otherwise
	 */
	public boolean removeNotification();
	
	/**
	 * Utilised by Users to modify their Notifications.
	 *
	 * @param 	
	 * @return 	boolean - True if modified successfully, false otherwise
	 */
	public boolean modifyNotification();
	
	/**
	 * Utilised by Groups to send a Notification to other Users.
	 *
	 * @param 	
	 * @return 	boolean - True if sent successfully, false otherwise
	 */
	public boolean scheduleBroadNotification();
	
	/**
	 * Utilised by Users to schedule a Report Notification.
	 *
	 * @param 
	 * @return 	boolean - True if scheduled successfully, false otherwise
	 */
	public boolean scheduleReportNotification();
	
	/**
	 * Utilised by Users to  schedule a Reminder Notification for when a item is due.
	 *
	 * @param 	
	 * @return 	boolean - True if scheduled successfully, false otherwise
	 */
	public boolean scheduleReminderNotification();
	
	/**
	 * Utilised by Users to send a Notification when Activity occurs on a Publication.
	 *
	 * @param 	
	 * @return 	boolean - True if scheduled successfully, false otherwise
	 */
	/*does not make sense*/
	public boolean scheduleSendActivityNotification();
	
	/**
	 * Utilised to notify Users of any changes made to Publications for which they are authors on.
	 *
	 * @param 	publication the object needed to see what Activity has occured
	 * @param	recipient the object which needed to aquire E-mail address
	 * @return 	boolean - True if sent successfully, false otherwise
	 */	 
	public boolean sendActivityNotification(Publication publication, User recipient);
	
	/**
	 * Utilised to schedule general reminders for Users.
	 *
	 * @param 	recipient the object which needed to aquire E-mail address
	 * @param 	message the text of the Notification
	 * @return 	boolean - True if sent successfully, false otherwise
	 */
	public boolean sendReminder(User recipient, String message, Date date);
	
	/**
	 * Utilised by Group Leaders or Administrators to send scheduled broadcast messages.
	 *
	 * @param 	message the message to be broadcast
	 * @param 	recipient the user who should receive the notification
	 * @return 	boolean - True if sent successfully, false otherwise
	 */
	public boolean sendBroadcastNotification(String message, User recipient);
}
