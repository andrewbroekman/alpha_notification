package com.codinginfinity.research.notification.mock;

import java.util.Date;

/**
*	This is a mock object for testing purposes.
*	@author Gerard Jacques van wyk
*/

public class Report{
	
	private String reportPath;
	private Date reportDate;
	private String message;
	
	/**
	*	This is the constructor to create a Report object.
	*	@param reportPath the path to the report image.
	*	@param reportDate the date that the report was generated.
	*/
	public Report(String reportPath, Date reportDate){
		this.reportPath = reportPath;
		this.reportDate = reportDate;
		message = "This is a notification on your Report progress";
	}
	
	/**
	*this method returns the path to the report image.
	*@return the path to the report image.
	*/
	public String getReportPath(){
		return reportPath;
	}
	
	/**
	*this method returns the pathe to the report image.
	*@return the date that the report was generated.
	*/
	public Date getReportDate(){
		return reportDate;
	}

	public String getMessage(){return message;}
}