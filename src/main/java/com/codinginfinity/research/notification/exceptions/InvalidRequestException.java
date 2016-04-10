
package com.codinginfinity.research.notification.exceptions;

/**
 * @author COS301 - Alpha Notifications
 */
public class InvalidRequestException extends Exception
{
    public InvalidRequestException()
    {
        super();
    }

    public InvalidRequestException(String msg, Throwable source)
    {
        super(msg, source);
    }

    public InvalidRequestException(String msg)
    {
        super(msg);
    }

    public InvalidRequestException(Throwable source)
    {
        super(source);
    }

}
