package com.codinginfinity.research.notification.requests;

import com.codinginfinity.research.notification.defaultImpl.Interval;
import com.codinginfinity.research.notification.responses.NotificationResponse;

import java.util.Date;
import java.lang.annotation.*;

/**
 * This interface is a wrapper for the different types of requests
 * @author COS301 - Alpha Notifications
 *
 */
public interface NotificationRequest
{

    public User getUser();
    public String getMessage();
    public Date getStartDate();
    public Date getEndDate();
    public Interval getInterval();
    public String getId();


}
