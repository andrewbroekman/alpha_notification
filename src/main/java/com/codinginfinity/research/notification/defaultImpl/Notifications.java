package com.codinginfinity.research.notification;

/**
 * Service contract for the Notifications module which is used to send a variety of notifications
 * to users
 *
 * @author 	Christiaan Nel
 * @author  Amy Lochner
 * @since 	2016-03-20
 *
 *	21/03/2016 Amy Lochner - clarified javadoc comments
 *
 */
public interface Notifications {
	
	/**
	 * Utilised by users to send a publications report to a group automatically.
	 *
	 * @param 	reportNotificationRequest Wrapper request object
	 * @return 	Wrapper response object
	 */
	public ReportNotificationResponse sendReport(ReportNotificationRequest reportNotificationRequest);
	
	/**
	 * Utilised to notify users of any changes made to publications for which they are authors on.
	 *
	 * @param 	activitiesNotificationsRequest Wrapper request object
	 * @return 	Wrapper response object
	 */	 
	public ActivityNotificationResponse sendActivityNotification(ActivitiesNotificationRequest activitiesNotificationsRequest);
	
	/**
	 * Utilised to schedule general reminders for users.
	 *
	 * @param 	reminderRequest Wrapper request object
	 * @return 	Wrapper response object
	 */
	public ReminderResponse sendReminder(ReminderRequest reminderRequest);
	
	/**
	 * Utilised by group leaders or administrators to send scheduled broadcast messages.
	 *
	 * @param 	broadNotificationRequest Wrapper request object
	 * @return 	Wrapper response object
	 */
	public BroadNotificationResponse sendBroadNotification(BroadNotificationRequest broadNotificationRequest);
}