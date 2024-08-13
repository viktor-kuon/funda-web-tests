package nl.funda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmAccountPage extends BasePage {

    public ConfirmAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
