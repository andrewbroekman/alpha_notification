package com.codinginfinity.research.notification.defaultImpl;

/**
 * @author Killian Kieck 
 */
 
import java.util.Timer;
import java.util.Date;

public class Scheduler {
    private Schedule schedule;

    /**
    * Sets a schedule and runs it for the scheduled time.
    */
    public Scheduler() 
    {
        Timer timer = new Timer();
        Date date = new Date();
        schedule = new Schedule(new ScheduleNotification(), 0, date, timer);
        timer.scheduleAtFixedRate(schedule, schedule.getStartDate(), schedule.getDuration());
        //timer.scheduleAtFixedRate(schedule, 0, 100);
    }
}