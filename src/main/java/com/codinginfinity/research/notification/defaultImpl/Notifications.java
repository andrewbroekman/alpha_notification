package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.INotification;
import com.codinginfinity.research.notification.Schedule;
import com.codinginfinity.research.notification.exceptions.InvalidRequestException;
import com.codinginfinity.research.notification.requests.ModifyNotificationRequest;
import com.codinginfinity.research.notification.requests.NotificationRequest;
import com.codinginfinity.research.notification.requests.RemoveRequest;
import com.codinginfinity.research.notification.responses.ModificationResponse;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import com.codinginfinity.research.notification.responses.RemoveResponse;

/**
 * @author COS301 - Alpha Notifications
 */
public class Notifications implements INotification
{
    @Inject
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
        return request.start();
    }

    @Inject public NotificationResponse ReminderNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ReminderNotificationRequest is NULL");
        return request.start();
    }

    @Inject public NotificationResponse BroadcastNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("BroadcastNotificationRequest is NULL");
        return request.start();
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
