package com.codinginfinity.research.notification.defaultImpl;

/**
 * @author COS301 Team Alpha Notification
 */
public class Interval
{
	public enum DurationUnit
	{
	    days, weeks,months, years
	}
	
	private String interval;
	
	public Interval(String interval)
	{
		this.interval = interval;
    }
	
	public void setDuration(String interval)
	{
		this.interval = interval;
	}
	public String getDuration()
	{
		return this.interval;
	}
}
