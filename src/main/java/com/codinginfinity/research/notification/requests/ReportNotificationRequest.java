package com.codinginfinity.research.notification.requests;

import com.codinginfinity.research.notification.defaultImpl.Emailer;
import com.codinginfinity.research.notification.Interval;
import com.codinginfinity.research.notification.exceptions.ImageException;
import com.codinginfinity.research.notification.exceptions.RecipientException;
import com.codinginfinity.research.notification.mock.User;
import com.codinginfinity.research.notification.responses.NotificationResponse;


import javax.inject.Inject;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String imagePath;
    @Inject
    private Interval interval;

    /**
     * This constructor initializes all the variables of the class.
     *
     * @param user the User object that contains the recipient address.
     * @param message the message to send to the recipient.
     * @param image this contains the report image to be sent
     */
    @Inject
    ReportNotificationRequest(String id, User user, String message, Image image, Date startDate, Date endDate, Interval interval)
    {
        this.user = user;
        this.id = id;
        this.message = message;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.interval = interval;
    }


    public ReportNotificationRequest(String id, User user, String message, String image, Date startDate, Date endDate, Interval interval)
    {
        this.user = user;
        this.id = id;
        this.message = message;
        this.imagePath = image;
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
    @Id
    public String getId()
    {
        return id;
    }
    public String getImagePath()
    {
        return imagePath;
    }
    public void setUser(User u)
    {
        this.user = u;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setStartDate(Date s)
    {
        this.startDate = s;
    }

    public void setEndDate(Date s)
    {
        this.endDate = s;
    }

    public void setInterval(Interval i)
    {
        this.interval = i;
    }

}
