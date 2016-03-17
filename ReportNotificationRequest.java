/**
* Sending report notifications
*
* @author  Killian Kieck
*/
import java.util.Date;

public class ReportNotificationRequest {
    
    private String name;
    private Date startDate;
    private Date endDate;
    private long duration;
    
    /**
    * Constructor to setup a notification of a report at regular intervals
    * with no end date.
    * @param name Name of the group.
    * @param startDate Starting date to begin sending notifications.
    */
    public ReportNotificationRequest(String name, Date startDate)
    {
        this.name = name;
        this.startDate = startDate;
        this.endDate = null;
    }
    
    /**
    * Constructor to setup a notification of a report at regular intervals
    * with an end date.
    * @param name Name of the group.
    * @param startDate Starting date to begin sending notifications.
    * @param endDate Ending date to stop sending notifications.
    */
    public ReportNotificationRequest(String name, Date startDate, Date endDate)
    {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        duration = this.endDate.getTime() - this.startDate.getTime();
    }
    
    /**
    * Getter function for name.
    * @return Name of the group.
    */
    public String getName()
    {
        return this.name;
    }
    
    /**
    * Getter function for duration.
    * @return Duration of the regular sending of notifications.
    */
    public long getDuration()
    {
        return this.duration;
    }
    
    /**
    * Getter function for startDate.
    * @return Starting date.
    */
    public Date getStartDate()
    {
        return this.startDate;
    }
    
    /**
    * Getter function for endDate.
    * @return Ending date.
    */ 
    public Date getEndDate()
    {
        return this.endDate;
    }
        
    /**
    * Add a publication to the report.
    * @return Nothing.
    */ 
    public void AddPublication()
    {
        
    }
    
    /**
    * Method for sending notification to group users.
    * @return Nothing.
    */ 
    public void sendNotification()
    {
        //mail(retrievePublicationsReport());
    }
    
    /**
    * Method for retrieving the publication report
    * @return Nothing.
    */ 
    public void retrievePublicationsReport()
    {
       //retrievePublicationReport
    }
}
