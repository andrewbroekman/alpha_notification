package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.RepeatRequest;
import com.codinginfinity.research.notification.exceptions.ImageException;
import com.codinginfinity.research.notification.exceptions.RecipientException;
import com.codinginfinity.research.notification.requests.*;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import javax.ejb.Timeout;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import javax.ejb.Schedule;
import javax.annotation.*;

/**
 * @author COS301 Team Alpha Notification
 */
@Entity
public class Schedule
{
    public NotificationRequest request;
    private RepeatRequest repeatRequest;
    private String name;
    private Date startDate;
    private Emailer email;
    private String id;


    public Schedule(NotificationRequest request)
    {
        this.request = request;
        this.repeatRequest = new RepeatRequest(request.getEndDate(), request.getInterval());
    }

    @javax.ejb.Schedule(minute = "15")
    @Timeout
    public NotificationResponse sendActivityNotification()
    {
        // @TODO Create message, extract email, subject, SEND IT!!!
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

    @javax.ejb.Schedule(minute = "15")
    @Timeout
    public NotificationResponse sendReportNotification()
    {
        // @TODO Create message, extract email, subject, SEND IT!!!

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
    @javax.ejb.Schedule(minute = "15")
    @Timeout
    public NotificationResponse sendReminderNotification()
    {
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
    @Timeout
    public NotificationResponse sendBroadcastNotification()
    {
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


}
