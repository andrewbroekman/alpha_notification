package com.codinginfinity.research.notification.requests;

import com.codinginfinity.research.notification.Emailer;
import com.codinginfinity.research.notification.exceptions.ImageException;
import com.codinginfinity.research.notification.exceptions.RecipientException;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import java.lang.Exception.*;


import java.awt.*;

/**
 * Created by Avinash on 2016-04-07 project notification.
 * @author Avinash
 *
 */
public class ReportNotificationRequest implements NotificationRequest
{
    private User user;
    private Image image;
    private String message;
    private Emailer email;

    /**
     * This constructor initializes all the variables of the class.
     *
     * @param user the User object that contains the recipient address.
     * @param message the message to send to the recipient.
     * @param image this contains the report image to be sent
     */
    ReportNotificationRequest(User user, String message, Image image)
    {
        this.user = user;
        this.message = message;
        this.image = image;
        email = new Emailer();
    }

    public NotificationResponse start()
    {
        // @TODO Create message, extract email, subject, SEND IT!!!

        String subject = "Report Notification";
        try
        {
            if (message == null || message == "") throw new MessagingException();
            if (user == null) throw new RecipientException("User Object is null");

            String recipient = user.getEmailAddress();
            if (recipient == null || recipient == "") throw new RecipientException("No Email Address found");

            if (!email.sendMail(recipient, subject, message, image))
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

}
