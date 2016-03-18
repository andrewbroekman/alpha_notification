/***
* @author 	Christiaan Nel
* @since 	2016-03-17	
*/

import java.util.Date;
import com.codinginfinity.publications;

public class ActivitiesNotificationRequest extends UserNotificationRequest{
	
	private Publication publication;
	
	/**
	* Constructor for the request object to send activity notifications to a user when a
	* publication he is an author of is modified
	*
	* @param 	publication Publication for which the authors should receive activity notifications
	*/
	public ActivitiesNotificationRequest(Publication publication)
	{
		this.publication = publication;
	}
}
