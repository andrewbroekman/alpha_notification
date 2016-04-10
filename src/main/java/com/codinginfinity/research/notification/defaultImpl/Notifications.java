package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.INotification;
import com.codinginfinity.research.notification.exceptions.InvalidRequestException;
import com.codinginfinity.research.notification.requests.NotificationRequest;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import com.codinginfinity.research.notification.defaultImpl.Schedule;

import javax.inject.Inject;

/**
 * @author COS301 - Alpha Notifications
 */
public class Notifications implements INotification
{

    private Schedule schedule;
  
    @Inject public NotificationResponse ActivitiesNotification(NotificationRequest request) throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ActivitiesNotificationRequest is NULL");
        schedule = new Schedule(request);
        return schedule.sendActivityNotification();

    }

    @Inject public NotificationResponse ReportNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ReportNotificationRequest is NULL");
        schedule = new Schedule(request);
        return schedule.sendReportNotification();
    }

    @Inject public NotificationResponse ReminderNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ReminderNotificationRequest is NULL");
        schedule = new Schedule(request);
        return schedule.sendReminderNotification();
    }

    @Inject public NotificationResponse BroadcastNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("BroadcastNotificationRequest is NULL");
        schedule = new Schedule(request);
        return schedule.sendBroadcastNotification();
    }

//    @Inject public ModificationResponse ModifyNotification(ModifyNotificationRequest modify)throws InvalidRequestException
//    {
//        if (modify == null) throw new InvalidRequestException("ModifyNotificationRequest is NULL");
//        return null; // @TODO
//    }
//
//    @Inject public RemoveResponse RemoveNotification(RemoveRequest remove)throws InvalidRequestException
//    {
//        if (remove == null) throw new InvalidRequestException("RemoveNotificationRequest is NULL");
//        return null; // @TODO
//    }

}
