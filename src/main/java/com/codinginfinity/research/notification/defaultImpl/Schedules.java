package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.RepeatRequest;
import com.codinginfinity.research.notification.exceptions.ImageException;
import com.codinginfinity.research.notification.exceptions.RecipientException;
import com.codinginfinity.research.notification.defaultImpl.Emailer;
import com.codinginfinity.research.notification.requests.*;
import com.codinginfinity.research.notification.responses.NotificationResponse;

import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import javax.ejb.Schedule;
import javax.annotation.*;

/**
 * Schedules class which takes a request and requires the Emailer object to send the respective email
 * @author COS301 Team Alpha Notification
 */
//@Entity(name = "Schedule")
//@Table
public class Schedules
{

    /**
    * A notification request to be scheduled
    */
    @Inject
    public NotificationRequest request;
    /**
    * A repeatRequest object that determines if the notification is to be repeated
    */
    private RepeatRequest repeatRequest;
    /**
    * An Emailer object which is used to send an email
    */
    private Emailer email;


    /**
    * Initialises a schedule object 
    */
//    private EntityManagerFactory emfactory;
//    private EntityManager entitymanager;
    private String id;

    private long duration = 6000;
    private javax.ejb.TimerService timerService;
    private Timer timer;

    public Schedules(NotificationRequest request)
    {
        this.request = request;
        this.repeatRequest = new RepeatRequest(request.getEndDate(), request.getInterval());

        email = new Emailer();
//        emfactory = Persistence.createEntityManagerFactory( "PersistenceUnit" );
//
//        entitymanager = emfactory.createEntityManager( );
//        entitymanager.getTransaction( ).begin( );
//
//
//        entitymanager.persist( request);
//        entitymanager.getTransaction( ).commit( );
//
//        entitymanager.close( );
//        emfactory.close( );
    }

    public Schedules()
    {
    }

    /**
    * Extracts the necessary fields from the ActivityNotificationRequest object and passes them through to the sendMail function
    * @return NotificationResponse with a success/fail code
    */



    @javax.ejb.Schedule(minute = "*/15")
    public NotificationResponse sendActivityNotification()
    {
//        timer = timerService.createSingleActionTimer(request.getEndDate(), new TimerConfig());
       try
       {
           String recipient = request.getUser().getEmailAddress();
           String subject = "Activity Notification";
           if (recipient == null || recipient.equals(""))
               throw new RecipientException("No Email Address found");

           if(request.getMessage()== null || request.getMessage().equals(""))
               throw new MessagingException("No message found");

           if (!email.sendMail(recipient, subject, request.getMessage()))
               return new NotificationResponse("FAILED", "Could not send to the recipient: " + recipient);
       }
       catch (MessagingException me)
       {
           return new NotificationResponse("FAILED", "No message found");
       }
       catch (RecipientException re)
       {
           return new NotificationResponse("FAILED", re.getMessage());
       }
       return new NotificationResponse("SUCCESS");
    }

    
    /**
    * Extracts the necessary fields from the ReportNotificationRequest object and passes them through to the sendMail function
    * @return NotificationResponse with a success/fail code
    */


    @javax.ejb.Schedule(minute = "15")
    public NotificationResponse sendReportNotification()
    {
//        timer = timerService.createSingleActionTimer(request.getEndDate(), new TimerConfig());

        String subject = "Report Notification";
        try
        {
            ReportNotificationRequest req = (ReportNotificationRequest)request;
            if (request.getMessage() == null || request.getMessage().equals(""))
                throw new MessagingException();

            if (request.getUser() == null)
                throw new RecipientException("User Object is null");

            String recipient = request.getUser().getEmailAddress();
            if (recipient == null || recipient.equals(""))
                throw new RecipientException("No Email Address found");

            if (req.getImage() == null && Objects.equals(req.getImagePath(), "") || req.getImagePath() == null) throw new ImageException();

            if (!email.sendMail(recipient, subject, request.getMessage(), req.getImage()))
                return new NotificationResponse("FAILED", "Could not send to the recipient: " + recipient);
        }
        catch (ImageException ie)
        {
            return new NotificationResponse("FAILED", "Invalid image");
        }
        catch (MessagingException me)
        {
            return new NotificationResponse("FAILED", "No message found");
        }
        catch (RecipientException re)
        {
            return new NotificationResponse("FAILED", re.getMessage());
        }

        return new NotificationResponse("SUCCESS");
    }

    /**
    * Extracts the necessary fields from the ReminderRequest object and passes them through to the sendMail function
    * @return NotificationResponse with a success/fail code
    */

    @javax.ejb.Schedule(minute = "15")
    public NotificationResponse sendReminderNotification()
    {
//        timer = timerService.createSingleActionTimer(request.getEndDate(), new TimerConfig());
        String subject = "Reminder Notification";
        try
        {
            if (request.getMessage() == null || request.getMessage().equals("")) throw new MessagingException("No Message found");
            if (request.getUser() == null) throw new RecipientException("User Object is null");

            if (repeatRequest.getEndDate() == null && repeatRequest.getInterval()== null) throw new MessagingException("No Interval or End Date found");
            if (request.getStartDate() == null) throw new MessagingException("No Date found");

            String recipient = request.getUser().getEmailAddress();
            if (recipient == null || recipient.equals("")) throw new RecipientException("No Email Address found");

            if (!email.sendMail(recipient, subject, request.getMessage()))
                return new NotificationResponse("FAILED", "Could not send to the recipient: " + recipient);
        }
        catch (MessagingException me)
        {
            return new NotificationResponse("FAILED", me.getMessage());
        }
        catch (RecipientException re)
        {
            return new NotificationResponse("FAILED", re.getMessage());
        }


        return new NotificationResponse("SUCCESS");

    }

    @javax.ejb.Schedule(minute = "15")
    public NotificationResponse sendBroadcastNotification()
    {
//        timer = timerService.createSingleActionTimer(request.getEndDate(), new TimerConfig());
        String subject = "Broadcast Notification";
        try
        {
            BroadcastNotificationRequest req = (BroadcastNotificationRequest) request;
            if (req.getMessage() == null || req.getMessage().equals("")) throw new MessagingException("No Message found");
            if (req.getUserlist() == null) throw new RecipientException("User list is null");

            if (repeatRequest.getEndDate() == null && repeatRequest.getInterval()== null) throw new MessagingException("No Interval or End Date found");
            if (req.getStartDate() == null) throw new MessagingException("No Date found");

            if (!email.sendMail(req.getUserlist(), subject, req.getMessage()))
                return new NotificationResponse("FAILED", "Could not send Broadcast Message");
        }
        catch (MessagingException me)
        {
            return new NotificationResponse("FAILED", me.getMessage());
        }
        catch (RecipientException re)
        {
            return new NotificationResponse("FAILED", re.getMessage());
        }


        return new NotificationResponse("SUCCESS");
    }

    // @TODO remove and modify :(



    @Id
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }


//    @Timeout
//    public void timeout(Timer timer) {
//        System.out.println("TimerBean: Request lifetime has expired");
//    }


//    @Override
//    protected void finalize() throws Throwable
//    {
//        try {
//            entitymanager.close();
//            emfactory.close();
//        } finally {
//            super.finalize();
//        }
//    }

}
