package nl.funda.pages;

import nl.funda.helpers.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static nl.funda.helpers.WebElementUtils.fillText;

public class RegisterPage extends BasePage {

    @FindBy(id = "FirstName")
    private WebElement firstNameInput;

    @FindBy(id = "LastName")
    private WebElement lastNameInput;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(css = "[type=submit]")
    private WebElement registerButton;

    public RegisterPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ConfirmAccountPage registerUser(final User user) {
        String password = new String(user.getPassword());

        fillText(firstNameInput, user.getFirstName());
        fillText(lastNameInput, user.getLastName());
        fillText(emailInput, user.getEmailAddress());
        fillText(passwordInput, password);
        // click Register button

        password = null;

        return new ConfirmAccountPage(driver);
    }
}
