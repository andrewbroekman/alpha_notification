package com.codinginfinity.research.notification;

/**
 * @TODO clarify the interface as well as a descriptive javaDoc comments
 */

import com.codinginfinity.research.notification.exceptions.InvalidRequestException;
import com.codinginfinity.research.notification.requests.ModifyNotificationRequest;
import com.codinginfinity.research.notification.requests.NotificationRequest;
import com.codinginfinity.research.notification.requests.RemoveRequest;
import com.codinginfinity.research.notification.responses.ModificationResponse;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import com.codinginfinity.research.notification.responses.RemoveResponse;

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
	public NotificationResponse ActivitiesNotification(NotificationRequest request) throws InvalidRequestException;

	/**
	 * This function sends a report based notification which is scheduled by a User
	 * @param request this is a wrapped object of type NotificationRequest, upon a function call a ReportNotificationRequest object must be created.
	 * @return NotificationResponse a wrapped object for Responses, upon a function call it will create a ReportNotificationResponse object with a success or failure.
     */
	public NotificationResponse ReportNotification(NotificationRequest request) throws InvalidRequestException;

	/**
	 * This function sends a reminder for when a publication is due
	 * @param request this is a wrapped object of type NotificationRequest, upon a function call a ReminderNotificationRequest object must be created.
	 * @return NotificationResponse a wrapped object for Responses, upon a function call it will create a ReminderNotificationResponse object with a success or failure.
	 */
	public NotificationResponse ReminderNotification(NotificationRequest request)throws InvalidRequestException;

	/**
	 * This function sends a Broadcast based notification which is scheduled by a User
	 * @param request this is a wrapped object of type NotificationRequest, upon a function call a BroadcastNotificationRequest object must be created.
	 * @return NotificationResponse a wrapped object for Responses, upon a function call it will create a BroadcastNotificationResponse object with a success or failure.
	 */
	public NotificationResponse BroadcastNotification(NotificationRequest request)throws InvalidRequestException;

	/**
	 * This function allows the user to be able to modify an scheduled Notification
	 * @param modify this is a wrapped object of type ModifyNotificationRequest, upon a function call a the corresponding Modification object must be created according to the Notification type.
	 * @return ModificationResponse a wrapped object for Responses, upon a function call it will create a corresponding ModificationResponse object must be created according to the Notification type with a success or failure.
	 */
	//public ModificationResponse ModifyNotification(ModifyNotificationRequest modify)throws InvalidRequestException;

	/**
	 * This function allows the user to be able to remove an scheduled Notification
	 * @param remove this is a wrapped object of type RemoveRequest, upon a function call a the corresponding RemoveRequest object must be created according to the Notification type.
	 * @return RemoveResponse a wrapped object for Responses, upon a function call it will create a corresponding ModificationResponse object must be created according to the Notification type with a success or failure.
	 */
	//public RemoveResponse RemoveNotification(RemoveRequest remove)throws InvalidRequestException;

}
