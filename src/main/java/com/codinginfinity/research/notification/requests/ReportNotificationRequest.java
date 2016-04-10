package com.codinginfinity.research.notification.requests;

import com.codinginfinity.research.notification.Emailer;
import com.codinginfinity.research.notification.Interval;
import com.codinginfinity.research.notification.exceptions.ImageException;
import com.codinginfinity.research.notification.exceptions.RecipientException;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import javax.inject.Inject;
import java.lang.Exception.*;


import java.awt.*;
import java.util.Date;

/**
 * @author COS301 - Alpha Notifications
 *
 */
public class ReportNotificationRequest implements NotificationRequest
{
    @Inject
    private User user;
    private Image image;
    private String message;
    private Date startDate;
    private Date endDate;
    @Inject
    private Interval interval;

    /**
     * This constructor initializes all the variables of the class.
     *
     * @param user the User object that contains the recipient address.
     * @param message the message to send to the recipient.
     * @param image this contains the report image to be sent
     */

    ReportNotificationRequest(User user, String message, Image image, Date startDate, Date endDate, Interval interval)
    {
        this.user = user;
        this.message = message;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.interval = interval;
    }

    public String getMessage()
    {
        return this.message;
    }
    public User getUser()
    {
        return this.user;
    }
    public Image getImage()
    {
        return this.image;
    }
    public Date getStartDate()
    {
        return this.startDate;
    }
    public Date getEndDate()
    {
        return this.endDate;
    }
    public Interval getInterval()
    {
        return this.interval;
    }

}
