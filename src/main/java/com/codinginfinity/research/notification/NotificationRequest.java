package com.codinginfinity.research.notification;

/**
 * Created by Avinash on 2016-04-07 project notification.
 * @author Avinash
 * @since
 * @param userRequest a request for a user instance
 * @param broadcastRequest a request for a broadcast instance
 */
public interface NotificationRequest
{
    UserNotificationRequest userRequest = null;
    BroadcastNotificationRequest broadcastRequest = null;

}
