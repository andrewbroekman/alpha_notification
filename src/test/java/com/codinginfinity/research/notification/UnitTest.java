package com.codinginfinity.research.notification;

import com.codinginfinity.research.notification.Interval;
import com.codinginfinity.research.notification.defaultImpl.Notifications;
import com.codinginfinity.research.notification.exceptions.InvalidRequestException;
import com.codinginfinity.research.notification.mock.User;
import com.codinginfinity.research.notification.requests.*;
import com.codinginfinity.research.notification.responses.NotificationResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author COS301 Alpha Notification
 */
public class UnitTest
{
    private Notifications notification;
    private NotificationRequest activitiesNotificationRequest;
    private BroadcastNotificationRequest broadcastNotificationRequest;
    private ReminderRequest reminderRequest;
    private ReportNotificationRequest reportNotificationRequest;
    private NotificationResponse notificationResponse =null;

    @Before
    public void initializeObjects()
    {
        activitiesNotificationRequest = new ActivitiesNotificationRequest("1", new User("Themba", "Mbhele", "mbhelethemba4@gmail.com", "Member"),"This is the message to be sent!",new Date(), new Date(), new Interval(""));
        notification = new Notifications();
        ArrayList<String> list = new ArrayList<String>();
        list.add("mbhelethemba4@gmail.com");
        list.add("lochnerAmy@gmail.com");
        list.add("tashan.avi@gmail.com");
        list.add("nelChristiaan@hotmail.com");
        list.add("dregrar@gmail.com");
        broadcastNotificationRequest = new BroadcastNotificationRequest("2",list,"This is a broadcast message",new Date(),new Date(), new Interval("weeks"));
        reminderRequest = new ReminderRequest("3",new User("Amy","Lochner","lochnerAmy@gmail.com", "Member"),"This is a reminder: Your publication is due on Friday 22 April 2016", new Date(), new Date(),new Interval("days"));
        reportNotificationRequest = new ReportNotificationRequest("4", new User("Avinash", "Singh", "tashan.avi@gmail.com", "Leader"), "This is a Notification on your Report", "report.svg", new Date(), new Date(), new Interval("weekly"));

    }

    @Test
    public void testReportNotification()
    {

        try
        {
            notificationResponse = notification.ReportNotification(reportNotificationRequest);
            assertEquals("The code of the response object should be 'SUCCESS' " + notificationResponse.getMessage(), "SUCCESS", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void testReportNotificationInvalidImage()
    {

        try
        {
            notificationResponse = notification.ReportNotification(new ReportNotificationRequest("4", new User("Avinash", "Singh", "tashan.avi@gmail.com", "Leader"), "This is a Notification on your Report", null, new Date(), new Date(), new Interval("weekly")));
            assertEquals("The code of the response object should be 'FAILED' " + notificationResponse.getMessage(), "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }


    @Test
    public void testReportNotificationEmailException()
    {

        try
        {
            notificationResponse = notification.ReportNotification(null);
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void testActivityNotification()
    {

        try
        {
           notificationResponse = notification.ActivitiesNotification(activitiesNotificationRequest);
            assertEquals("The code of the response object should be 'SUCCESS' ", "SUCCESS", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void testActivityNotificationNoMessage()
    {

        try
        {
            notificationResponse = notification.ActivitiesNotification(activitiesNotificationRequest = new ActivitiesNotificationRequest("1", new User("Themba", "Mbhele", "mbhelethemba4@gmail.com", "Member"),"",new Date(), new Date(), new Interval("")));
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void testActivityNotificationNoUser()
    {

        try
        {
            notificationResponse = notification.ActivitiesNotification(activitiesNotificationRequest = new ActivitiesNotificationRequest("1", null,"",new Date(), new Date(), new Interval("")));
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void testActivityNotificationNoRecipient()
    {

        try
        {
            notificationResponse = notification.ActivitiesNotification(activitiesNotificationRequest = new ActivitiesNotificationRequest("1", new User("Themba", "Mbhele", "", "Member"), "Activity Notification", new Date(), new Date(), new Interval("")));
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void testActivityNotificationEmailException()
    {

        try
        {
            notificationResponse = notification.ActivitiesNotification(null);
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }
    @Test
    public void testBroadcastNotification()
    {
        try
        {
            notificationResponse = notification.BroadcastNotification(broadcastNotificationRequest);
            assertEquals("The code of the response object should be 'SUCCESS' ", "SUCCESS", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void testBroadcastNotificationNoUsers()
    {
        try
        {
            notificationResponse = notification.BroadcastNotification(broadcastNotificationRequest = new BroadcastNotificationRequest("2",null,"This is a broadcast message",null,new Date(), new Interval("weeks")));
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void testBroadcastNotificationNoStartDate()
    {


        try
        {
            ArrayList<String> list = new ArrayList<String>();
            list.add("mbhelethemba4@gmail.com");
            list.add("lochnerAmy@gmail");
            list.add("tashan.avi@gmail.com");
            list.add("nelChristiaan@hotmail.com");
            list.add("dregrar@gmail.com");
            notificationResponse = notification.BroadcastNotification(new BroadcastNotificationRequest("2",list,"This is a broadcast message",null,new Date(), new Interval("weeks")));
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }
    @Test
    public void testBroadcastNotificationEmailException()
    {
        try
        {
            notificationResponse = notification.BroadcastNotification(null);
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test
    public void testRemindertNotification()
    {
        try
        {
            notificationResponse = notification.ReminderNotification(reminderRequest);
            assertEquals("The code of the response object should be 'SUCCESS' ", "SUCCESS", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }
    @Test
    public void testReminderNotificationEmailException()
    {

        try
        {
            notificationResponse = notification.ReminderNotification(null);
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(UnitTest.class);
    }
}
