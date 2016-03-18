/*
*	Author: Amy Lochner
*/
import java.util.date;
import java.net.URL;

//Class to test the sending on notifications for added/modified publications
public class sendActivityNotificationTest
{
	private static class PublicationMock
	{
		private PublicationStateMock PublicationState;

		//Should this class be a public class available to any class?
		private static class PublicationStateMock 
		{
			private Date date;
			private String reason;
			private Date envisagedPublicationDate;

			private TestPublicationState(Date date, String reason, Date envisagedPublicationDate)
			{
				this.date = date;
				this.reason = reason;
				this.envisagedPublicationDate = envisagedPublicationDate;
			}
			public Date getDate()
			{
				return this.date;
			}
			public String getReason()
			{
				return this.reason;
			}
			public Date getEnvisagedPublicationDate()
			{
				return this.envisagedPublicationDate;
			}

		}
		//Should this class be a public class available to any class?
		private static class PubicationTargetMock
		{
			private String name;
			private URL website;
		}
		public TestPublication()
		{

		}
	} 
}