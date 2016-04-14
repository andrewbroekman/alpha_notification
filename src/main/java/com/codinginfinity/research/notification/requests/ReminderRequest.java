package com.codinginfinity.research.notification.requests;

import com.codinginfinity.research.notification.defaultImpl.Emailer;
import com.codinginfinity.research.notification.Interval;
import com.codinginfinity.research.notification.defaultImpl.Schedules;
import com.codinginfinity.research.notification.mock.User;


import javax.inject.Inject;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author COS301 - Alpha Notifications
 */
public class ReminderRequest implements NotificationRequest
{
    @Inject
    private User user;
    private String message;
    private Date startDate;
    private Date endDate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Inject
    private Interval interval;

    /**
     * This constructor initializes all the variables of the class.
     *
     * @param user the User object that contains the recipient address.
     * @param message the message to send to the recipient.
     */
   @Inject
   public ReminderRequest(String id, User user, String message, Date startDate, Date endDate, Interval interval)
    {
        this.user = user;
        this.id = id;
        this.message = message;
        this.startDate = startDate;
        this.endDate = endDate;
        this.interval = interval;
    }


    public User getUser()
    {
        return this.user;
    }
    public String getMessage()
    {
        return this.message;
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
}
