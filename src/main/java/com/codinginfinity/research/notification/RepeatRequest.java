package com.codinginfinity.research.notification;

import java.util.Date;

/**
 * @author COS301 Team Alpha Notification
 */
public class RepeatRequest
{
    Date endDate;

    public RepeatRequest(Date endDate)
    {
        this.endDate = endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
    
    public Date getEndDate()
    {
	    return this.endDate;
    }
}
