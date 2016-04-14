package com.codinginfinity.research.notification.defaultImpl;
/**
 * COS301 - Alpha Notifications
 */
import com.codinginfinity.research.notification.RepeatRequest;
import com.codinginfinity.research.notification.exceptions.ImageException;
import com.codinginfinity.research.notification.exceptions.RecipientException;
import com.codinginfinity.research.notification.requests.BroadcastNotificationRequest;
import com.codinginfinity.research.notification.requests.NotificationRequest;
import com.codinginfinity.research.notification.requests.ReportNotificationRequest;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;


import java.util.Date;

    /**
     *  Schedule class which takes a request and requires the Emailer object to send the respective email
     * @author COS301 Team Alpha Notification
     */
//@Entity
    public class Schedules
    {
        /**
         * A notification request to be scheduled
         */
    //    @Inject
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
        private String id;
      //  @Inject
        public Schedules(NotificationRequest request)
        {
            this.request = request;
            this.repeatRequest = new RepeatRequest(request.getEndDate(), request.getInterval());
            email = new Emailer();
        }

        /**
         * Extracts the necessary fields from the ActivityNotificationRequest object and passes them through to the sendMail function
         * @return NotificationResponse with a success/fail code
         */

        //@javax.ejb.Schedule(minute = "15")
        //@Timeout
        public NotificationResponse sendActivityNotification()
        {
            // @TODO Create message, extract email, subject, SEND IT!!!
            try
            {
                if(request.getUser() ==  null)
                    throw new RecipientException("No user found");

                String recipient = request.getUser().getEmailAddress();

                String subject = "CS Research Management System Activities Notification";
                if (recipient == null || recipient.equals(""))
                    throw new RecipientException("No Email Address found");

                if(request.getMessage()== null || request.getMessage().equals(""))
                    throw new MessagingException("No message found");

                if (!email.sendMail(request.getUser().getFirstName(), recipient, subject, request.getMessage()))
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
        //@javax.ejb.Schedule(minute = "15")
        //@Timeout
        public NotificationResponse sendReportNotification()
        {
            // @TODO Create message, extract email, subject, SEND IT!!!

            String subject = "CS Research Management System Report Notification";
            try
            {
                ReportNotificationRequest req = (ReportNotificationRequest)request;

                if(req.getUser() == null)
                    throw new RecipientException("No User found");

                if (request.getMessage() == null || request.getMessage().equals(""))
                    throw new MessagingException();

                if (request.getUser() == null)
                    throw new RecipientException("User Object is null");

                String recipient = request.getUser().getEmailAddress();
                if (recipient == null || recipient.equals(""))
                    throw new RecipientException("No Email Address found");
                if (req.getImagePath() == null || req.getImagePath().equals(""))
                    throw new ImageException("No image found");

                if (!email.sendMail(request.getUser().getFirstName(), recipient, subject, request.getMessage(), req.getImagePath()))
                    return new NotificationResponse("FAILED", "Could not send to the recipient: " + recipient);
            } catch (MessagingException me)
            {
                return new NotificationResponse("FAILED", "No message found");
            }
            catch (RecipientException re)
            {
                return new NotificationResponse("FAILED", re.getMessage());
            } catch (javax.mail.MessagingException e)
            {
                //e.printStackTrace();
            }
            catch (ImageException e)
            {
               // e.printStackTrace();
                return new NotificationResponse("FAILED", e.getMessage());
            }

            return new NotificationResponse("SUCCESS");
        }
        /**
         * Extracts the necessary fields from the ReminderRequest object and passes them through to the sendMail function
         * @return NotificationResponse with a success/fail code
         */
        //@javax.ejb.Schedule(minute = "15")
        //@Timeout
        public NotificationResponse sendReminderNotification()
        {
            String subject = "CS Research Management System Reminder Notification";
            try
            {
                if (request.getMessage() == null || request.getMessage().equals("")) throw new MessagingException("No Message found");
                if (request.getUser() == null) throw new RecipientException("User Object is null");

                if (repeatRequest.getEndDate() == null && repeatRequest.getInterval()== null) throw new MessagingException("No Interval or End Date found");
                if (request.getStartDate() == null) throw new MessagingException("No Date found");

                String recipient = request.getUser().getEmailAddress();
                if (recipient == null || recipient.equals("")) throw new RecipientException("No Email Address found");

                if (!email.sendMail(request.getUser().getFirstName(), recipient, subject, request.getMessage()))
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
        //@javax.ejb.Schedule(minute = "15")
        //@Timeout
        public NotificationResponse sendBroadcastNotification()
        {
            String subject = "CS Research Management System Broadcast Notification";
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



        //@Id
        public String getId()
        {
            return id;
        }

        public void setId(String id)
        {
            this.id = id;
        }
}
