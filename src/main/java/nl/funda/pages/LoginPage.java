package nl.funda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static nl.funda.helpers.WebElementUtils.click;

public class LoginPage extends BasePage {

    @FindBy(partialLinkText = "Maak account aan")
    private WebElement makeAccountButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RegisterPage clickMakeAccountButton() {
        click(makeAccountButton);
        return new RegisterPage(driver);
    }
}
