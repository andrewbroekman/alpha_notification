package com.codinginfinity.research.notification;

import com.codinginfinity.research.notification.Interval;
import com.codinginfinity.research.notification.defaultImpl.Notifications;
import com.codinginfinity.research.notification.exceptions.InvalidRequestException;
import com.codinginfinity.research.notification.mock.Publication;
import com.codinginfinity.research.notification.mock.Report;
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
@SuppressWarnings("depricated")
public class UnitTest
{
    private Notifications notification;
    private ActivitiesNotificationRequest activitiesNotificationRequest = null;
    private BroadcastNotificationRequest broadcastNotificationRequest = null;
    private ReminderRequest reminderRequest = null;
    private ReportNotificationRequest reportNotificationRequest = null;
    private NotificationResponse notificationResponse = null;


    private ActivitiesNotificationRequest serverAct = null;
    private BroadcastNotificationRequest serverBroad = null;
    private ReminderRequest serverRem = null;
    private ReportNotificationRequest serverRep = null;

    private User noUser = null;
    private User server = null;
    @Before
    public void initializeObjects()
    {
        User u1 = new User("Themba", "Mbhele", "mbhelethemba4@gmail.com", "Member");
        User u2 = new User("Amy", "Lochner", "lochnerAmy@gmail.com", "Member");
        User u3 = new User("Christiaan", "Nel","nelChristiaan@hotmail.com" , "Member");
        User u4 = new User("Gerhard", "Van Wuk", "dregrar@gmail.com", "Member");
        User u5 = new User("Jason", "Gordon", "gordz.gordon@gmail.com", "User");
        User u6 = new User("Avinash", "Singh", "tashan.avi@gmail.com", "Leader");
        server = new User("Mail", "Test", "cs.mail.alpha@gmail.com", "Test");
        noUser = new User("","","","");
        Publication pub = new Publication("Science of threading", "Title has changed");


        activitiesNotificationRequest = new ActivitiesNotificationRequest("1", u1, pub.sendActivity(),new Date(), new Date(), new Interval(""));
        serverAct = new ActivitiesNotificationRequest("2", server, pub.sendActivity(), new Date(), new Date(), new Interval(""));

        notification = new Notifications();

        ArrayList<String> list = new ArrayList<String>();
        list.add(u1.getEmailAddress());
        list.add(u2.getEmailAddress());
        list.add(u3.getEmailAddress());
        list.add(u4.getEmailAddress());
//        list.add(u5.getEmailAddress());
        list.add(u6.getEmailAddress());
        list.add(server.getEmailAddress());

        broadcastNotificationRequest = new BroadcastNotificationRequest("2",list,"This is a broadcast message",new Date(),new Date(), new Interval("weeks"));
        serverBroad = new BroadcastNotificationRequest("3",list,"This is a broadcast message",new Date(),new Date(), new Interval("weeks"));

        reminderRequest = new ReminderRequest("3",u2, pub.getReminder(), new Date(), new Date(),new Interval("days"));
        serverRem = new ReminderRequest("3",server, pub.getReminder(), new Date(), new Date(),new Interval("days"));

        Report r = new Report("report.svg", new Date());

        reportNotificationRequest = new ReportNotificationRequest("4", u6, r.getMessage(), r.getReportPath(), new Date(), r.getReportDate(), new Interval("weekly"));
        serverRep = new ReportNotificationRequest("4", server, r.getMessage(), r.getReportPath(), new Date(), r.getReportDate(), new Interval("weekly"));

    }

    @Test
    public void testReportNotification()
    {

        try
        {
            notificationResponse = notification.ReportNotification(reportNotificationRequest);
            assertEquals("The code of the response object should be 'SUCCESS' " + notificationResponse.getMessage(), "SUCCESS", notificationResponse.getCode());
            System.out.println("Sent Report successfully");

            notificationResponse = notification.ReportNotification(serverRep);
            assertEquals("The code of the response object should be 'SUCCESS' " + notificationResponse.getMessage(), "SUCCESS", notificationResponse.getCode());
            System.out.println("Sent Report server successfully");

        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test //(expected = InvalidRequestException.class)
    public void testReportNotificationInvalidImage() throws InvalidRequestException
    {

        try
        {
            notificationResponse = notification.ReportNotification(new ReportNotificationRequest("4", server, "This is a Notification on your Report", null, new Date(), new Date(), new Interval("weekly")));
            assertEquals("The code of the response object should be 'FAILED' " + notificationResponse.getMessage(), "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
//            System.out.println(error.getMessage());
            System.out.println("Success, caught the exception");
        }
    }


    @Test (expected = InvalidRequestException.class)
    public void testReportNotificationEmailException() throws InvalidRequestException
    {

//        try
//        {
            notificationResponse = notification.ReportNotification(null);
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
//        }
//        catch(InvalidRequestException error)
//        {
////            System.out.println(error.getMessage());
//            System.out.println("Success, caught the exception");
//        }
    }

    @Test
    public void testActivityNotification()
    {

        try
        {
           notificationResponse = notification.ActivitiesNotification(activitiesNotificationRequest);
            assertEquals("The code of the response object should be 'SUCCESS' ", "SUCCESS", notificationResponse.getCode());
            System.out.println("Sent Activity successfully");

            notificationResponse = notification.ActivitiesNotification(serverAct);
            assertEquals("The code of the response object should be 'SUCCESS' ", "SUCCESS", notificationResponse.getCode());
            System.out.println("Sent Activity server successfully");
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test //(expected = InvalidRequestException.class)
    public void testActivityNotificationNoMessage() throws InvalidRequestException
    {

        try
        {
            notificationResponse = notification.ActivitiesNotification(activitiesNotificationRequest = new ActivitiesNotificationRequest("1", server,"",new Date(), new Date(), new Interval("")));
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
//            System.out.println(error.getMessage());
            System.out.println("Success, caught the exception");
        }
    }

    @Test //(expected = InvalidRequestException.class)
    public void testActivityNotificationNoUser() throws InvalidRequestException
    {

        try
        {
            notificationResponse = notification.ActivitiesNotification(activitiesNotificationRequest = new ActivitiesNotificationRequest("1", null,"",new Date(), new Date(), new Interval("")));
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
//            System.out.println(error.getMessage());
            System.out.println("Success, caught the exception");
        }
    }

    @Test //(expected = InvalidRequestException.class)
    public void testActivityNotificationNoRecipient() throws InvalidRequestException
    {

        try
        {
            notificationResponse = notification.ActivitiesNotification(activitiesNotificationRequest = new ActivitiesNotificationRequest("1", noUser, new Publication().getStatusMessage(), new Date(), new Date(), new Interval("")));
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test(expected = InvalidRequestException.class)
    public void testActivityNotificationEmailException() throws InvalidRequestException
    {

//        try
//        {
            notificationResponse = notification.ActivitiesNotification(null);
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
//        }
//        catch(InvalidRequestException error)
//        {
//            System.out.println(error.getMessage());
//        }
    }
    @Test
    public void testBroadcastNotification()
    {
        try
        {
            notificationResponse = notification.BroadcastNotification(broadcastNotificationRequest);
            assertEquals("The code of the response object should be 'SUCCESS' ", "SUCCESS", notificationResponse.getCode());
            System.out.println("Sent Broadcast successfully");
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }

    @Test //(expected = InvalidRequestException.class)
    public void testBroadcastNotificationNoUsers() throws InvalidRequestException
    {
        try
        {
            notificationResponse = notification.BroadcastNotification(broadcastNotificationRequest = new BroadcastNotificationRequest("2",null,"This is a broadcast message",null,new Date(), new Interval("weeks")));
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
        }
        catch(InvalidRequestException error)
        {
//            System.out.println(error.getMessage());
            System.out.println("Success, caught the exception");
        }

    }

    @Test //(expected = InvalidRequestException.class)
    public void testBroadcastNotificationNoStartDate() //throws InvalidRequestException
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
//            System.out.println(error.getMessage());
            System.out.println("Success, caught the exception");
        }
    }
    @Test(expected = InvalidRequestException.class)
    public void testBroadcastNotificationEmailException() throws InvalidRequestException
    {
//        try
//        {
            notificationResponse = notification.BroadcastNotification(null);
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());
//        }
//        catch(InvalidRequestException error)
//        {
////            System.out.println(error.getMessage());
//            System.out.println("Success, caught the exception");
//        }
    }

    @Test
    public void testReminderNotification()
    {
        try
        {
            notificationResponse = notification.ReminderNotification(reminderRequest);
            assertEquals("The code of the response object should be 'SUCCESS' ", "SUCCESS", notificationResponse.getCode());
            System.out.println("Sent Reminder successfully");
            notificationResponse = notification.ReminderNotification(serverRem);
            assertEquals("The code of the response object should be 'SUCCESS' ", "SUCCESS", notificationResponse.getCode());
            System.out.println("Sent Reminder server successfully");
        }
        catch(InvalidRequestException error)
        {
            System.out.println(error.getMessage());
        }
    }
    @Test (expected = InvalidRequestException.class)
    public void testReminderNotificationEmailException() throws InvalidRequestException
    {

//        try
//        {
            notificationResponse = notification.ReminderNotification(null);
            assertEquals("The code of the response object should be 'FAILED' ", "FAILED", notificationResponse.getCode());

//        }
//        catch(InvalidRequestException error)
//        {
////            System.out.println(error.getMessage());
//            System.out.println("Success, caught the exception");
//        }
    }

    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(UnitTest.class);
    }
}
