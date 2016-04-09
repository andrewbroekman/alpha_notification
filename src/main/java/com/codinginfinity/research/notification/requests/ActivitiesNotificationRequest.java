package com.codinginfinity.research.notification.requests;

import com.codinginfinity.research.notification.Emailer;
import com.codinginfinity.research.notification.Schedule;
import com.codinginfinity.research.notification.responses.NotificationResponse;

/**
 * @author COS301 Alpha Notifications
 * @version 1.0 Notifications
 */
public class ActivitiesNotificationRequest implements NotificationRequest
{
    User user;
    String message;
    Emailer email;

    /**
     * This constructor initializes all the variables of the class.
     *
     * @param user the User object that contains the recipient address.
     * @param message the message to send to the recipient.
     */
    ActivitiesNotificationRequest(User user, String message)
    {
        this.user = user;
        this.message = message;
        email = new Emailer();
    }

    public NotificationResponse start()
    {
        // @TODO Create message, extract email, subject, SEND IT!!!
        String recipient = user.getEmailAddress();
        String subject = "Activity Notification";
        if (!email.sendMail(recipient, subject, message))
            return new NotificationResponse("FAILED", "Could not send to the recipient: " + recipient);

        return new NotificationResponse("SUCCESS");
    }



}
