package com.codinginfinity.research.notification;

/**
 * Created by Avinash on 30-Mar-16 project notification.
 * @author Avinash
 */
public class MessagingException extends Exception
{
    public MessagingException()
    {
        super();
    }

    public MessagingException(String msg, Throwable source)
    {
        super(msg, source);
    }

    public MessagingException(String msg)
    {
        super(msg);
    }

    public MessagingException(Throwable source)
    {
        super(source);
    }

}
