/**
 * @author themba on
 * @since 2016/03/17
 */
public class ReminderRequest implements NotificationRequest
{
    Person person;

    public ReminderRequest(Person person)
    {
        this.person = person;
        sendNotification();
    }
    @Override
    public void sendNotification()
    {
        /* send email code */
    }
}