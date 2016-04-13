package com.codinginfinity.research.notification.exceptions;

/**
 * @author COS 301 - Alpha Notifications
 */
public class RecipientException extends Exception
{
    public RecipientException()
    {
        super();
    }

    public RecipientException(String msg, Throwable source)
    {
        super(msg, source);
    }

    public RecipientException(String msg)
    {
        super(msg);
    }

    public RecipientException(Throwable source)
    {
        super(source);
    }
}

