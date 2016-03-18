import java.util.LinkedList;

/**
 * @author themba
 * @since 2016/03/17
 */

/* Mock Person Object */
public class Person
{
    private String firstName;
    private String surname;
    private String emailAddress;

    public Person(String firstName, String surname, String emailAddress)
    {
        this.firstName = firstName;
        this.surname = surname;
        this.emailAddress = emailAddress;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    public LinkedList getPublications()
    {
        return null;
    }
}