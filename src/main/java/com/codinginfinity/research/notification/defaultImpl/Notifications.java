package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.INotification;
import com.codinginfinity.research.notification.exceptions.InvalidRequestException;
import com.codinginfinity.research.notification.requests.NotificationRequest;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import com.codinginfinity.research.notification.defaultImpl.Schedule;

import javax.inject.Inject;

/**
 *  Implementation of INotification module which the system will use to make use of Notification functionality
 *  @author COS301 - Alpha Notifications
 */
public class Notifications implements INotification
{
    /**
    *   A schedule object used to call a function which will ask the emailer object to send the respective email
    */
    private Schedule schedule;
    /**
    *   Called by to issue an Activity Notification
    *   @param NotificationRequest object
    *   @return NotificationResponse with a success/fail code
    */
    @Inject public NotificationResponse ActivitiesNotification(NotificationRequest request) throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ActivitiesNotificationRequest is NULL");
        schedule = new Schedule(request);
        return schedule.sendActivityNotification();

    }
    /**
    *   Called by to issue an Report Notification
    *   @param NotificationRequest object
    *   @return NotificationResponse with a success/fail code
    */
    @Inject public NotificationResponse ReportNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ReportNotificationRequest is NULL");
        schedule = new Schedule(request);
        return schedule.sendReportNotification();
    }
    /**
    *   Called by to issue an Reminder Notification
    *   @param NotificationRequest object
    *   @return NotificationResponse with a success/fail code
    */
    @Inject public NotificationResponse ReminderNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ReminderNotificationRequest is NULL");
        schedule = new Schedule(request);
        return schedule.sendReminderNotification();
    }
    /**
    *   Called by to issue an Broadcast Notification
    *   @param NotificationRequest object
    *   @return NotificationResponse with a success/fail code
    */
    @Inject public NotificationResponse BroadcastNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("BroadcastNotificationRequest is NULL");
        schedule = new Schedule(request);
        return schedule.sendBroadcastNotification();
    }
    /**
    *   Called to Modify a Notification
    *   @param ModifyNotificationRequest object
    *   @return ModificationResponse with a success/fail code
    */
//    @Inject public ModificationResponse ModifyNotification(ModifyNotificationRequest modify)throws InvalidRequestException
//    {
//        if (modify == null) throw new InvalidRequestException("ModifyNotificationRequest is NULL");
//        return null; // @TODO
//    }
    /**
    *   Called to Remove a Notification
    *   @param RemoveRequest object
    *   @return RemoveResponse with a success/fail code
    */
//    @Inject public RemoveResponse RemoveNotification(RemoveRequest remove)throws InvalidRequestException
//    {
//        if (remove == null) throw new InvalidRequestException("RemoveNotificationRequest is NULL");
//        return null; // @TODO
//    }

}
