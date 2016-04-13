package com.codinginfinity.research.notification.defaultImpl;

import java.util.Properties;
//import com.codinginfinity.research.notification.defaultImpl.Emailer;


import java.util.Properties;
import javax.mail.Session;

/**
 * @author COS301 - Alpha Notifications
 */
public class SMTPServer
{

    public static void main(String[] args)
        {

            System.out.println("SimpleEmail Start");

            String smtpHostServer = "smtp.journaldev.com";
            String emailID = "tashan.avi@gmail.com";

            Properties props = System.getProperties();

            props.put("mail.smtp.host", smtpHostServer);

            Emailer email = new Emailer();
            email.sendMail(emailID, "Subject", "Body");
        }


}
