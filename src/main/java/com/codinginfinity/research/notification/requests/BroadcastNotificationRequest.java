package com.codinginfinity.research.notification.requests;


import com.codinginfinity.research.notification.Interval;
import com.codinginfinity.research.notification.mock.User;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class creates a Request for a broadcast and implements the wrapped object NotificationRequest
 *
 * @author	COS301 - Alpha Notifications
 * @version 1.0 Notifications
 *
 */
public class BroadcastNotificationRequest implements NotificationRequest
{
    /**
    *  userList this vector contains all the users relevant to the Broadcast.
    */
   private ArrayList<String> userList;

    /**
     *
     */
    private String message;

    /**
     *
     */
    private Date startDate;

    /**
     *
     */
    private Date endDate;

    private String id;

    /**
     *
     */
    @Inject private Interval interval;

    /**
     * This constructor initializes the variables of the cass
     *
     * @param list this is the recipient list that will contain the email addresses from the User object
     * @param message this is the actual message to be sent to the recipient
     * @param startDate this is the start date of the notification
     * @param endDate this is the end data of the notification
     * @param interval this is the enumeration class for the frequency of the notification.
     */
    @Inject
    public BroadcastNotificationRequest(String id, ArrayList<String> list, String message, Date startDate, Date endDate, Interval interval)
    {
        this.id = id;
        this.message = message;
        this.startDate = startDate;
        this.endDate = endDate;
        this.interval = interval;
        this.userList = list;

    }

    public User getUser()
    {
        return null;
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

    public String getId()
    {
        return id;
    }

    public ArrayList<String> getUserlist()
    {
        return this.userList;
    }


}
