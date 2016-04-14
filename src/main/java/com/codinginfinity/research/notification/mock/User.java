package com.codinginfinity.research.notification.mock;

/**
 * This class is a mock object that will be used for testing purposes.
 * Created by Themba Mbhele on 2016/03/30.
 */
public class User
{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String personType;

    /**
     * This is the constructor that will be used to create a User object.
     * @param firstName The first name of the user
     * @param lastName The surname of the user
     * @param emailAddress The email address of the user
     * @param personType the type of user that the user will be
     */
    public User(String firstName, String lastName, String emailAddress, String personType)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.personType = personType;
    }

    /**
     * This method return ths first name of the user.
     * @return This returns the firstName variable.
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * This method returns the surname of the user.
     * @return This returns the value of the lastName variable.
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * This method returns the email address of the user.
     * @return This returns the value of the emailAddress variable.
     */
    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    /**
     * This method is used to return the user type
     * @return This returns the value of the personType variable.
     */
    public String getPersonType()
    {
        return this.personType;
    }

}
