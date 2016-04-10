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
	
	public Interval()
	{
        }
	
	public void setInterval(String interval)
	{
		this.interval = interval;
	}
}
