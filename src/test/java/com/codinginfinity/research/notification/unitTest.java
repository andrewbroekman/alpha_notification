import com.codinginfinity.research.notification.*;
import java.util.*;
import java.lang.Object;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class unitTest
{
	private ArrayList<NotificationRequest> list;
	Notifcation notify = new Notifcation();

	@Before
	public void preTestInitialization()
	{
		list = new ArrayList<NotificationRequest>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    	Date date;//= sdf.parse("2013-09-18");
    	Date edate;

		list.add(new ActivitiesNotificationRequest(new User(), "Activity notification Request",date("11-04-2016 10:15"), edate("11-04-2016 10:15"), null));
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("a@gmail.com");
		list1.add("b@gmail.com");
		list1.add("c@gmail.com");
		list1.add("d@gmail.com");
		list.add(new BroadcastNotificationRequest(list1, "Broadcast Notification Request", date("11-04-2016 10:30"), edate("20-04-2016 10:30"), new Interval("days")));
		list.add(new ReminderNotificationRequest(new User(), "Reminder Notification Request", date("11-04-2016 10:30"), edate("20-04-2016 10:30"), new Interval("days")))	;
		//Make a fake image
		//list.add(new ReportNotificationRequest(new User(), "Report Notification Request", Image image, date("11-04-2016 10:30"), edate("20-04-2016 10:30"), new Interval("days"));
	}
	@After
	public void postTestCleanup()
	{
		testData.clear();
	}
	@Test
	public void testActivityNotification()
	{
		try
		{
			NotificationResponse response = notify.ActivitiesNotification(list.get(0));
			assertEquals("The email was sent", "SUCCESS", response.getCode);
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}
		
	}
	@Test(expected = InvalidRequestException.class)
	public void testActivityNotificationNull()
	{
		try
		{
			NotificationResponse response = notify.ActivitiesNotification(null);
		}
		catch(InvalidRequestException err)
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
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}
		
	}
	@Test(expected = InvalidRequestException.class)
	public void testReminderNotificationNull()
	{
		try
		{
			NotificationResponse response = notify.ReminderNotification(null);
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}
		
	}
	@Test
	public void testBroadcastNotification()
	{
		try
		{
			NotificationResponse response = notify.BroadcastNotification(list.get(1));
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}
		
	}
	@Test(expected = InvalidRequestException.class)
	public void testBroadcastNotificationNull()
	{
		try
		{
			NotificationResponse response = notify.BroadcastNotification(null);
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}
		
	}
	@Test
	public void testReportNotification()
	{
		try
		{
			NotificationResponse response = notify.ReportNotification(list.get(3));
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}
		
	}
	@Test(expected = InvalidRequestException.class)
	public void testReportNotificationNull()
	{
		try
		{
			NotificationResponse response = notify.ReportNotification(null);
		}
		catch(InvalidRequestException err)
		{
			System.out.println("A null request was sent through");
		}
		
	}
}