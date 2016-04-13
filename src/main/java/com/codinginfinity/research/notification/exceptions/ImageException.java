package com.codinginfinity.research.notification.exceptions;

/**
 * @author COS301 - Alpha Notifications
 */
public class ImageException extends Exception
{
    public ImageException()
    {
        super();
    }

    public ImageException(String msg, Throwable source)
    {
        super(msg, source);
    }

    public ImageException(String msg)
    {
        super(msg);
    }

    public ImageException(Throwable source)
    {
        super(source);
    }
}
