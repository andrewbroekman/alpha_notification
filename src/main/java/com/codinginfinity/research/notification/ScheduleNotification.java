package com.codinginfinity.research.notification;

import java.util.Date;
import java.util.Vector;

/**
 * Created by Avinash on 01-Apr-16 project notification.
 * @author Avinash
 */
public class ScheduleNotification implements INotification
{
    private Notifications pool;

    /**
     * Creates a new Notifications Object that contains the pool
     */
    ScheduleNotification()
    {
        pool = new Notifications();
    }

    /**
     * Creates a new Object ReportNotification and adds it to the pool
     */
    public boolean scheduleReportNotification(String nameID, User user, Report report, String message, Date start, Date end, int frequency)
    {
        if ((nameID != null) && (user != null) && (report != null)
                && (message != null) && (start != null) && (end != null) && (frequency != -1))
        {
            pool.add(new ReportNotification(nameID, user, report, message, start, end, frequency));
            return true;
        }
        return false;
    }

    /**
     * Creates a new Object ReminderNotification and adds it to the pool
     */
    public boolean scheduleReminderNotification(String nameID, User user, String message, Date start, Date end, int frequency)
    {
        if ((nameID != null) && (user != null)
                && (message != null) && (start != null) && (end != null) && (frequency != -1))
        {
            pool.add(new ReminderNotification(nameID, user, message, start, end, frequency));
            return true;
        }
        return false;
    }

    /**
     * Creates a new Object ActivitiesNotification and adds it to the pool
     */
    public boolean scheduleActivitiesNotification(String nameID, User user, String message, Date start, Date end, int frequency)
    {
        if ((nameID != null) && (user != null)
                && (message != null) && (start != null) && (end != null) && (frequency != -1))
        {
            pool.add(new ActivitiesNotification(nameID, user, message, start, end, frequency));
            return true;
        }
        return false;
    }

    /**
     * Creates a new Object BroadcastNotification and adds it to the pool
     */
    public boolean scheduleBroadcastNotification(String nameID, Vector<Users> userPool, String message, Date start, Date end, int frequency )
    {
        if ((nameID != null) && (userPool != null)
                && (message != null) && (start != null) && (end != null) && (frequency != -1))
        {
            pool.add(new BroadcastNotification(nameID, userPool, message, start, end, frequency));
            return true;
        }
        return false;
    }


}
