package com.codinginfinity.research.notification;

import java.util.Date;

/**
 * @author COS301 Team Alpha Notification
 */
public class RepeatRequest
{
    private Date endDate;
    private Interval interval;

    public RepeatRequest(Date endDate, Interval interval)
    {
        this.endDate = endDate;
        this.interval = interval;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
    
    public Date getEndDate()
    {
	    return this.endDate;
    }

    public Interval getInterval() { return this.interval; }
}
