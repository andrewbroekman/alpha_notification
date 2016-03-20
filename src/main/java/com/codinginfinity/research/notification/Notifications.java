package com.codinginfinity.research.notification;

/**
 * Service contract for the Notifications module which is used to send a variety of notifications
 * to users
 *
 * @author 	Christiaan Nel
 * @since 	2016-03-20
 */
public interface Notifications {
	
	/**
	 * Used by users to have automatically a publications report on a group sent.
	 *
	 * @param 	reportNotificationRequest Wrapper request object
	 * @return 	Wrapper response object
	 */
	public ReportNotificationResponse sendReport(ReportNotificationRequest reportNotificationRequest);
	
	/**
	 * Used by users to be notified of any changes made to publications on which they are authors on.
	 *
	 * @param 	activitiesNotificationsRequest Wrapper request object
	 * @return 	Wrapper response object
	 */	 
	public ActivityNotificationResponse sendActivityNotification(ActivitiesNotificationRequest activitiesNotificationsRequest);
	
	/**
	 * Used by users to schedule general reminders for themselves.
	 *
	 * @param 	reminderRequest Wrapper request object
	 * @return 	Wrapper response object
	 */
	public ReminderResponse sendReminder(ReminderRequest reminderRequest);
	
	/**
	 * Used by group leaders or administration to send scheduled broadcast messages.
	 *
	 * @param 	broadNotificationRequest Wrapper request object
	 * @return 	Wrapper response object
	 */
	public BroadNotificationResponse sendBroadNotification(BroadNotificationRequest broadNotificationRequest);
}