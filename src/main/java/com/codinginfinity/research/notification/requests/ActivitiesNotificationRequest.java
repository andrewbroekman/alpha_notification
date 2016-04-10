package com.codinginfinity.research.notification.requests;

import com.codinginfinity.research.notification.Emailer;
import com.codinginfinity.research.notification.Interval;
import com.codinginfinity.research.notification.Schedule;
import com.codinginfinity.research.notification.responses.NotificationResponse;

import javax.inject.Inject;
import java.util.Date;

/**
 * @author COS301 Alpha Notifications
 * @version 1.0 Notifications
 */
public class ActivitiesNotificationRequest implements NotificationRequest
{
    @Inject
    private User user;
    private String message;
    private Date startDate;
    private Date endDate;

    @Inject
    Interval interval;


    /**
     * This constructor initializes all the variables of the class.
     *
     * @param user the User object that contains the recipient address.
     * @param message the message to send to the recipient.
     */
   @Inject
   ActivitiesNotificationRequest(User user, String message,Date startDate,Date endDate, Interval interval)
    {
        this.user = user;
        this.message = message;
        this.startDate = startDate;
        this.endDate = endDate;
        this.interval = null;
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


}
