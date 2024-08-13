package nl.funda.helpers;

import static nl.funda.helpers.Utils.*;

public class User {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private char[] password;

    public User(final String firstName, final String lastName, final String emailAddress, final char[] password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password.clone();
    }

    public static User getRandomUser() {
        return new User(
                getRandomString(7),
                getRandomString(7),
                getRandomEmail(),
                getRandomPassword()
        );
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public char[] getPassword() {
        return password;
    }

    public void clearPassword() {
        java.util.Arrays.fill(password, '\0');
    }
}
