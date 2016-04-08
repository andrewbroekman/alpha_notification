package com.codinginfinity.research.notification.exceptions;

/**
 * Created by Avinash on 30-Mar-16 project notification.
 * @author Avinash
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
