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

	/**
	*@param status string detailing the status of the Publication object
	* This constructor initialises the status message with a given string.
	*/
	public Publication(String status){
		this.statusMessage = statusMessage;
	}

	/**
	* This constructor initialises the status message with a random string.
	*/
	public Publication(){
		statusMessage = "TEST MESSAGE";
	}

	public String sendActivity()
	{
		return "This was triggered by a modification on your publication: Science of Carrots";
	}

	public Date getDate()
	{
		return new Date();
	}

	/**
	*@return statusMessage
	*/
	String getStatusMessage(){
		return statusMessage;
	}

}