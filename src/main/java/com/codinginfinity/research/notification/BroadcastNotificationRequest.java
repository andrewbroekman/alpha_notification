package com.codinginfinity.research.notification;

import java.util.Date;
import java.util.Vector;

/**
 * This class creates a Request for a broadcast and implements the wrapped object NotificationRequest
 *
 * @author	Avinash Singh
 * @since 	2016-03-20
 * @version 1.0 Notifications
 * @param userList this vector contains all the users relevant to the Broadcast.
 * @param message this is the message that gets broadcasted
 * @param start starting date
 * @param end ending date
 * @param duration the amount of time that the broadcast is relevant.
 */
public class BroadcastNotificationRequest implements NotificationRequest
{

    Vector<User> userList;
    String message;
    Date start;
    Date end;
    DurationUnit duration;

    /**
     * This constructor initializes the variables of the cass
     *
     * @param list this is the recipient list that will contain the email addresses from the User object
     * @param message this is the actual message to be sent to the recipient
     * @param start this is the start date of the notification
     * @param end this is the end data of the notification
     * @param duration this is the enumeration class for the frequency of the notification.
     */
    BroadcastNotificationRequest(Vector<User> list, String message, Date start, Date end, DurationUnit duration)
    {

        this.message = message;
        this.start = start;
        this.end = end;
        this.duration = duration;

        userList = new Vector<User>();

        for (int i = 0; i < list.size(); ++i)
        {
            userList.add(list.get(i));
        }
    }
}
