package com.codinginfinity.research.notification;


import java.util.Vector;

/**
 * This class contains 4 vectors which store various objects in a pool
 *
 * Created by Avinash on 01-Apr-16 project notification.
 * @author Avinash
 */


public class Notifications
{
    private Vector<ReportNotification> report;
    private Vector<ReminderNotification> reminder;
    private Vector<ActivitiesNotification> activity;
    private Vector<BroadcastNotification> broadcast;

    /**
     * Initialises empty pool
     */
    Notifications()
    {
        report = new Vector<ReportNotification>();
        reminder = new Vector<ReminderNotification>();
        activity = new Vector<ActivitiesNotification>();
        broadcast = new Vector<BroadcastNotification>();
    }

    /**
     * Adds the relative Object to the correct vector pool
     * @param rep contains all the necessary information to send a mail
     * @throws ReportNotificationException if the object is null
     */
    public void add(ReportNotification rep) throws ReportNotificationException
    {
        if (rep != null)
        {
            report.add(rep);
        }
        else
        {
            throw new ReportNotificationException("NULL");
        }
    }

    /**
     * Adds the relative Object to the correct vector pool
     * @param rem contains all the necessary information to send a mail
     * @throws ReminderNotificationException if the object is null
     */
    public void add(ReminderNotification rem) throws ReminderNotificationException
    {
        if (rem != null)
        {
            reminder.add(rem);
        }
        else
        {
            throw new ReminderNotificationException("NULL");
        }
    }

    /**
     * Adds the relative Object to the correct vector pool
     * @param act contains all the necessary information to send a mail
     * @throws ActivitiesNotificationException if the object is null
     */
    public void add(ActivitiesNotification act) throws ActivitiesNotificationException
    {
        if (act != null)
        {
            activity.add(act);
        }
        else
        {
            throw new ActivitiesNotificationException("NULL");
        }
    }

    /**
     * Adds the relative Object to the correct vector pool
     * @param broad contains all the necessary information to send a mail
     * @throws BroadcastNotificationException if the object is null
     */
    public void add(BroadcastNotification broad) throws BroadcastNotificationException
    {
        if (broad != null)
        {
            broadcast.add(broad);
        }
        else
        {
            throw new BroadcastNotificationException("NULL");
        }
    }

}
