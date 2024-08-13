package nl.funda.test;

import nl.funda.helpers.User;
import nl.funda.pages.Header;
import nl.funda.pages.HomePage;
import org.junit.jupiter.api.Test;

public class RegisterTests extends BaseTest {

    @Test
    public void registerUser() {
        User user = User.getRandomUser();

        new HomePage(driver).open()
                .onCookiesPopup().acceptAllCookies(Header.class)
                .clickLoginButton()
                .clickMakeAccountButton()
                .registerUser(user);

        // Complete registration
        user.clearPassword();
    }
}
