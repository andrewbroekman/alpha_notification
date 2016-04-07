package com.codinginfinity.research.notification;

/**
 * @TODO clarify the interface as well as a descriptive javaDoc comments
 */

/**
 * Service contract for the Notifications module which is used to send a variety of notifications
 * to users
 *
 *
 * @author	Christiaan Nel
 * @author 	Amy Lochner
 * @author	Themba Mbhele
 * @author	Avinash Singh
 * @since 	2016-03-20
 * @version 3.0 Notifications
 *
 *	21/03/2016 Amy Lochner - clarified javadoc comments
 * 	29/03/2016 Avinash Singh - Added javadoc for new function
 * 	07/04/2016 Avinash Singh - created the new interface with requests and responses
 *
 */
public interface INotification 
{
	/**
	 * This function sends an activity based on a change in any Publication
	 * @param request this is a wrapped object of type NotificationRequest, upon a function call a ActivitiesNotificationRequest object must be created.
	 * @return NotificationResponse a wrapped object for Responses, upon a function call it will create a ActivitiesResponse object with a success or failure.
     */
	public NotificationResponse ActivitiesNotification(NotificationRequest request);

	/**
	 * This function sends a report based notification which is scheduled by a User
	 * @param request this is a wrapped object of type NotificationRequest, upon a function call a ReportNotificationRequest object must be created.
	 * @return NotificationResponse a wrapped object for Responses, upon a function call it will create a ReportNotificationResponse object with a success or failure.
     */
	public NotificationResponse ReportNotification(NotificationRequest request);

	/**
	 * This function sends a reminder for when a publication is due
	 * @param request this is a wrapped object of type NotificationRequest, upon a function call a ReminderNotificationRequest object must be created.
	 * @return NotificationResponse a wrapped object for Responses, upon a function call it will create a ReminderNotificationResponse object with a success or failure.
	 */
	public NotificationResponse ReminderNotification(NotificationRequest request);

	/**
	 * This function sends a Broadcast based notification which is scheduled by a User
	 * @param request this is a wrapped object of type NotificationRequest, upon a function call a BroadcastNotificationRequest object must be created.
	 * @return NotificationResponse a wrapped object for Responses, upon a function call it will create a BroadcastNotificationResponse object with a success or failure.
	 */
	public NotificationResponse BroadcastNotification(NotificationRequest request);

	/**
	 * This function allows the user to be able to modify an scheduled Notification
	 * @param modify this is a wrapped object of type ModificationRequest, upon a function call a the corresponding Modification object must be created according to the Notification type.
	 * @return ModificationResponse a wrapped object for Responses, upon a function call it will create a corresponding ModificationResponse object must be created according to the Notification type with a success or failure.
	 */
	public ModificationResponse ModifyNotification(ModificationRequest modify);

	/**
	 * This function allows the user to be able to remove an scheduled Notification
	 * @param remove this is a wrapped object of type RemoveRequest, upon a function call a the corresponding RemoveRequest object must be created according to the Notification type.
	 * @return RemoveResponse a wrapped object for Responses, upon a function call it will create a corresponding ModificationResponse object must be created according to the Notification type with a success or failure.
	 */
	public RemoveResponse RemoveNotification(RemoveRequest remove);

}

//
//	/**
//	 * Utilised by Users to send a Report to a to a specific User.
//	 *
//	 * @param 	user object that contains the recipient to send the report
//	 * @param 	report object than contains the Report image to sent to the recipient
//	 * @return 	boolean - True is successful, false otherwise
//	 */
//	public boolean sendReport(User user, Report report);
//
//	/**
//	 * Utilised to schedule general reminders for Users.
//	 *
//	 * @param 	recipient the object which needed to aquire E-mail address
//	 * @param 	message the text of the Notification
//	 * @return 	boolean - True if sent successfully, false otherwise
//	 */
//	public boolean sendReminder(User recipient, String message);
//
//	/**
//	 * Utilised by Group Leaders or Administrators to send scheduled broadcast messages.
//	 *
//	 * @param 	recipient the user who should receive the notification
//	 * @param 	message the message to be broadcast
//	 * @return 	boolean - True if sent successfully, false otherwise
//	 */
//	public boolean sendBroadcastNotification(User recipient, String message);
//
//	/**
//	 * Utilised by Group Leaders or Administrators to send scheduled broadcast messages.
//	 *
//	 * @param 	recipient the user who should receive the notification
//	 * @param 	message the message to be broadcast
//	 * @return 	boolean - True if sent successfully, false otherwise
//	 */
//	public boolean sendActivityNotification(User recipient, String message);
//
//
//
//
//	/**
//	 * Utilised by Groups to send a Notification to other Users.
//	 *
//	 * @param	nameID the ID in which the notification can be addressed
//	 * @param 	userPool vector pool of recipient to send the broadcast notification to
//	 * @param 	message string holding the message to be sent
//	 * @param 	start the start date for the scheduled broadcast
//	 * @param 	end the end date for the scheduled broadcast
//	 * @param	duration object that holds the frequency of the scheduled notification
//	 * @return 	boolean - True if sent successfully, false otherwise
//	 */
//	public boolean scheduleBroadNotification(String nameID, Vector<Users> userPool, String message, Date start, Date end, DurationUnit duration );
//
//	/**
//	 * Utilised by Groups to schedule a Report Notification.
//	 *
//	 * @param	nameID the ID in which the notification can be addressed
//	 * @param 	user recipient to send the report notification to
//	 * @param 	report object that contains the report image to send to the recipients
//	 * @param 	message string holding the message to be sent
//	 * @param 	start the start date for the scheduled notification
//	 * @param 	end the end date for the scheduled notification
//	 * @param	duration object that holds the frequency of the scheduled notification
//	 * @return 	boolean - True if sent successfully, false otherwise
//	 */
//	public boolean scheduleReportNotification(String nameID, User user, Report report, String message, Date start, Date end, DurationUnit duration);
//
//	/**
//	 * Utilised by Users to schedule a Reminder Notification for when an item is due.
//	 *
//	 * @param	nameID the ID in which the notification can be addressed
//	 * @param 	user recipient to send the report notification to
//	 * @param	message string holding the message to be sent
//	 * @param 	start the start date for the scheduled notification
//	 * @param 	end the end date for the scheduled notification
//	 * @param	duration object that holds the frequency of the scheduled notification
//	 * @return 	boolean - True if scheduled successfully, false otherwise
//	 */
//	public boolean scheduleReminderNotification(String nameID, User user, String message, Date start, Date end, DurationUnit duration);
//
//	/**
//	 * Utilised by Users to send a Notification when Activity occurs on a Publication.
//	 *
//	 * @param	nameID the ID in which the notification can be addressed
//	 * @param 	user recipient to send the report notification to
//	 * @param	message string holding the message to be sent
//	 * @param 	start the start date for the scheduled notification
//	 * @param 	end the end date for the scheduled notification
//	 * @param	duration object that holds the frequency of the scheduled notification
//	 * @return 	boolean - True if scheduled successfully, false otherwise
//	 */
//	/*does not make sense need some clarification*/
//	public boolean scheduleActivitiesNotification(String nameID, User user, String message, Date start, Date end, DurationUnit duration);
//
//	/**
//	 * Utilised to notify Users of any changes made to Publications for which they are authors on.
//	 *
//	 * @param	recipient the object which needed to aquire E-mail address
//	 * @param 	publication the object needed to see what Activity has occured
//	 * @return 	boolean - True if sent successfully, false otherwise
//	 */
//	public boolean sendActivityNotification(User recipient, Publication publication);
//
//	/**
//	 * Utilised by Users to remove a scheduled Notification.
//	 *
//	 * @param 	nameID the ID to which notification is to be removed
//	 * @return 	boolean - True if removed successfully, false otherwise
//	 */
//	public boolean removeNotification(String nameID);
//
//	/**
//	 * Utilised by Users to modify a scheduled Notification.
//	 *
//	 * @param 	nameID the ID in which the notification can be addressed
//	 * @param	message string holding the message to be sent - if null no change made
//	 * @param 	start the start date for the scheduled notification - if null no change made
//	 * @param 	end the end date for the scheduled notification - if null no change made
//	 * @param	duration object that holds the frequency of the scheduled notification - if null no change made
//	 * @return 	boolean - True if modified successfully, false otherwise
//	 */
//	public boolean modifyNotification(String nameID, String message, Date start, Date end, DurationUnit duration);
