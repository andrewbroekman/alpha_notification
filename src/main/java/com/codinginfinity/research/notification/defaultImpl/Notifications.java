package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.INotification;
import com.codinginfinity.research.notification.exceptions.InvalidRequestException;
import com.codinginfinity.research.notification.requests.NotificationRequest;
import com.codinginfinity.research.notification.responses.NotificationResponse;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *  Implementation of INotification module which the system will use to make use of Notification functionality
 *  @author COS301 - Alpha Notifications
 */
public class Notifications implements INotification
{
    @PersistenceContext
    EntityManagerFactory emf;
    EntityManager em;
//    @Resource
//    UserTransaction utx;
    /**
    *   A schedules object used to call a function which will ask the emailer object to send the respective email
    */
    private Schedules schedules;
    /**
    *   Called by to issue an Activity Notification
    *   @param request object
    *   @return NotificationResponse with a success/fail code
    */
    @Inject public NotificationResponse ActivitiesNotification(NotificationRequest request) throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ActivitiesNotificationRequest is NULL");

        schedules = new Schedules(request);
      // em.persist(schedules);
        return schedules.sendActivityNotification();

    }
    /**
    *   Called by to issue an Report Notification
    *   @param request object
    *   @return NotificationResponse with a success/fail code
    */
    @Inject public NotificationResponse ReportNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ReportNotificationRequest is NULL");
        schedules = new Schedules(request);
        return schedules.sendReportNotification();
    }
    /**
    *   Called by to issue an Reminder Notification
    *   @param request object
    *   @return NotificationResponse with a success/fail code
    */
    @Inject public NotificationResponse ReminderNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("ReminderNotificationRequest is NULL");
        schedules = new Schedules(request);
        return schedules.sendReminderNotification();
    }
    /**
    *   Called by to issue an Broadcast Notification
    *   @param request object
    *   @return NotificationResponse with a success/fail code
    */
    @Inject public NotificationResponse BroadcastNotification(NotificationRequest request)throws InvalidRequestException
    {
        if (request == null) throw new InvalidRequestException("BroadcastNotificationRequest is NULL");
        schedules = new Schedules(request);
        return schedules.sendBroadcastNotification();
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
