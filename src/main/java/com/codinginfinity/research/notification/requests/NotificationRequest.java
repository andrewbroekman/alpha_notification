package com.codinginfinity.research.notification.requests;

import com.codinginfinity.research.notification.Interval;
import com.codinginfinity.research.notification.mock.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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

    public void setUser(User u);
    public void setMessage(String m);
    public void setStartDate(Date d);
    public void setEndDate(Date d);
    public void setInterval(Interval i);

    @Id
    public String getId();


}
