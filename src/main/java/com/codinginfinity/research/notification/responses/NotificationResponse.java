package com.codinginfinity.research.notification.responses;

/**
 * @author COS301 - Alpha Notification
 */

public class NotificationResponse
{
    private String code = null;
    private String message = null;

    public NotificationResponse(String code)
    {
        this.code = code;
    }

    public NotificationResponse(String code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public String getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }


}
