package com.codinginfinity.research.notification;

/**
 * Created by Avinash on 30-Mar-16 project notification.
 * @author Avinash
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
