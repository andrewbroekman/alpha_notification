package com.codinginfinity.research.notification;

/**
 * Created by Avinash on 2016-04-07 project notification.
 * @param reminder a request to create a reminder notification instance
 * @param report a request to create a report notification instance
 * @param activities a request to create an activities notification instance.
 */
public interface UserNotificationRequest extends NotificationRequest
{
    ReminderRequest reminder = null;
    ReportNotificationRequest report = null;
    ActivitiesNotificationRequest activities = null;
}
