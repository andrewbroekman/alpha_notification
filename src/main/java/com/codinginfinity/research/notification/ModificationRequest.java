package com.codinginfinity.research.notification;

/**
 * Created by Avinash on 2016-04-07 project notification.
 * @param ModifyReminder a request object with the goal of modifying an existing reminder.
 * @param ModifyReport a request object with the goal of modifying an existing report.
 * @param ModifyBroadcast a request object with the goal of modifying an existing broadcast.
 */
public interface ModificationRequest 
{
    ModifyReminderRequest ModifyReminder;
    ModifyReportRequest ModifyReport;
    ModifyBroadcastRequest ModifyBroadcast;
}
