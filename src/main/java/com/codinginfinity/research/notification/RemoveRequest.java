package com.codinginfinity.research.notification;

/**
 * Created by Avinash on 2016-04-07 project notification.
 * @param removeReminder request to remove an instance of reminder.
 * @param removeReport request to remove an instance of report.
 * @param removeBroadcast request to remove an instance of broadcast.
 */
public interface RemoveRequest
{
    RemoveReminderRequest removeReminder;
    RemoveReportRequest removeReport;
    RemoveBroadcastRequest removeBroadcast;
}
