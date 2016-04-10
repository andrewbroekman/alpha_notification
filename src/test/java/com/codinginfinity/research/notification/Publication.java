package com.codinginfinity.research.notification;
import java.util.Random;

/**
*	This is a mock object for testing purposes.
*	@author Gerard Jacques van wyk
*/

public class Report{
	
	private String statusMessage;

	/**
	*@param statusMessage string detailing the status of the Publication object
	* This constructor initialises the status message with a given string.
	*/
	public Report(String status){
		this.statusMessage = statusMessage;
	}

	/**
	* This constructor initialises the status message with a random string.
	*/
	public Report(){
		statusMessage = "TEST MESSAGE";
	}

	/**
	*@return statusMessage
	*/
	String getStatusMessage(){
		return statusMessage;
	}

}