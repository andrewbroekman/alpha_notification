//package com.codinginfinity.research.notification.defaultImpl;
///**
// * @author Killian Kieck
// */
//import java.util.Timer;
//import java.util.Date;
//import java.util.TimerTask;
//import java.util.Calendar;
//
//public class Schedule extends TimerTask {
//
//	private Date startDate;
//	private Date endDate;
//	private long duration;
//	private ScheduleNotification scheduleNotification;
//    private Timer timer;
//
//        /**
//	 * Constructor to set private variables.
//	 *
//	 * @param	_scheduleNotification - Interface with the functions to call
//	 * @param	_days - Amount of days before repeating the request
//	 * @param	_startDate - Starting date
//         * @param	_timer - Timer object
//	 */
//	public Schedule(ScheduleNotification _scheduleNotification, int _days, Date _startDate, Timer _timer)
//	{
//		scheduleNotification = _scheduleNotification;
//		if (_days <= 0) {
//			duration = 0;
//		}
//		else {
//			duration = 24 * 60 * 60 * 1000 * _days;
//		}
//		//duration = 1000;
//		startDate = _startDate;
//		timer = _timer;
//	}
//
//	/**
//	 * Run thread to execute the command
//	*/
//        public void run() {
//                    try {
//                        //scheduleNotification.scheduleReportNotification();
//                        Calendar cal = Calendar.getInstance();
//                        Date date = cal.getTime();
//                        if (this.getEndDate() != null)
//                        {
//                                if (date.compareTo(this.getEndDate()) > 0)
//                                {
//                                    this.cancel();
//                                }
//                                else
//                                {
//                                    System.out.println("execute command");
//                                    //scheduleNotification.scheduleReportNotification();
//                                }
//                        }
//                        else
//                        {
//                            System.out.println("execute command");
//                            //scheduleNotification.scheduleReportNotification();
//                            timer.cancel(); //stop the reminder after the first command
//                        }
//                    }
//                    catch (Exception ex) {
//                            System.out.println("error running thread " + ex.getMessage());
//                    }
//        }
//
//	/**
//         *  Retrieve the end date.
//	 *  @return	Ending date
//	*/
//	public Date getEndDate() {
//		return endDate;
//	}
//
//	/**
//         *  Set the end date.
//	 *  @param	date - Date to set as the end date
//	*/
//	public void setEndDate(Date date) {
//		endDate = date;
//	}
//
//	/**
//         *  Retrieve the start date.
//	 *  @return	Starting date
//	*/
//	public Date getStartDate() {
//		//Date date;
//		//Calendar cal = Calendar.getInstance();
//		//cal.setTime(date);
//		//Calendar  = new GregorianCalendar(startDate.year, startDate.month, startDate.day, startDate.hour, startDate.minute, startDate.second);
//		return startDate;
//	}
//
//	/**
//         *  Set the start date.
//	 *  @param	date - Date to set as the start date.
//	*/
//	public void setStartDate(Date date) {
//		startDate = date;
//	}
//
//	/**
//         *  Retrieve the duration time.
//	 *  @return	Duration
//	*/
//	public long getDuration() {
//		return duration;
//	}
//
//	/**
//         *  Set the duration.
//	 *  @param	_days - amount of days before repeating the command
//	*/
//	public void setDuration(long _days) {
//		if (_days <= 0) {
//			duration = 0;
//		}
//		else {
//			duration = 24 * 60 * 60 * 1000 * _days;
//		}
//	}
//}