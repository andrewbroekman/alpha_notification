package com.codinginfinity.research.notification;

import java.text.SimpleDateFormat;
import java.util.*;

import com.codinginfinity.research.notification.Interval;
import com.codinginfinity.research.notification.exceptions.InvalidRequestException;
import com.codinginfinity.research.notification.exceptions.RecipientException;
import com.codinginfinity.research.notification.mock.User;
import com.codinginfinity.research.notification.requests.*;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import com.codinginfinity.research.notification.defaultImpl.Notifications;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import javax.ejb.Schedule;
import javax.annotation.*;

import static com.codinginfinity.research.notification.Interval.DurationUnit.days;
import static org.junit.Assert.assertEquals;

//import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
//import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
//import static groovy.util.GroovyTestCase.assertEquals;
@SuppressWarnings("deprecation")
public class unitTest
{
	private ArrayList<NotificationRequest> list;
	Notifications notify = new Notifications();

	@Before
	public void preTestInitialization()
	{
		list = new ArrayList<NotificationRequest>();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
//    	Date date;//= sdf.parse("2013-09-18");
//    	Date edate;

		list.add(new ActivitiesNotificationRequest("1", new User("A","A","tashan.avi@gmail.com","A"), "Activity notification Request",new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), null));
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("u14043778@gmail.com");
		list1.add("thembambhele4@gmail.com");
		list1.add("1@gmail.com");
		list1.add("d@gmail.com");
		list.add(new BroadcastNotificationRequest("1",list1, "Broadcast Notification Request",
				new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), new Interval("days")));
		list.add(new ReminderRequest("2", new User("A","A","tashan.avi@gmail.com","A"), "Reminder Notification Request", new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), new Interval("days")))	;
		//Make a fake image
		list.add(new ReportNotificationRequest("1" ,new User("A","A","tashan.avi@gmail.com","A"), "Report Notification Request", "report.svg", new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), new Interval("days")));
	}
	@After
	public void postTestCleanup()
	{
		list.clear();
	}

	@Test
	public void testActivityNotification()
	{
		try
		{
			NotificationResponse response = notify.ActivitiesNotification(new ActivitiesNotificationRequest("1", new User("A","A","tashan.avi@gmail.com","A"), "Activity notification Request",new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), null));
			assertEquals("The email was sent", "SUCCESS", response.getCode());
			System.out.println("Activity Notification Success!!!");
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}

	}

	@Test
	public void testActivityNotificationNull()
	{
		try
		{
			NotificationResponse response = notify.ActivitiesNotification(null);
            assertEquals("The email was sent", "SUCCESS", response.getCode());
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through (null)");
		}

	}

	@Test
	public void testActivityNotificationInvalidUser()
	{
		try
		{
			NotificationResponse response = notify.ActivitiesNotification(new ActivitiesNotificationRequest("1", new User("A","A",null,"A"), "Activity notification Request",new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), null));
			assertEquals("The email was not sent", "FAILED", response.getCode());
		}
		catch (InvalidRequestException e)
		{
			System.out.println("A null request was sent through");
		}
	}


	@Test
	public void testReminderNotification()
	{
		try
		{
			NotificationResponse response = notify.ReminderNotification(list.get(2));
            assertEquals("The email was sent", "SUCCESS", response.getCode());
			System.out.println("Reminder Notification Success!!!");
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}

	}

	@Test//(expected = InvalidRequestException.class)
	public void testReminderNotificationNull()
	{
		try
		{
			NotificationResponse response = notify.ReminderNotification(null);
            assertEquals("The email was not sent (null)", "FAILED", response.getCode());
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through (null)");
		}

	}

	@Test//(expected = InvalidRequestException.class)
	public void testReminderNotificationInvalidUser()
	{
		try
		{
			NotificationResponse response = notify.ReminderNotification(new ReminderRequest("2", new User("A","A",null,"A"), "Reminder Notification Request", new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), new Interval("days")));
			assertEquals("The email was not sent (null)", "FAILED", response.getCode());
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through (null)");
		}

	}

	@Test
	public void testBroadcastNotification()
	{
		try
		{
			NotificationResponse response = notify.BroadcastNotification(list.get(1));
            assertEquals("The email was sent", "SUCCESS", response.getCode());
			System.out.println("Broadcast Notification Success!!!");
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}

	}

	@Test//(expected = InvalidRequestException.class)
	public void testBroadcastNotificationNull()
	{
		try
		{
			NotificationResponse response = notify.BroadcastNotification(null);
            assertEquals("The email was not sent (null)", "FAILED", response.getCode());
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through (null)");
		}

	}

	@Test//(expected = InvalidRequestException.class)
	public void testBroadcastNotificationInvalidUserList()
	{
		try
		{
			NotificationResponse response = notify.BroadcastNotification(new BroadcastNotificationRequest("1",null, "Broadcast Notification Request",
					new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), new Interval("days")));
			assertEquals("The email was not sent (null)", "FAILED", response.getCode());
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through (null)");
		}

	}

	@Test
	public void testReportNotification()
	{
		try
		{
			NotificationResponse response = notify.ReportNotification(list.get(3));
            assertEquals("The email was sent" + response.getMessage(), "SUCCESS", response.getCode());
			System.out.println("Report Notification Success!!!" + response.getCode());
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}

	}

	@Test//(expected = InvalidRequestException.class)
	public void testReportNotificationNull()
	{
		try
		{
			NotificationResponse response = notify.ReportNotification(null);
            assertEquals("The email was not sent (null)", "FAILED", response.getCode());
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through (null)");
		}

	}

	@Test//(expected = InvalidRequestException.class)
	public void testReportNotificationInvalidUser()
	{
		try
		{
			NotificationResponse response = notify.ReportNotification(new ReportNotificationRequest("1" ,new User("A","A",null ,"A"), "Report Notification Request", "report.svg", new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), new Interval("days")));
			assertEquals("The email was not sent (null)", "FAILED", response.getCode());
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through (null)");
		}

	}

	@Test//(expected = InvalidRequestException.class)
	public void testReportNotificationInvalidImage()
	{
		try
		{
			NotificationResponse response = notify.ReportNotification(new ReportNotificationRequest("1" ,new User("A","A","tashan.avi@gmail.com" ,"A"), "Report Notification Request", null, new Date(2016,04,14, 10, 30), new Date(2016,04,14, 10, 30), new Interval("days")));
			assertEquals("The email was not sent (null)", "FAILED", response.getCode());
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through (null)");
		}

	}
}