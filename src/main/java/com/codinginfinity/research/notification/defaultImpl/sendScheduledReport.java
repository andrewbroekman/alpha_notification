package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.requests.NotificationRequest;
import com.codinginfinity.research.notification.requests.ReportNotificationRequest;

import java.util.Date;
import java.util.Vector;

/**
 * Created by Avinash on 2016-04-14 project notification.
 */
@SuppressWarnings("deprecated")
public class sendScheduledReport implements Runnable
{
    Schedules schedules;
    Date created;

    Vector<ReportNotificationRequest> pool = new Vector<ReportNotificationRequest>();
    boolean test = false;

    sendScheduledReport(boolean t, ReportNotificationRequest r)
    {
        created = new Date();
        test = t;
        add(r);
    }



    public void run()
    {

        System.out.println("THREAD stated");
        //System.out.println(pool.size());
        boolean flag = false;
        boolean daytrigger = false;
        boolean monthtrigger = false;
        boolean yeartrigger = false;
        int c = created.getDay();
        int m = created.getMonth();
        int y = created.getYear();
        int tmp = created.getMinutes();
        while (true)
        {


            if (c + 1 == new Date().getDay())
            {
                flag = false;
                daytrigger = true;
                c++;
                if (c > 6) c = 0;
            }

            if (m+1 == new Date().getMonth())
            {
                monthtrigger = true;
                m++;
                if (m > 11) m = 0;
            }

            if (y+1 == new Date().getYear())
            {
                yeartrigger = true;
                y++;

            }

            for (int i = 0; i < pool.size(); i++)
            {
                ReportNotificationRequest nr = pool.get(i);
//                System.out.println(pool.size());
//    System.out.println(pool.get(i).getEndDate().compareTo(new Date()));

                if (pool.get(i).getEndDate().compareTo(new Date()) < 0 && daytrigger || monthtrigger || yeartrigger)
                {
                    pool.remove(i);
                    if (pool.size() == 0 ) System.exit(0);
                }

                if (test)
                {
                    if (tmp+2 < new Date().getMinutes())
                    {
                        schedules = new Schedules(nr);
                        schedules.sendReportNotification();
                        tmp = new Date().getMinutes();

                        System.out.println("SENT from thread from test at 2 minutes");
                        System.exit(0);
                    }
                }

                if (pool.get(i).getInterval().getDuration().equals("days"))
                {
                    if (daytrigger)
                    {
                        schedules = new Schedules(nr);
                        schedules.sendReportNotification();
                        daytrigger = false;
                    }

                }

                if (pool.get(i).getInterval().getDuration().equals("weeks"))
                {
                    if (created.getDay() == nr.getEndDate().getDay())
                    {
                        schedules = new Schedules(nr);
                        schedules.sendReportNotification();
                        flag = true;
                    }
                }
                if (pool.get(i).getInterval().getDuration().equals("months"))
                {
                    if (monthtrigger)
                    {
                        schedules = new Schedules(nr);
                        schedules.sendReportNotification();
                        monthtrigger = false;
                    }
                }
                if (pool.get(i).getInterval().getDuration().equals("years"))
                {
                    if (yeartrigger)
                    {
                        schedules = new Schedules(nr);
                        schedules.sendReportNotification();
                        yeartrigger = false;
                    }
                }
            }
        }
    }

    void add(ReportNotificationRequest n)
    {
        pool.add(n);
    }

    boolean remove(String id)
    {
        for (int i = 0; i < pool.size(); i++)
        {
            if (pool.get(i).getId().equals(id))
                return true;
        }
        return false;
    }

    boolean modify(String id, String message, Date s, Date e)
    {
        for (int i = 0; i < pool.size(); i++)
        {
            if (pool.get(i).getId().equals(id))
            {
                ReportNotificationRequest nr = pool.get(i);

                if (message != null && !message.equals(""))
                {
                    nr.setMessage(message);
                }

                if (s != null)
                {
                    nr.setStartDate(s);
                }

                if (e != null)
                {
                    nr.setEndDate(e);
                }

                pool.set(i, nr);
                return true;
            }
        }
        return false;

    }


}
