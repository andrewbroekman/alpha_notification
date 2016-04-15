package com.codinginfinity.research.notification.mock;
import javafx.scene.chart.PieChart;

import java.util.Date;
import java.util.Random;

/**
*	This is a mock object for testing purposes.
*	@author COS301 - Alpha Notifications
*/

public class Publication
{
	
	private String statusMessage;
	public String name;
	public Date d;
	/**
	*@param status string detailing the status of the Publication object
	* This constructor initialises the status message with a given string.
	*/
	public Publication(String name, String status)
	{

		this.name = name;
		this.statusMessage = statusMessage;
		d = new Date();
	}

	/**
	* This constructor initialises the status message with a random string.
	*/
	public Publication(){
		statusMessage = "Update on your Publication";
	}

	public String sendActivity()
	{
		return "This was triggered by a modification on your publication: <b>" + name +"</b>" ;
	}

	public Date getDate()
	{
		return d;
	}

	/**
	*@return statusMessage
	*/
	public String getStatusMessage(){
		return statusMessage;
	}

	public String getName() {return name;}

	public String getReminder()
	{
		return "Your Publication: <b>" + name + "</b>\n\n is due on the <i>" + d.toString() + "</i>\n\n\n";
	}


}