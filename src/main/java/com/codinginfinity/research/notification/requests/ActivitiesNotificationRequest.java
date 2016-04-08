package com.codinginfinity.research.notification.requests;

/**
 * Created by Avinash on 2016-04-07 project notification.
 * @author Avinash
 * @version 1.0 Notifications
 */
public class ActivitiesNotificationRequest implements UserNotificationRequest
{
    User user;
    String message;

    /**
     * This constructor initializes all the variables of the class.
     *
     * @param user the User object that contains the recipient address.
     * @param message the message to send to the recipient.
     */
    ActivitiesNotificationRequest(User user, String message)
    {
        this.user = user;
        this.message = message;
    }

    @Override
    public void start()
    {

    }



}
