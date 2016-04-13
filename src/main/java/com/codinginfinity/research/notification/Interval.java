package com.codinginfinity.research.notification;

import javax.inject.Inject;

/**
 *	Interval class which allows a user to specify a repeat interval
 * @author COS301 Team Alpha Notification
 */
public class Interval
{
	/**
	*	Duration unit options
	*/
	public enum DurationUnit
	{
	    days,weeks,months,years
	}
	/**
	*	The interval specified by the user
	*/
	@Inject
	private String interval;
	@Inject
	public Interval(String interval)
	{
		this.interval = interval.toLowerCase();
    }
	
	/**
	*	Utilised to change the interval unit
	*	@param interval - the new interval to unit
	*/
	public void setDuration(String interval)
	{
		this.interval = interval;
	}
	/**
	*	Utilised to obtain the interval unit
	*/
	public String getDuration()
	{
		return this.interval;
	}
}
