package com.codinginfinity.research.notification;

import java.util.Date;

/**
 * @author COS301 Team Alpha Notification
 */
public class Schedule
{

    private RepeatRequest repeatRequest;
    private String name;
    private Date startDate;

    public Schedule(Date startDate, Date endDate, String name)
    {
	    this.startDate = startDate;
	    this.name = name;
	    repeatRequest = new RepeatRequest(endDate);
    }

    public Date getStartDate()
    {
	    return this.startDate;
    }
}
